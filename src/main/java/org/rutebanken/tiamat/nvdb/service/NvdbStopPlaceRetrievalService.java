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

package org.rutebanken.tiamat.nvdb.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.rutebanken.tiamat.model.EmbeddableMultilingualString;
import org.rutebanken.tiamat.nvdb.model.VegObjekt;
import org.rutebanken.tiamat.nvdb.model.VegobjekterResultat;
import org.rutebanken.tiamat.repository.StopPlaceRepository;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.rutebanken.tiamat.model.MultilingualStringEntity;
import org.rutebanken.tiamat.model.StopPlace;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This service is a temporary solution for retrieval of stop place data from NVDB.
 */
@Service
public class NvdbStopPlaceRetrievalService {

    private static final Logger logger = LoggerFactory.getLogger(NvdbStopPlaceRetrievalService.class);
    private static final int EGENSKAP_HOLDEPLASS_NAVN = 3957;

    @Autowired
    private StopPlaceRepository stopPlaceRepository;

    public void fetchNvdb() {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        try {
            InputStream inputStream = Request.Get("https://www.vegvesen.no/nvdb/api/vegobjekter/487")
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute().returnContent().asStream();


            VegobjekterResultat result = mapper.readValue(inputStream, VegobjekterResultat.class);
            logger.info("Got {} objects", result.getVegObjekter().size());

            List<StopPlace> stopPlaces = result.getVegObjekter().parallelStream()
                    .filter(Objects::nonNull)
                    .map(this::mapToStopPlace)
                    .map(stopPlace ->  stopPlaceRepository.save(stopPlace))
                    .collect(Collectors.toList());


            logger.info("Saved {} stop places", stopPlaces.size());
        } catch (IOException e) {
            logger.warn("Could not fetch data from nvdb", e);
        }
    }


    public StopPlace mapToStopPlace(VegObjekt roadObject) {
        logger.info("Mapping object {}", roadObject);

        StopPlace stopPlace = new StopPlace();

        roadObject.getEgenskaper().stream()
                .filter(egenskap -> egenskap.getId().equals(EGENSKAP_HOLDEPLASS_NAVN))
                .forEach(egenskap -> {
                    stopPlace.setName(new EmbeddableMultilingualString(egenskap.getVerdi(), "no"));
                });

        return stopPlace;
    }

}
