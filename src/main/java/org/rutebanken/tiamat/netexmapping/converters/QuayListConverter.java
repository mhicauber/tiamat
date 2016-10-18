package org.rutebanken.tiamat.netexmapping.converters;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.rutebanken.netex.model.Quays_RelStructure;
import org.rutebanken.tiamat.model.Quay;
import org.rutebanken.tiamat.netexmapping.NetexIdMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class QuayListConverter extends BidirectionalConverter<List<Quay>, Quays_RelStructure> {

    private static final Logger logger = LoggerFactory.getLogger(QuayListConverter.class);

    @Override
    public Quays_RelStructure convertTo(List<Quay> quays, Type<Quays_RelStructure> type) {
        Quays_RelStructure quays_relStructure = new Quays_RelStructure();

        logger.debug("Mapping {} quays to netex", quays != null ? quays.size() : 0);

        quays.forEach(quay -> {
            org.rutebanken.netex.model.Quay netexQuay = mapperFacade.map(quay, org.rutebanken.netex.model.Quay.class);
            quays_relStructure.getQuayRefOrQuay().add(netexQuay);
        });
        return quays_relStructure;
    }

    @Override
    public List<Quay> convertFrom(Quays_RelStructure quays_relStructure, Type<List<Quay>> type) {
        logger.debug("Mapping {} quays to internal model", quays_relStructure != null ? quays_relStructure.getQuayRefOrQuay().size() : 0);
        List<Quay> quays = new ArrayList<>();
        if(quays_relStructure.getQuayRefOrQuay() != null) {
            quays_relStructure.getQuayRefOrQuay().stream()
                    .filter(object -> object instanceof org.rutebanken.netex.model.Quay)
                    .map(object -> ((org.rutebanken.netex.model.Quay) object))
                    .map(netexQuay -> {
                        Quay tiamatQuay = mapperFacade.map(netexQuay, Quay.class);
                        return tiamatQuay;
                    })
                    .forEach(quay -> quays.add(quay));
        }

        quays.forEach(q -> logger.info(q.toString()));
        return quays;
    }
}