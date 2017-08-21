package org.rutebanken.tiamat.netex.mapping.mapper;

import ma.glasnost.orika.MappingContext;
import org.junit.Test;
import org.rutebanken.netex.model.KeyListStructure;
import org.rutebanken.netex.model.KeyValueStructure;
import org.rutebanken.tiamat.model.StopPlace;
import org.rutebanken.tiamat.netex.mapping.PublicationDeliveryHelper;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rutebanken.tiamat.netex.mapping.mapper.StopPlaceMapper.IS_PARENT_STOP_PLACE;

public class StopPlaceMapperTest {

    private PublicationDeliveryHelper publicationDeliveryHelper = new PublicationDeliveryHelper();

    private StopPlaceMapper stopPlaceMapper = new StopPlaceMapper(publicationDeliveryHelper);

    @Test
    public void mapBtoA() throws Exception {


        StopPlace stopPlace = new StopPlace();
        stopPlace.setParentStopPlace(true);

        org.rutebanken.netex.model.StopPlace netexStopPlace = new org.rutebanken.netex.model.StopPlace();



        stopPlaceMapper.mapBtoA(stopPlace, netexStopPlace, new MappingContext(new HashMap<>()));

        assertThat(publicationDeliveryHelper.getValueByKey(netexStopPlace, IS_PARENT_STOP_PLACE)).isEqualTo("true");
    }

    @Test
    public void mapAtoB() throws Exception {

        StopPlace stopPlace = new StopPlace();

        org.rutebanken.netex.model.StopPlace netexStopPlace = new org.rutebanken.netex.model.StopPlace();

        netexStopPlace.setKeyList(
                new KeyListStructure()
                        .withKeyValue(new KeyValueStructure()
                                .withKey(IS_PARENT_STOP_PLACE)
                                .withValue(String.valueOf(true))));


        stopPlaceMapper.mapAtoB(netexStopPlace, stopPlace, new MappingContext(new HashMap<>()));

        assertThat(stopPlace.isParentStopPlace()).isTrue();
    }

    @Test
    public void falseIfFalseFromKeyValue() throws Exception {

        StopPlace stopPlace = new StopPlace();

        org.rutebanken.netex.model.StopPlace netexStopPlace = new org.rutebanken.netex.model.StopPlace();

        netexStopPlace.setKeyList(
                new KeyListStructure()
                        .withKeyValue(new KeyValueStructure()
                                .withKey(IS_PARENT_STOP_PLACE)
                                .withValue(String.valueOf(false))));


        stopPlaceMapper.mapAtoB(netexStopPlace, stopPlace, new MappingContext(new HashMap<>()));

        assertThat(stopPlace.isParentStopPlace()).isFalse();
    }

    @Test
    public void falseIfNotSet() throws Exception {

        StopPlace stopPlace = new StopPlace();

        org.rutebanken.netex.model.StopPlace netexStopPlace = new org.rutebanken.netex.model.StopPlace();

        stopPlaceMapper.mapAtoB(netexStopPlace, stopPlace, new MappingContext(new HashMap<>()));

        assertThat(stopPlace.isParentStopPlace()).isFalse();
    }

}