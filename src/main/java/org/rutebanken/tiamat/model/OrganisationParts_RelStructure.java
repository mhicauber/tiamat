//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.06 at 10:37:32 AM CET 
//


package org.rutebanken.tiamat.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a list of ORGANISATION PARTs.
 * 
 * <p>Java class for organisationParts_RelStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="organisationParts_RelStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}containmentAggregationStructure">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{http://www.netex.org.uk/netex}OrganisationPartRef"/>
 *         &lt;element ref="{http://www.netex.org.uk/netex}OrganisationPart_"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "organisationParts_RelStructure", propOrder = {
    "organisationPartRefOrOrganisationPart_"
})
@XmlSeeAlso({
    Parts.class
})
public class OrganisationParts_RelStructure
    extends ContainmentAggregationStructure
{

    @XmlElementRefs({
        @XmlElementRef(name = "OrganisationPartRef", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrganisationPart_", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> organisationPartRefOrOrganisationPart_;

    /**
     * Gets the value of the organisationPartRefOrOrganisationPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organisationPartRefOrOrganisationPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganisationPartRefOrOrganisationPart_().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link OrganisationalUnitRefStructure }{@code >}
     * {@link JAXBElement }{@code <}{@link ControlCentre }{@code >}
     * {@link JAXBElement }{@code <}{@link OrganisationPart }{@code >}
     * {@link JAXBElement }{@code <}{@link Department }{@code >}
     * {@link JAXBElement }{@code <}{@link OperatingDepartment }{@code >}
     * {@link JAXBElement }{@code <}{@link OrganisationPartRefStructure }{@code >}
     * {@link JAXBElement }{@code <}{@link DataManagedObjectStructure }{@code >}
     * {@link JAXBElement }{@code <}{@link DepartmentRefStructure }{@code >}
     * {@link JAXBElement }{@code <}{@link ControlCentreRefStructure }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getOrganisationPartRefOrOrganisationPart_() {
        if (organisationPartRefOrOrganisationPart_ == null) {
            organisationPartRefOrOrganisationPart_ = new ArrayList<JAXBElement<?>>();
        }
        return this.organisationPartRefOrOrganisationPart_;
    }

}