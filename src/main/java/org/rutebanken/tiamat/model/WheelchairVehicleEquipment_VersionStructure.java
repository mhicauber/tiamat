//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a WHEELCHAIR VEHICLE EQUIPMENT.
 * 
 * <p>Java class for WheelchairVehicleEquipment_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WheelchairVehicleEquipment_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}ActualVehicleEquipment_VersionStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}WheelchairVehicleEquipmentGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WheelchairVehicleEquipment_VersionStructure", propOrder = {
    "hasWheelChairSpaces",
    "numberOfWheelchairAreas",
    "widthOfAccessArea",
    "lengthOfAccessArea",
    "heightOfAccessArea",
    "wheelchairTurningCircle",
    "companionSeat"
})
@XmlSeeAlso({
    WheelchairVehicleEquipment.class
})
public class WheelchairVehicleEquipment_VersionStructure
    extends ActualVehicleEquipment_VersionStructure
{

    @XmlElement(name = "HasWheelChairSpaces")
    protected Boolean hasWheelChairSpaces;
    @XmlElement(name = "NumberOfWheelchairAreas")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfWheelchairAreas;
    @XmlElement(name = "WidthOfAccessArea")
    protected BigDecimal widthOfAccessArea;
    @XmlElement(name = "LengthOfAccessArea")
    protected BigDecimal lengthOfAccessArea;
    @XmlElement(name = "HeightOfAccessArea")
    protected BigDecimal heightOfAccessArea;
    @XmlElement(name = "WheelchairTurningCircle")
    protected BigDecimal wheelchairTurningCircle;
    @XmlElement(name = "CompanionSeat")
    protected Boolean companionSeat;

    /**
     * Gets the value of the hasWheelChairSpaces property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasWheelChairSpaces() {
        return hasWheelChairSpaces;
    }

    /**
     * Sets the value of the hasWheelChairSpaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasWheelChairSpaces(Boolean value) {
        this.hasWheelChairSpaces = value;
    }

    /**
     * Gets the value of the numberOfWheelchairAreas property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfWheelchairAreas() {
        return numberOfWheelchairAreas;
    }

    /**
     * Sets the value of the numberOfWheelchairAreas property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfWheelchairAreas(BigInteger value) {
        this.numberOfWheelchairAreas = value;
    }

    /**
     * Gets the value of the widthOfAccessArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWidthOfAccessArea() {
        return widthOfAccessArea;
    }

    /**
     * Sets the value of the widthOfAccessArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWidthOfAccessArea(BigDecimal value) {
        this.widthOfAccessArea = value;
    }

    /**
     * Gets the value of the lengthOfAccessArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLengthOfAccessArea() {
        return lengthOfAccessArea;
    }

    /**
     * Sets the value of the lengthOfAccessArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLengthOfAccessArea(BigDecimal value) {
        this.lengthOfAccessArea = value;
    }

    /**
     * Gets the value of the heightOfAccessArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeightOfAccessArea() {
        return heightOfAccessArea;
    }

    /**
     * Sets the value of the heightOfAccessArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeightOfAccessArea(BigDecimal value) {
        this.heightOfAccessArea = value;
    }

    /**
     * Gets the value of the wheelchairTurningCircle property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWheelchairTurningCircle() {
        return wheelchairTurningCircle;
    }

    /**
     * Sets the value of the wheelchairTurningCircle property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWheelchairTurningCircle(BigDecimal value) {
        this.wheelchairTurningCircle = value;
    }

    /**
     * Gets the value of the companionSeat property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompanionSeat() {
        return companionSeat;
    }

    /**
     * Sets the value of the companionSeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompanionSeat(Boolean value) {
        this.companionSeat = value;
    }

}