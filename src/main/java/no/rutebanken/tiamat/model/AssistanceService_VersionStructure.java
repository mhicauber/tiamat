//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package no.rutebanken.tiamat.model;

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
 * Type for an ASSISTANCE SERVICE.
 * 
 * <p>Java class for AssistanceService_VersionStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssistanceService_VersionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}LocalService_VersionStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.netex.org.uk/netex}AssistanceServiceGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssistanceService_VersionStructure", propOrder = {
    "assistanceFacilityList",
    "assistanceAvailability",
    "staffing",
    "accessibilityToolList",
    "languages",
    "accessibilityTrainedStaff",
    "emergencyServiceList",
    "safetyFacilityList"
})
@XmlSeeAlso({
    AssistanceService.class
})
public class AssistanceService_VersionStructure
    extends LocalService_VersionStructure
{

    @XmlList
    @XmlElement(name = "AssistanceFacilityList")
    @XmlSchemaType(name = "anySimpleType")
    protected List<AssistanceFacilityEnumeration> assistanceFacilityList;
    @XmlElement(name = "AssistanceAvailability")
    @XmlSchemaType(name = "string")
    protected AssistanceAvailabilityEnumeration assistanceAvailability;
    @XmlElement(name = "Staffing")
    @XmlSchemaType(name = "normalizedString")
    protected StaffingEnumeration staffing;
    @XmlList
    @XmlElement(name = "AccessibilityToolList")
    @XmlSchemaType(name = "anySimpleType")
    protected List<AccessibilityToolEnumeration> accessibilityToolList;
    @XmlList
    @XmlElement(name = "Languages")
    @XmlSchemaType(name = "anySimpleType")
    protected List<String> languages;
    @XmlElement(name = "AccessibilityTrainedStaff")
    protected Boolean accessibilityTrainedStaff;
    @XmlList
    @XmlElement(name = "EmergencyServiceList")
    @XmlSchemaType(name = "anySimpleType")
    protected List<EmergencyServiceEnumeration> emergencyServiceList;
    @XmlList
    @XmlElement(name = "SafetyFacilityList")
    @XmlSchemaType(name = "anySimpleType")
    protected List<SafetyFacilityEnumeration> safetyFacilityList;

    /**
     * Gets the value of the assistanceFacilityList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assistanceFacilityList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssistanceFacilityList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssistanceFacilityEnumeration }
     * 
     * 
     */
    public List<AssistanceFacilityEnumeration> getAssistanceFacilityList() {
        if (assistanceFacilityList == null) {
            assistanceFacilityList = new ArrayList<AssistanceFacilityEnumeration>();
        }
        return this.assistanceFacilityList;
    }

    /**
     * Gets the value of the assistanceAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link AssistanceAvailabilityEnumeration }
     *     
     */
    public AssistanceAvailabilityEnumeration getAssistanceAvailability() {
        return assistanceAvailability;
    }

    /**
     * Sets the value of the assistanceAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssistanceAvailabilityEnumeration }
     *     
     */
    public void setAssistanceAvailability(AssistanceAvailabilityEnumeration value) {
        this.assistanceAvailability = value;
    }

    /**
     * Gets the value of the staffing property.
     * 
     * @return
     *     possible object is
     *     {@link StaffingEnumeration }
     *     
     */
    public StaffingEnumeration getStaffing() {
        return staffing;
    }

    /**
     * Sets the value of the staffing property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffingEnumeration }
     *     
     */
    public void setStaffing(StaffingEnumeration value) {
        this.staffing = value;
    }

    /**
     * Gets the value of the accessibilityToolList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessibilityToolList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessibilityToolList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessibilityToolEnumeration }
     * 
     * 
     */
    public List<AccessibilityToolEnumeration> getAccessibilityToolList() {
        if (accessibilityToolList == null) {
            accessibilityToolList = new ArrayList<AccessibilityToolEnumeration>();
        }
        return this.accessibilityToolList;
    }

    /**
     * Gets the value of the languages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the languages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLanguages() {
        if (languages == null) {
            languages = new ArrayList<String>();
        }
        return this.languages;
    }

    /**
     * Gets the value of the accessibilityTrainedStaff property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAccessibilityTrainedStaff() {
        return accessibilityTrainedStaff;
    }

    /**
     * Sets the value of the accessibilityTrainedStaff property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAccessibilityTrainedStaff(Boolean value) {
        this.accessibilityTrainedStaff = value;
    }

    /**
     * Gets the value of the emergencyServiceList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emergencyServiceList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmergencyServiceList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmergencyServiceEnumeration }
     * 
     * 
     */
    public List<EmergencyServiceEnumeration> getEmergencyServiceList() {
        if (emergencyServiceList == null) {
            emergencyServiceList = new ArrayList<EmergencyServiceEnumeration>();
        }
        return this.emergencyServiceList;
    }

    /**
     * Gets the value of the safetyFacilityList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the safetyFacilityList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSafetyFacilityList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SafetyFacilityEnumeration }
     * 
     * 
     */
    public List<SafetyFacilityEnumeration> getSafetyFacilityList() {
        if (safetyFacilityList == null) {
            safetyFacilityList = new ArrayList<SafetyFacilityEnumeration>();
        }
        return this.safetyFacilityList;
    }

}