//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for SIMPLE FEATURE.
 * 
 * <p>Java class for SimpleFeature_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleFeature_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}GroupOfPoints_VersionStructure">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.netex.org.uk/netex}ZoneRef" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleFeature_VersionStructure", propOrder = {
    "zoneRef"
})
@XmlSeeAlso({
    SimpleFeature.class
})
public class SimpleFeature_VersionStructure
    extends GroupOfPoints_VersionStructure
{

    @XmlElementRef(name = "ZoneRef", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends ZoneRefStructure> zoneRef;

    /**
     * Gets the value of the zoneRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StopAreaRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link AdministrativeZoneRef }{@code >}
     *     {@link JAXBElement }{@code <}{@link ZoneRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link AccessZoneRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link TransportAdministrativeZoneRef }{@code >}
     *     
     */
    public JAXBElement<? extends ZoneRefStructure> getZoneRef() {
        return zoneRef;
    }

    /**
     * Sets the value of the zoneRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StopAreaRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link AdministrativeZoneRef }{@code >}
     *     {@link JAXBElement }{@code <}{@link ZoneRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link AccessZoneRefStructure }{@code >}
     *     {@link JAXBElement }{@code <}{@link TransportAdministrativeZoneRef }{@code >}
     *     
     */
    public void setZoneRef(JAXBElement<? extends ZoneRefStructure> value) {
        this.zoneRef = value;
    }

}
