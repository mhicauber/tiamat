//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml._3.LineStringType;


/**
 * Type for a LINK.
 * 
 * <p>Java class for Link_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Link_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}DataManagedObjectStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}LinkGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Link_VersionStructure", propOrder = {
    "name",
    "distance",
    "types",
    "lineString",
    "projections",
    "passingThrough"
})
@XmlSeeAlso({
    RouteLink_VersionStructure.class,
    ServiceLink_VersionStructure.class,
    PathLink_VersionStructure.class,
    TimingLink_VersionStructure.class,
    InfrastructureLink_VersionStructure.class,
    ActivationLink_VersionStructure.class
})
public abstract class Link_VersionStructure
    extends DataManagedObjectStructure
{

    @XmlElement(name = "Name")
    protected MultilingualString name;
    @XmlElement(name = "Distance")
    protected BigDecimal distance;
    protected LinkTypeRefs_RelStructure types;
    @XmlElement(name = "LineString", namespace = "http://www.opengis.net/gml/3.2")
    protected LineStringType lineString;
    protected Projections_RelStructure projections;
    protected PointsOnLink_RelStructure passingThrough;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link MultilingualString }
     *     
     */
    public MultilingualString getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultilingualString }
     *     
     */
    public void setName(MultilingualString value) {
        this.name = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDistance(BigDecimal value) {
        this.distance = value;
    }

    /**
     * Gets the value of the types property.
     * 
     * @return
     *     possible object is
     *     {@link LinkTypeRefs_RelStructure }
     *     
     */
    public LinkTypeRefs_RelStructure getTypes() {
        return types;
    }

    /**
     * Sets the value of the types property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkTypeRefs_RelStructure }
     *     
     */
    public void setTypes(LinkTypeRefs_RelStructure value) {
        this.types = value;
    }

    /**
     * Gets the value of the lineString property.
     * 
     * @return
     *     possible object is
     *     {@link LineStringType }
     *     
     */
    public LineStringType getLineString() {
        return lineString;
    }

    /**
     * Sets the value of the lineString property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineStringType }
     *     
     */
    public void setLineString(LineStringType value) {
        this.lineString = value;
    }

    /**
     * Gets the value of the projections property.
     * 
     * @return
     *     possible object is
     *     {@link Projections_RelStructure }
     *     
     */
    public Projections_RelStructure getProjections() {
        return projections;
    }

    /**
     * Sets the value of the projections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Projections_RelStructure }
     *     
     */
    public void setProjections(Projections_RelStructure value) {
        this.projections = value;
    }

    /**
     * Gets the value of the passingThrough property.
     * 
     * @return
     *     possible object is
     *     {@link PointsOnLink_RelStructure }
     *     
     */
    public PointsOnLink_RelStructure getPassingThrough() {
        return passingThrough;
    }

    /**
     * Sets the value of the passingThrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointsOnLink_RelStructure }
     *     
     */
    public void setPassingThrough(PointsOnLink_RelStructure value) {
        this.passingThrough = value;
    }

}