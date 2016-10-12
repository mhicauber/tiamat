//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a Waiting Room EQUIPMENT.
 * 
 * <p>Java class for WaitingRoomEquipment_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WaitingRoomEquipment_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}WaitingEquipment_VersionStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}WaitingRoomGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaitingRoomEquipment_VersionStructure", propOrder = {
    "fareClass",
    "womenOnly",
    "sanitary",
    "classOfUseRef"
})
@XmlSeeAlso({
    WaitingRoomEquipment.class
})
public class WaitingRoomEquipment_VersionStructure
    extends WaitingEquipment_VersionStructure
{

    @XmlList
    @XmlElement(name = "FareClass")
    @XmlSchemaType(name = "anySimpleType")
    protected List<FareClassEnumeration> fareClass;
    @XmlElement(name = "WomenOnly")
    protected Boolean womenOnly;
    @XmlList
    @XmlElement(name = "Sanitary")
    @XmlSchemaType(name = "anySimpleType")
    protected List<SanitaryFacilityEnumeration> sanitary;
    @XmlElement(name = "ClassOfUseRef")
    protected ClassOfUseRef classOfUseRef;

    /**
     * Gets the value of the fareClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fareClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFareClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FareClassEnumeration }
     * 
     * 
     */
    public List<FareClassEnumeration> getFareClass() {
        if (fareClass == null) {
            fareClass = new ArrayList<FareClassEnumeration>();
        }
        return this.fareClass;
    }

    /**
     * Gets the value of the womenOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWomenOnly() {
        return womenOnly;
    }

    /**
     * Sets the value of the womenOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWomenOnly(Boolean value) {
        this.womenOnly = value;
    }

    /**
     * Gets the value of the sanitary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sanitary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSanitary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SanitaryFacilityEnumeration }
     * 
     * 
     */
    public List<SanitaryFacilityEnumeration> getSanitary() {
        if (sanitary == null) {
            sanitary = new ArrayList<SanitaryFacilityEnumeration>();
        }
        return this.sanitary;
    }

    /**
     * Gets the value of the classOfUseRef property.
     * 
     * @return
     *     possible object is
     *     {@link ClassOfUseRef }
     *     
     */
    public ClassOfUseRef getClassOfUseRef() {
        return classOfUseRef;
    }

    /**
     * Sets the value of the classOfUseRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassOfUseRef }
     *     
     */
    public void setClassOfUseRef(ClassOfUseRef value) {
        this.classOfUseRef = value;
    }

}