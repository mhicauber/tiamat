/*
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package org.rutebanken.tiamat.service;


import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import org.rutebanken.tiamat.general.ResettableMemoizer;
import org.rutebanken.tiamat.model.StopPlace;
import org.rutebanken.tiamat.model.TariffZone;
import org.rutebanken.tiamat.model.TariffZoneRef;
import org.rutebanken.tiamat.repository.TariffZoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@Transactional
public class TariffZonesLookupService {

    private static final Logger logger = LoggerFactory.getLogger(TariffZonesLookupService.class);

    private final ResettableMemoizer<List<Pair<String, Polygon>>> tariffZones = new ResettableMemoizer<>(getTariffZones());

    private final TariffZoneRepository tariffZoneRepository;

    @Autowired
    public TariffZonesLookupService(TariffZoneRepository tariffZoneRepository) {
        this.tariffZoneRepository = tariffZoneRepository;
    }

    public void populateTariffZone(StopPlace stopPlace) {
        if(stopPlace.getCentroid() != null) {

            Set<TariffZoneRef> matches = findTariffZones(stopPlace.getCentroid())
                    .stream()
                    .filter(tariffZone -> stopPlace.getTariffZones() == null ? true : stopPlace.getTariffZones()
                            .stream()
                            .noneMatch(tariffZoneRef -> tariffZone.getNetexId().equals(tariffZoneRef.getRef())))
                    .map(tariffZone -> new TariffZoneRef(tariffZone.getNetexId()))
                    .collect(toSet());

            if(stopPlace.getTariffZones() == null) {
                stopPlace.setTariffZones(new HashSet<>());
            }
            stopPlace.getTariffZones().addAll(matches);

        }
    }

    public List<TariffZone> findTariffZones(Point point) {
        return tariffZones.get()
                       .stream()
                       .filter(pair -> point.coveredBy(pair.getSecond()))
                       .map(pair -> tariffZoneRepository.findFirstByNetexIdOrderByVersionDesc(pair.getFirst()))
                       .filter(tariffZone -> tariffZone != null)
                       .collect(toList());
    }

    public Supplier<List<Pair<String, Polygon>>> getTariffZones() {
        return () -> {
            logger.info("Fetching and memoizing tariff zones from repository");
            return tariffZoneRepository.findAll()
                    .stream()
                    .filter(tariffZone -> tariffZone.getPolygon() != null)
                    .collect(
                            groupingBy(TariffZone::getNetexId,
                                    maxBy((TariffZone tz1, TariffZone tz2) -> Long.compare(tz1.getVersion(), tz2.getVersion()))))
                    .values()
                    .stream()
                    .filter(Optional::isPresent)
                    .map(optional -> optional.get())
                    .peek(tariffZone -> logger.debug("Memoizing tariff zone {} {}", tariffZone.getNetexId(), tariffZone.getVersion()))
                    .map(tariffZone -> Pair.of(tariffZone.getNetexId(), tariffZone.getPolygon()))
                    .collect(toList());

        };
    }

    public void reset() {
        tariffZones.reset();
    }


}
