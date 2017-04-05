package org.rutebanken.tiamat.pelias;

import com.vividsolutions.jts.geom.Coordinate;
import org.junit.Test;
import org.rutebanken.tiamat.TiamatIntegrationTest;
import org.rutebanken.tiamat.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class CountyAndMunicipalityLookupServiceTest extends TiamatIntegrationTest {

    @Autowired
    private CountyAndMunicipalityLookupService countyAndMunicipalityLookupService;

    /**
     * Earlier, there was an issue with duplicate topographic places created when running parallel tests.
     * This test reproduced that issue. The solution was to annotate the
     * {@link CountyAndMunicipalityLookupService} with @Transactional(propagation = Propagation.NOT_SUPPORTED)
     * and use striped semaphores.
     */
    @Test
    public void reproduceIssueWithDuplicateCountiesAndMunicipalities() {

        AtomicInteger topographicPlacesCounter = new AtomicInteger();

        List<StopPlace> stopPlaces = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            StopPlace stopPlace = new StopPlace(new EmbeddableMultilingualString("Stop place " + i));
            stopPlace.setNetexId(String.valueOf(i));
            stopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(10.0393763, 59.750071)));
            stopPlaces.add(stopPlace);
        }

        stopPlaces.parallelStream()
                .forEach(stopPlace -> {
                    try {
                        countyAndMunicipalityLookupService.populateCountyAndMunicipality(stopPlace, topographicPlacesCounter);

                    } catch (InterruptedException | IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        Iterable<TopographicPlace> topographicPlaces = topographicPlaceRepository.findAll();

        final int[] size = new int[1];
        topographicPlaces.forEach(tp -> {
            size[0]++;
            System.out.println("Topographic place repo contains " + tp.getName());
        });

        assertThat(size[0])
                .as("Number of topographic places in the repository is not as expected")
                .isEqualTo(2);

        List<TopographicPlace> counties = topographicPlaceRepository
                .findByNameValueAndCountryRefRefAndTopographicPlaceType(
                        "Buskerud",
                        IanaCountryTldEnumeration.NO,
                        TopographicPlaceTypeEnumeration.COUNTY);

        assertThat(counties).hasSize(1);

        List<TopographicPlace> municipalities = topographicPlaceRepository
                .findByNameValueAndCountryRefRefAndTopographicPlaceType(
                        "Nedre Eiker",
                        IanaCountryTldEnumeration.NO,
                        TopographicPlaceTypeEnumeration.TOWN);

        assertThat(municipalities).hasSize(1);

        assertThat(topographicPlacesCounter.get()).isEqualTo(2);
    }
}