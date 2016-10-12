//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Type for a reference to a LINK.
 * 
 * <p>Java class for ModalLinkRefByValue2Structure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModalLinkRefByValue2Structure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FromPointRef" type="{http://www.netex.org.uk/netex}PointRefStructure"/>
 *         &lt;element name="ToPointRef" type="{http://www.netex.org.uk/netex}PointRefStructure"/>
 *         &lt;element ref="{http://www.netex.org.uk/netex}TypeOfLinkRef" minOccurs="0"/>
 *         &lt;sequence>
 *           &lt;element ref="{http://www.netex.org.uk/netex}VehicleMode" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.netex.org.uk/netex}ReferenceModificationDetailsGroup"/>
 *       &lt;attribute name="nameOfClass" type="{http://www.netex.org.uk/netex}NameOfClass" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModalLinkRefByValue2Structure", propOrder = {
    "fromPointRef",
    "toPointRef",
    "typeOfLinkRef",
    "vehicleMode"
})
public class ModalLinkRefByValue2Structure {

    @XmlElement(name = "FromPointRef", required = true)
    protected PointRefStructure fromPointRef;
    @XmlElement(name = "ToPointRef", required = true)
    protected PointRefStructure toPointRef;
    @XmlElement(name = "TypeOfLinkRef")
    protected TypeOfLinkRefStructure typeOfLinkRef;
    @XmlElement(name = "VehicleMode")
    @XmlSchemaType(name = "NMTOKEN")
    protected AllModesEnumeration vehicleMode;
    @XmlAttribute(name = "nameOfClass")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nameOfClass;
    @XmlAttribute(name = "created")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlAttribute(name = "changed")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar changed;
    @XmlAttribute(name = "version")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String version;

    /**
     * Gets the value of the fromPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link PointRefStructure }
     *     
     */
    public PointRefStructure getFromPointRef() {
        return fromPointRef;
    }

    /**
     * Sets the value of the fromPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointRefStructure }
     *     
     */
    public void setFromPointRef(PointRefStructure value) {
        this.fromPointRef = value;
    }

    /**
     * Gets the value of the toPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link PointRefStructure }
     *     
     */
    public PointRefStructure getToPointRef() {
        return toPointRef;
    }

    /**
     * Sets the value of the toPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointRefStructure }
     *     
     */
    public void setToPointRef(PointRefStructure value) {
        this.toPointRef = value;
    }

    /**
     * Gets the value of the typeOfLinkRef property.
     * 
     * @return
     *     possible object is
     *     {@link TypeOfLinkRefStructure }
     *     
     */
    public TypeOfLinkRefStructure getTypeOfLinkRef() {
        return typeOfLinkRef;
    }

    /**
     * Sets the value of the typeOfLinkRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeOfLinkRefStructure }
     *     
     */
    public void setTypeOfLinkRef(TypeOfLinkRefStructure value) {
        this.typeOfLinkRef = value;
    }

    /**
     * Gets the value of the vehicleMode property.
     * 
     * @return
     *     possible object is
     *     {@link AllModesEnumeration }
     *     
     */
    public AllModesEnumeration getVehicleMode() {
        return vehicleMode;
    }

    /**
     * Sets the value of the vehicleMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllModesEnumeration }
     *     
     */
    public void setVehicleMode(AllModesEnumeration value) {
        this.vehicleMode = value;
    }

    /**
     * Gets the value of the nameOfClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfClass() {
        return nameOfClass;
    }

    /**
     * Sets the value of the nameOfClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfClass(String value) {
        this.nameOfClass = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the changed property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getChanged() {
        return changed;
    }

    /**
     * Sets the value of the changed property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setChanged(XMLGregorianCalendar value) {
        this.changed = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}