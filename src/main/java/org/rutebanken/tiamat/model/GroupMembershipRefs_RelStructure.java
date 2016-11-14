//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for a list of GROUP OF POINT memberships.
 * 
 * <p>Java class for groupMembershipRefs_RelStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="groupMembershipRefs_RelStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.netex.org.uk/netex}oneToManyRelationshipStructure">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.netex.org.uk/netex}GroupOfPointsRef_" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "groupMembershipRefs_RelStructure", propOrder = {
    "groupOfPointsRef_"
})
public class GroupMembershipRefs_RelStructure
    extends OneToManyRelationshipStructure
{

    @XmlElementRef(name = "GroupOfPointsRef_", namespace = "http://www.netex.org.uk/netex", type = JAXBElement.class)
    protected List<JAXBElement<? extends GroupOfEntitiesRefStructure>> groupOfPointsRef_;

    /**
     * Gets the value of the groupOfPointsRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupOfPointsRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupOfPointsRef_().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link StopAreaRefStructure }{@code >}
     * {@link JAXBElement }{@code <}{@link AdministrativeZoneRef }{@code >}
     * {@link JAXBElement }{@code <}{@link ZoneRefStructure }{@code >}
     * {@link JAXBElement }{@code <}{@link AccessZoneRefStructure }{@code >}
     * {@link JAXBElement }{@code <}{@link TransportAdministrativeZoneRef }{@code >}
     * {@link JAXBElement }{@code <}{@link GroupOfEntitiesRefStructure }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends GroupOfEntitiesRefStructure>> getGroupOfPointsRef_() {
        if (groupOfPointsRef_ == null) {
            groupOfPointsRef_ = new ArrayList<JAXBElement<? extends GroupOfEntitiesRefStructure>>();
        }
        return this.groupOfPointsRef_;
    }

}
