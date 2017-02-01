package org.rutebanken.tiamat.dtoassembling.assembler;


import org.rutebanken.tiamat.dtoassembling.dto.StopPlaceDto;
import org.rutebanken.tiamat.model.*;
import org.rutebanken.tiamat.repository.TopographicPlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StopPlaceAssembler {

    private static final Logger logger = LoggerFactory.getLogger(StopPlaceAssembler.class);

    private PointAssembler pointAssembler;

    private TopographicPlaceRepository topographicPlaceRepository;

    private QuayAssembler quayAssembler;

    @Autowired
    public StopPlaceAssembler(PointAssembler pointAssembler, TopographicPlaceRepository topographicPlaceRepository, QuayAssembler quayAssembler) {
        this.pointAssembler = pointAssembler;
        this.topographicPlaceRepository = topographicPlaceRepository;
        this.quayAssembler = quayAssembler;
    }

    public StopPlaceDto assemble(StopPlace stopPlace, boolean assembleQuays) {
        StopPlaceDto stopPlaceDto = new StopPlaceDto();
        stopPlaceDto.id = String.valueOf(stopPlace.getId());

        stopPlaceDto.name = multiLingualStringValue(stopPlace.getName());
        stopPlaceDto.shortName = multiLingualStringValue(stopPlace.getShortName());
        stopPlaceDto.description = multiLingualStringValue(stopPlace.getDescription());
        if(stopPlace.getStopPlaceType() != null) stopPlaceDto.stopPlaceType = stopPlace.getStopPlaceType().value();
        stopPlaceDto.centroid = pointAssembler.assemble(stopPlace.getCentroid());

        if(stopPlace.isAllAreasWheelchairAccessible() != null) {
            stopPlaceDto.allAreasWheelchairAccessible = stopPlace.isAllAreasWheelchairAccessible();
        }

        if(assembleQuays) {
            stopPlaceDto.quays = stopPlace.getQuays()
                    .stream()
                    .map(quay -> quayAssembler.assemble(quay))
                    .collect(Collectors.toList());
        }

        stopPlaceDto = assembleMunicipalityAndCounty(stopPlaceDto, stopPlace);

        return stopPlaceDto;
    }

    public List<StopPlaceDto> assemble(Page<StopPlace> stopPlaces, boolean assembleQuays) {
        if(stopPlaces != null) {
            return stopPlaces.getContent()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(stopPlace -> assemble(stopPlace, assembleQuays))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public StopPlaceDto assembleMunicipalityAndCounty(StopPlaceDto stopPlaceDto, StopPlace stopPlace) {
        TopographicPlaceRefStructure topographicRef = stopPlace.getTopographicPlaceRef();

        if(topographicRef != null) {
            long municipalityId = toLong(topographicRef.getRef(), stopPlace);
            if(municipalityId == 0) return stopPlaceDto;

            logger.trace("Found reference from stop place '{}' {} to a topographic place {}", stopPlace.getName(), stopPlace.getId(), topographicRef.getRef());

            TopographicPlace municipality = topographicPlaceRepository.findOne(municipalityId);

            if (municipality == null) {
                logger.warn("Municipality was null from reference {}", topographicRef.getRef());
                return stopPlaceDto;
            }

            if (municipality.getName() != null) {
                stopPlaceDto.municipality = municipality.getName().getValue();
            }

            logger.trace("Set municipality name '{}' on stop place '{}' {}", stopPlaceDto.municipality, stopPlace.getName(), stopPlace.getId());

            TopographicPlaceRefStructure countyRef = municipality.getParentTopographicPlaceRef();
            if(countyRef != null) {

                long countyId = toLong(countyRef.getRef(), stopPlace);
                if(countyId == 0 ) return stopPlaceDto;
                TopographicPlace county = topographicPlaceRepository.findOne(countyId);

                if(county != null && county.getName() != null) {
                    logger.trace("Found county '{}' {} from municipality '{}' {}", county.getName(), county.getId(), municipality.getName(), municipality.getId());
                    stopPlaceDto.county = county.getName().getValue();
                }
            } else {
                logger.warn("Found no county reference (parent topographic place ref) from municipality '{}' {}", municipality.getName(), municipality.getId());
            }

        }

        return stopPlaceDto;
    }

    private long toLong(String ref, StopPlace stopPlace) {
        if(ref == null) {
            logger.warn("Found null reference to topographic place for stop place {}", stopPlace);
            return 0L;
        }
        try {
            return Long.valueOf(ref);
        } catch (NumberFormatException e) {
            logger.warn("Cannot parse topographic place ref {} to long, and can therefore not look it up from the repository. During assembal of stop place to DTO: {}", ref, stopPlace);
        }
        return 0L;
    }

    public String multiLingualStringValue(EmbeddableMultilingualString multilingualString) {

        if(multilingualString != null) {
            return multilingualString.getValue();
        }
        return null;
    }

}