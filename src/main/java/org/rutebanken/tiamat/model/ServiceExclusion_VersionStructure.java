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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for SERVICE EXCLUSION.
 * 
 * <p>Java class for ServiceExclusion_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceExclusion_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}Assignment_VersionStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}ServiceExclusionGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceExclusion_VersionStructure", propOrder = {
    "excludingJourneyPatternRef",
    "startPointRef",
    "endPointRef",
    "excludedJourneyPatternRefs"
})
@XmlSeeAlso({
    ServiceExclusion.class
})
public class ServiceExclusion_VersionStructure
    extends Assignment_VersionStructure
{

    @XmlElement(name = "ExcludingJourneyPatternRef")
    protected JourneyPatternRefStructure excludingJourneyPatternRef;
    @XmlElement(name = "StartPointRef")
    protected ScheduledStopPointRefStructure startPointRef;
    @XmlElement(name = "EndPointRef")
    protected ScheduledStopPointRefStructure endPointRef;
    protected JourneyPatternRefs_RelStructure excludedJourneyPatternRefs;

    /**
     * Gets the value of the excludingJourneyPatternRef property.
     * 
     * @return
     *     possible object is
     *     {@link JourneyPatternRefStructure }
     *     
     */
    public JourneyPatternRefStructure getExcludingJourneyPatternRef() {
        return excludingJourneyPatternRef;
    }

    /**
     * Sets the value of the excludingJourneyPatternRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyPatternRefStructure }
     *     
     */
    public void setExcludingJourneyPatternRef(JourneyPatternRefStructure value) {
        this.excludingJourneyPatternRef = value;
    }

    /**
     * Gets the value of the startPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledStopPointRefStructure }
     *     
     */
    public ScheduledStopPointRefStructure getStartPointRef() {
        return startPointRef;
    }

    /**
     * Sets the value of the startPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledStopPointRefStructure }
     *     
     */
    public void setStartPointRef(ScheduledStopPointRefStructure value) {
        this.startPointRef = value;
    }

    /**
     * Gets the value of the endPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledStopPointRefStructure }
     *     
     */
    public ScheduledStopPointRefStructure getEndPointRef() {
        return endPointRef;
    }

    /**
     * Sets the value of the endPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledStopPointRefStructure }
     *     
     */
    public void setEndPointRef(ScheduledStopPointRefStructure value) {
        this.endPointRef = value;
    }

    /**
     * Gets the value of the excludedJourneyPatternRefs property.
     * 
     * @return
     *     possible object is
     *     {@link JourneyPatternRefs_RelStructure }
     *     
     */
    public JourneyPatternRefs_RelStructure getExcludedJourneyPatternRefs() {
        return excludedJourneyPatternRefs;
    }

    /**
     * Sets the value of the excludedJourneyPatternRefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyPatternRefs_RelStructure }
     *     
     */
    public void setExcludedJourneyPatternRefs(JourneyPatternRefs_RelStructure value) {
        this.excludedJourneyPatternRefs = value;
    }

}