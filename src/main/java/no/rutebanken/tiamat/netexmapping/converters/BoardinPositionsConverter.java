package no.rutebanken.tiamat.netexmapping.converters;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import no.rutebanken.netex.model.AccessSpaces_RelStructure;
import no.rutebanken.netex.model.BoardingPositions_RelStructure;
import no.rutebanken.tiamat.model.AccessSpace;
import no.rutebanken.tiamat.model.BoardingPosition;

import java.util.List;

public class BoardinPositionsConverter extends BidirectionalConverter<List<BoardingPosition>, no.rutebanken.netex.model.BoardingPositions_RelStructure> {
    @Override
    public BoardingPositions_RelStructure convertTo(List<BoardingPosition> boardingPositions, Type<BoardingPositions_RelStructure> type) {
        return null;
    }

    @Override
    public List<BoardingPosition> convertFrom(BoardingPositions_RelStructure boardingPositions_relStructure, Type<List<BoardingPosition>> type) {
        return null;
    }
}