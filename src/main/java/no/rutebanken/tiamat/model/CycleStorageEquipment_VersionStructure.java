//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package no.rutebanken.tiamat.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a CYCLE STORAGE EQUIPMENT.
 * 
 * <p>Java class for CycleStorageEquipment_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CycleStorageEquipment_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}PlaceEquipment_VersionStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}CycleStorageEquipmentGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CycleStorageEquipment_VersionStructure", propOrder = {
    "numberOfSpaces",
    "cycleStorageType",
    "cage",
    "covered"
})
@XmlSeeAlso({
    CycleStorageEquipment.class
})
public class CycleStorageEquipment_VersionStructure
    extends PlaceEquipment_VersionStructure
{

    @XmlElement(name = "NumberOfSpaces")
    protected BigInteger numberOfSpaces;
    @XmlElement(name = "CycleStorageType")
    @XmlSchemaType(name = "normalizedString")
    protected CycleStorageEnumeration cycleStorageType;
    @XmlElement(name = "Cage")
    protected Boolean cage;
    @XmlElement(name = "Covered")
    protected Boolean covered;

    /**
     * Gets the value of the numberOfSpaces property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfSpaces() {
        return numberOfSpaces;
    }

    /**
     * Sets the value of the numberOfSpaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfSpaces(BigInteger value) {
        this.numberOfSpaces = value;
    }

    /**
     * Gets the value of the cycleStorageType property.
     * 
     * @return
     *     possible object is
     *     {@link CycleStorageEnumeration }
     *     
     */
    public CycleStorageEnumeration getCycleStorageType() {
        return cycleStorageType;
    }

    /**
     * Sets the value of the cycleStorageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CycleStorageEnumeration }
     *     
     */
    public void setCycleStorageType(CycleStorageEnumeration value) {
        this.cycleStorageType = value;
    }

    /**
     * Gets the value of the cage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCage() {
        return cage;
    }

    /**
     * Sets the value of the cage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCage(Boolean value) {
        this.cage = value;
    }

    /**
     * Gets the value of the covered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCovered() {
        return covered;
    }

    /**
     * Sets the value of the covered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCovered(Boolean value) {
        this.covered = value;
    }

}