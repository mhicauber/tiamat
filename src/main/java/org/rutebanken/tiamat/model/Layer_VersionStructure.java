//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Type for  LAYER.
 * 
 * <p>Java class for Layer_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Layer_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}GroupOfEntities_VersionStructure">
 *       &lt;group ref="{http://www.netex.org.uk/netex}LayerGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Layer_VersionStructure", propOrder = {
    "locationSystem",
    "versionFrames",
    "members"
})
@XmlSeeAlso({
    Layer.class
})
public abstract class Layer_VersionStructure
    extends GroupOfEntities_VersionStructure
{

    @XmlElement(name = "LocationSystem")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String locationSystem;
    protected VersionFrameRefs_RelStructure versionFrames;
    protected ObjectRefs_RelStructure members;

    /**
     * Gets the value of the locationSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationSystem() {
        return locationSystem;
    }

    /**
     * Sets the value of the locationSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationSystem(String value) {
        this.locationSystem = value;
    }

    /**
     * Gets the value of the versionFrames property.
     * 
     * @return
     *     possible object is
     *     {@link VersionFrameRefs_RelStructure }
     *     
     */
    public VersionFrameRefs_RelStructure getVersionFrames() {
        return versionFrames;
    }

    /**
     * Sets the value of the versionFrames property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionFrameRefs_RelStructure }
     *     
     */
    public void setVersionFrames(VersionFrameRefs_RelStructure value) {
        this.versionFrames = value;
    }

    /**
     * Gets the value of the members property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectRefs_RelStructure }
     *     
     */
    public ObjectRefs_RelStructure getMembers() {
        return members;
    }

    /**
     * Sets the value of the members property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectRefs_RelStructure }
     *     
     */
    public void setMembers(ObjectRefs_RelStructure value) {
        this.members = value;
    }

}