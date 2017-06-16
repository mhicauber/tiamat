package org.rutebanken.tiamat.rest.graphql;

import com.vividsolutions.jts.geom.Coordinate;
import org.junit.Test;
import org.rutebanken.tiamat.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.hamcrest.Matchers.*;

public class StopPlaceQuayMergerTest extends AbstractGraphQLResourceIntegrationTest  {

    @Autowired
    StopPlaceQuayMerger stopPlaceQuayMerger;

    @Test
    @Transactional
    public void testMergeStopPlaces() {

        StopPlace fromStopPlace = new StopPlace();
        fromStopPlace.setName(new EmbeddableMultilingualString("Name"));
        fromStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(11.1, 60.1)));
        fromStopPlace.getOriginalIds().add("TEST:StopPlace:1234");
        fromStopPlace.getOriginalIds().add("TEST:StopPlace:5678");

        Quay fromQuay = new Quay();
        fromQuay.setCompassBearing(new Float(90));
        fromQuay.setCentroid(geometryFactory.createPoint(new Coordinate(11.2, 60.2)));
        fromQuay.getOriginalIds().add("TEST:Quay:123401");
        fromQuay.getOriginalIds().add("TEST:Quay:567801");

        fromStopPlace.getQuays().add(fromQuay);

        stopPlaceVersionedSaverService.saveNewVersion(fromStopPlace);

        StopPlace toStopPlace = new StopPlace();
        toStopPlace.setName(new EmbeddableMultilingualString("Name 2"));
        toStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(11.11, 60.11)));
        toStopPlace.getOriginalIds().add("TEST:StopPlace:4321");
        toStopPlace.getOriginalIds().add("TEST:StopPlace:8765");

        Quay toQuay = new Quay();
        toQuay.setCompassBearing(new Float(90));
        toQuay.setCentroid(geometryFactory.createPoint(new Coordinate(11.21, 60.21)));
        toQuay.getOriginalIds().add("TEST:Quay:432101");
        toQuay.getOriginalIds().add("TEST:Quay:876501");

        toStopPlace.getQuays().add(toQuay);

        stopPlaceVersionedSaverService.saveNewVersion(toStopPlace);

        StopPlace mergedStopPlace = stopPlaceQuayMerger.mergeStopPlaces(fromStopPlace.getNetexId(), toStopPlace.getNetexId(), null);

        assertThat(mergedStopPlace).isNotNull();

        assertThat(toStopPlace.getOriginalIds()).isNotEmpty();
        assertThat(fromStopPlace.getOriginalIds()).isNotEmpty();

        assertThat(mergedStopPlace.getOriginalIds()).hasSize(fromStopPlace.getOriginalIds().size() + toStopPlace.getOriginalIds().size());
        assertThat(mergedStopPlace.getOriginalIds().containsAll(fromStopPlace.getOriginalIds()));

        assertThat(mergedStopPlace.getName().getValue()).matches(toStopPlace.getName().getValue());

        // assertQuays
        assertThat(mergedStopPlace.getQuays()).hasSize(2);
        mergedStopPlace.getQuays().forEach(quay -> {
            if (quay.getNetexId().equals(fromQuay.getNetexId())) {

                //The from-Quay has increased its version twice - once for terminating 'from', once for adding to 'to'
                assertThat(quay.getVersion()).isEqualTo(1 + fromQuay.getVersion());
                assertThat(quay.equals(fromQuay));

            } else if (quay.getNetexId().equals(toQuay.getNetexId())){

                assertThat(quay.getVersion()).isEqualTo(1 + toQuay.getVersion());
                assertThat(quay.equals(toQuay));

            } else {
                fail("Unknown Quay has been added");
            }
        });
    }

    @Test
    public void testMergeStopPlacesUsingGraphQL() {

        StopPlace fromStopPlace = new StopPlace();
        fromStopPlace.setName(new EmbeddableMultilingualString("Name"));
        fromStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(11.1, 60.1)));
        fromStopPlace.getOriginalIds().add("TEST:StopPlace:1234");
        fromStopPlace.getOriginalIds().add("TEST:StopPlace:5678");

        AlternativeName altName = new AlternativeName();
        altName.setNameType(NameTypeEnumeration.ALIAS);
        altName.setName(new EmbeddableMultilingualString("Navn", "no"));

        AlternativeName altName2 = new AlternativeName();
        altName2.setNameType(NameTypeEnumeration.ALIAS);
        altName2.setName(new EmbeddableMultilingualString("Name", "en"));

        fromStopPlace.getAlternativeNames().add(altName);
        fromStopPlace.getAlternativeNames().add(altName2);

        Quay fromQuay = new Quay();
        fromQuay.setCompassBearing(new Float(90));
        fromQuay.setCentroid(geometryFactory.createPoint(new Coordinate(11.2, 60.2)));
        fromQuay.getOriginalIds().add("TEST:Quay:123401");
        fromQuay.getOriginalIds().add("TEST:Quay:567801");

        fromStopPlace.getQuays().add(fromQuay);


        StopPlace toStopPlace = new StopPlace();
        toStopPlace.setName(new EmbeddableMultilingualString("Name 2"));
        toStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(11.11, 60.11)));
        toStopPlace.getOriginalIds().add("TEST:StopPlace:4321");
        toStopPlace.getOriginalIds().add("TEST:StopPlace:8765");

        AlternativeName toAltName = new AlternativeName();
        toAltName.setNameType(NameTypeEnumeration.ALIAS);
        toAltName.setName(new EmbeddableMultilingualString("Navn2", "no"));

        toStopPlace.getAlternativeNames().add(toAltName);

        Quay toQuay = new Quay();
        toQuay.setCompassBearing(new Float(90));
        toQuay.setCentroid(geometryFactory.createPoint(new Coordinate(11.21, 60.21)));
        toQuay.getAlternativeNames().add(toAltName);
        toQuay.getOriginalIds().add("TEST:Quay:432101");
        toQuay.getOriginalIds().add("TEST:Quay:876501");

        toStopPlace.getQuays().add(toQuay);


        fromStopPlace = saveStopPlaceTransactional(fromStopPlace);
        toStopPlace = saveStopPlaceTransactional(toStopPlace);

        //Calling GraphQL-api to merge StopPlaces
        String graphQlJsonQuery = "{" +
                "\"query\":\"mutation { " +
                "  stopPlace: mergeStopPlaces (" +
                "          fromStopPlaceId:\\\"" + fromStopPlace.getNetexId() + "\\\", " +
                "          toStopPlaceId:\\\"" + toStopPlace.getNetexId() + "\\\"" +
                "       ) { " +
                "  id " +
                "  importedId " +
                "  name { value } " +
                "  quays {" +
                "    id " +
                "    geometry { type coordinates } " +
                "    compassBearing " +
                "  } " +
                " } " +
                "}}\",\"variables\":\"\"}";


        Set<String> originalIds = new HashSet<>();
        originalIds.addAll(fromStopPlace.getOriginalIds());
        originalIds.addAll(toStopPlace.getOriginalIds());

        executeGraphQL(graphQlJsonQuery)
                .body("data.stopPlace.id", comparesEqualTo(toStopPlace.getNetexId()))
                .body("data.stopPlace.importedId", containsInAnyOrder(originalIds.toArray()))
                .body("data.stopPlace.quays", hasSize(fromStopPlace.getQuays().size() + toStopPlace.getQuays().size()));


    }

    @Test
    @Transactional
    public void testMergeQuays() {

        StopPlace fromStopPlace = new StopPlace();
        fromStopPlace.setName(new EmbeddableMultilingualString("Name"));
        fromStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(11.1, 60.1)));
        fromStopPlace.getOriginalIds().add("TEST:StopPlace:1234");
        fromStopPlace.getOriginalIds().add("TEST:StopPlace:5678");

        Quay fromQuay = new Quay();
        fromQuay.setCompassBearing(new Float(90));
        fromQuay.setCentroid(geometryFactory.createPoint(new Coordinate(11.2, 60.2)));
        fromQuay.getOriginalIds().add("TEST:Quay:123401");
        fromQuay.getOriginalIds().add("TEST:Quay:567801");


        Quay toQuay = new Quay();
        toQuay.setCompassBearing(new Float(90));
        toQuay.setCentroid(geometryFactory.createPoint(new Coordinate(11.21, 60.21)));
        toQuay.getOriginalIds().add("TEST:Quay:432101");
        toQuay.getOriginalIds().add("TEST:Quay:876501");

        Quay quayToKeepUnaltered = new Quay();
        quayToKeepUnaltered.setCompassBearing(new Float(180));
        quayToKeepUnaltered.setCentroid(geometryFactory.createPoint(new Coordinate(11.211, 60.211)));
        quayToKeepUnaltered.getOriginalIds().add("TEST:Quay:432102");

        fromStopPlace.getQuays().add(fromQuay);
        fromStopPlace.getQuays().add(toQuay);
        fromStopPlace.getQuays().add(quayToKeepUnaltered);

        stopPlaceVersionedSaverService.saveNewVersion(fromStopPlace);

        StopPlace mergedStopPlace = stopPlaceQuayMerger.mergeQuays(fromStopPlace.getNetexId(), fromQuay.getNetexId(), toQuay.getNetexId(), null);

        assertThat(mergedStopPlace).isNotNull();
        assertThat(mergedStopPlace.getOriginalIds()).isNotEmpty();

        // assertQuays
        assertThat(mergedStopPlace.getQuays()).hasSize(2);
        mergedStopPlace.getQuays().forEach(quay -> {
            if (quay.getNetexId().equals(toQuay.getNetexId())){

                assertThat(quay.getVersion()).isEqualTo(1 + toQuay.getVersion());
                assertThat(!quay.equals(toQuay));
                assertThat(!quay.equals(fromQuay));

            } else if (quay.getNetexId().equals(quayToKeepUnaltered.getNetexId())){

                assertThat(quay.equals(quayToKeepUnaltered));

            } else {
                fail("Unknown Quay has been added");
            }
        });

        StopPlace firstVersion = stopPlaceRepository.findFirstByNetexIdAndVersion(fromStopPlace.getNetexId(), 1);
        StopPlace secondVersion = stopPlaceRepository.findFirstByNetexIdAndVersion(fromStopPlace.getNetexId(), 2);

        assertThat(firstVersion).isNotNull();
        assertThat(secondVersion).isNotNull();
        assertThat(firstVersion.getValidBetween().getToDate()).isLessThan(Instant.now());
        assertThat(secondVersion.getValidBetween().getToDate()).isNull();
        assertThat(firstVersion.getQuays()).hasSize(3);
        assertThat(secondVersion.getQuays()).hasSize(2);

    }

    @Test
    public void testMergeQuaysUsingGraphQL() {

        StopPlace stopPlace = new StopPlace();
        stopPlace.setName(new EmbeddableMultilingualString("Name"));
        stopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(11.1, 60.1)));
        stopPlace.getOriginalIds().add("TEST:StopPlace:1234");
        stopPlace.getOriginalIds().add("TEST:StopPlace:5678");

        Quay fromQuay = new Quay();
        fromQuay.setCompassBearing(new Float(90));
        fromQuay.setCentroid(geometryFactory.createPoint(new Coordinate(11.2, 60.2)));
        fromQuay.getOriginalIds().add("TEST:Quay:123401");
        fromQuay.getOriginalIds().add("TEST:Quay:567801");


        Quay toQuay = new Quay();
        toQuay.setCompassBearing(new Float(90));
        toQuay.setCentroid(geometryFactory.createPoint(new Coordinate(11.21, 60.21)));
        toQuay.getOriginalIds().add("TEST:Quay:432101");
        toQuay.getOriginalIds().add("TEST:Quay:876501");

        Quay quayToKeepUnaltered = new Quay();
        quayToKeepUnaltered.setCompassBearing(new Float(180));
        quayToKeepUnaltered.setCentroid(geometryFactory.createPoint(new Coordinate(11.211, 60.211)));
        quayToKeepUnaltered.getOriginalIds().add("TEST:Quay:432102");

        stopPlace.getQuays().add(fromQuay);
        stopPlace.getQuays().add(toQuay);
        stopPlace.getQuays().add(quayToKeepUnaltered);

        stopPlace = saveStopPlaceTransactional(stopPlace);

        assertThat(stopPlace.getQuays()).hasSize(3);

        //Calling GraphQL-api to merge Quays
        String graphQlJsonQuery = "{" +
                "\"query\":\"mutation { " +
                "  stopPlace: mergeQuays (" +
                "          stopPlaceId:\\\"" + stopPlace.getNetexId() + "\\\", " +
                "          fromQuayId:\\\"" + fromQuay.getNetexId() + "\\\"" +
                "          toQuayId:\\\"" + toQuay.getNetexId() + "\\\"" +
                "       ) { " +
                "  id " +
                "  importedId " +
                "  name { value } " +
                "  quays {" +
                "    id " +
                "    geometry { type coordinates } " +
                "    compassBearing " +
                "    importedId " +
                "  } " +
                " } " +
                "}}\",\"variables\":\"\"}";


        Set<String> originalIds = new HashSet<>();
        originalIds.addAll(toQuay.getOriginalIds());
        originalIds.addAll(fromQuay.getOriginalIds());

        executeGraphQL(graphQlJsonQuery)
                .body("data.stopPlace.id", comparesEqualTo(stopPlace.getNetexId()))
                .body("data.stopPlace.quays", hasSize(2))
                .root("data.stopPlace.quays.find { it.id == '" +toQuay.getNetexId() + "'}")
                        .body("importedId", containsInAnyOrder(originalIds.toArray()))
                .root("data.stopPlace.quays.find { it.id == '" + quayToKeepUnaltered.getNetexId() + "'}")
                        .body("importedId", containsInAnyOrder(quayToKeepUnaltered.getOriginalIds().toArray()))
        ;
    }

    /*
     * Wrapping save-operation in separate method to complete transaction before GraphQL-request is called
     */
    @Transactional
    private StopPlace saveStopPlaceTransactional(StopPlace stopPlace) {
        return stopPlaceVersionedSaverService.saveNewVersion(stopPlace);
    }
}