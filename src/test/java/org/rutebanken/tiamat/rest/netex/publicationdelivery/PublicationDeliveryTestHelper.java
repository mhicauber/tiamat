package org.rutebanken.tiamat.rest.netex.publicationdelivery;


import org.rutebanken.netex.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.rutebanken.tiamat.netex.mapping.mapper.NetexIdMapper.ORIGINAL_ID_KEY;

import static javax.xml.bind.JAXBContext.newInstance;

@Component
public class PublicationDeliveryTestHelper {

    private static final JAXBContext jaxbContext;

    static {
        try {
            jaxbContext = newInstance(PublicationDeliveryStructure.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static JAXBContext getJaxbContext() {
        return jaxbContext;
    }

    @Autowired
    private PublicationDeliveryResource publicationDeliveryResource;


    public PublicationDeliveryStructure createPublicationDeliveryWithStopPlace(StopPlace... stopPlace) {
        SiteFrame siteFrame = new SiteFrame();
        siteFrame.setVersion("1");
        siteFrame.setId(UUID.randomUUID().toString());
        siteFrame.withStopPlaces(new StopPlacesInFrame_RelStructure()
                .withStopPlace(stopPlace));

        PublicationDeliveryStructure publicationDelivery = new PublicationDeliveryStructure()
                .withPublicationTimestamp(OffsetDateTime.now())
                .withVersion("1")
                .withParticipantRef("test")
                .withDataObjects(new PublicationDeliveryStructure.DataObjects()
                        .withCompositeFrameOrCommonFrame(new ObjectFactory().createSiteFrame(siteFrame)));

        return publicationDelivery;
    }

    public void addPathLinks(PublicationDeliveryStructure publicationDeliveryStructure, PathLink... pathLink) {
        findSiteFrame(publicationDeliveryStructure)
                .withPathLinks(new PathLinksInFrame_RelStructure().withPathLink(pathLink));
    }

    public void hasOriginalId(String expectedId, DataManagedObjectStructure object) {
        assertThat(object).isNotNull();
        assertThat(object.getKeyList()).isNotNull();
        List<String> list = object.getKeyList().getKeyValue()
                .stream()
                .peek(keyValueStructure -> System.out.println(keyValueStructure))
                .filter(keyValueStructure -> keyValueStructure.getKey().equals(ORIGINAL_ID_KEY))
                .map(keyValueStructure -> keyValueStructure.getValue())
                .collect(Collectors.toList());
        assertThat(list).hasSize(1);
        String originalIdString = list.get(0);
        assertThat(originalIdString).isNotEmpty();
        assertThat(originalIdString).isEqualTo(expectedId);
    }

    public List<StopPlace> extractStopPlaces(PublicationDeliveryStructure publicationDeliveryStructure) {
        return findSiteFrame(publicationDeliveryStructure).getStopPlaces().getStopPlace();
    }

    public List<PathLink> extractPathLinks(PublicationDeliveryStructure publicationDeliveryStructure) {

        SiteFrame siteFrame = findSiteFrame(publicationDeliveryStructure);
        if(siteFrame.getPathLinks() != null && siteFrame.getPathLinks().getPathLink() != null) {
            return siteFrame.getPathLinks().getPathLink();
        } else {
            return new ArrayList<>();
        }
    }

    public List<Quay> extractQuays(StopPlace stopPlace) {
        return stopPlace
                .getQuays()
                .getQuayRefOrQuay()
                .stream()
                .filter(object -> object instanceof Quay)
                .map(object -> ((Quay) object))
                .collect(toList());
    }

    public StopPlace findFirstStopPlace(PublicationDeliveryStructure publicationDeliveryStructure) {
        return publicationDeliveryStructure.getDataObjects()
                .getCompositeFrameOrCommonFrame()
                .stream()
                .map(JAXBElement::getValue)
                .filter(commonVersionFrameStructure -> commonVersionFrameStructure instanceof SiteFrame)
                .flatMap(commonVersionFrameStructure -> ((SiteFrame) commonVersionFrameStructure).getStopPlaces().getStopPlace().stream())
                .findFirst().get();
    }

    public PublicationDeliveryStructure postAndReturnPublicationDelivery(PublicationDeliveryStructure publicationDeliveryStructure) throws JAXBException, IOException, SAXException {
        Response response = postPublicationDelivery(publicationDeliveryStructure);

        if(! (response instanceof StreamingOutput)) {
            System.out.println("Response if not instance of streaming output");
            System.out.println(response);
        }
        StreamingOutput output = (StreamingOutput) response.getEntity();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        output.write(outputStream);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        JAXBElement element = (JAXBElement) unmarshaller.unmarshal(inputStream);
        return (PublicationDeliveryStructure) element.getValue();
    }

    public PublicationDeliveryStructure postAndReturnPublicationDelivery(String publicationDeliveryXml) throws JAXBException, IOException, SAXException {

        InputStream stream = new ByteArrayInputStream(publicationDeliveryXml.getBytes(StandardCharsets.UTF_8));

        Response response = publicationDeliveryResource.receivePublicationDelivery(stream);

        assertThat(response.getStatus()).isEqualTo(200);

        StreamingOutput output = (StreamingOutput) response.getEntity();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        output.write(outputStream);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        JAXBElement element = (JAXBElement) unmarshaller.unmarshal(inputStream);
        return (PublicationDeliveryStructure) element.getValue();

    }

    public Response postPublicationDelivery(PublicationDeliveryStructure publicationDeliveryStructure) throws JAXBException, IOException, SAXException {
        Marshaller marshaller = jaxbContext.createMarshaller();

        JAXBElement<PublicationDeliveryStructure> jaxPublicationDelivery = new ObjectFactory().createPublicationDelivery(publicationDeliveryStructure);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        marshaller.marshal(jaxPublicationDelivery, outputStream);
        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        return publicationDeliveryResource.receivePublicationDelivery(inputStream);
    }

    public SiteFrame findSiteFrame(PublicationDeliveryStructure publicationDelivery) {

        List<JAXBElement<? extends Common_VersionFrameStructure>> compositeFrameOrCommonFrame = publicationDelivery.getDataObjects().getCompositeFrameOrCommonFrame();

        Optional<SiteFrame> optionalSiteframe = compositeFrameOrCommonFrame
                .stream()
                .filter(element -> element.getValue() instanceof SiteFrame)
                .map(element -> (SiteFrame) element.getValue())
                .findFirst();

        if (optionalSiteframe.isPresent()) {
            return optionalSiteframe.get();
        }

        return compositeFrameOrCommonFrame
                .stream()
                .filter(element -> element.getValue() instanceof CompositeFrame)
                .map(element -> (CompositeFrame) element.getValue())
                .map(compositeFrame -> compositeFrame.getFrames())
                .flatMap(frames -> frames.getCommonFrame().stream())
                .filter(jaxbElement -> jaxbElement.getValue() instanceof SiteFrame)
                .map(jaxbElement -> (SiteFrame) jaxbElement.getValue())
                .findAny().get();
    }
}
