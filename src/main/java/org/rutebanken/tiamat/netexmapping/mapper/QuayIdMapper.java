package org.rutebanken.tiamat.netexmapping.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.rutebanken.tiamat.model.Quay;
import org.rutebanken.tiamat.netexmapping.NetexIdMapper;

public class QuayIdMapper extends CustomMapper<org.rutebanken.netex.model.Quay, Quay> {

    private NetexIdMapper netexIdMapper = new NetexIdMapper();

    @Override
    public void mapAtoB(org.rutebanken.netex.model.Quay netexQuay, org.rutebanken.tiamat.model.Quay internalQuay, MappingContext context) {
        netexIdMapper.toTiamatModel(netexQuay, internalQuay);
    }

    @Override
    public void mapBtoA(org.rutebanken.tiamat.model.Quay tiamatQuay, org.rutebanken.netex.model.Quay netexQuay, MappingContext context) {
        netexIdMapper.toNetexModel(tiamatQuay, netexQuay);
    }
}