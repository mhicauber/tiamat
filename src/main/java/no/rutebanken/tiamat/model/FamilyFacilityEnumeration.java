//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package no.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FamilyFacilityEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FamilyFacilityEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="servicesForChildren"/>
 *     &lt;enumeration value="servicesForArmyFamilies"/>
 *     &lt;enumeration value="nurseryService"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FamilyFacilityEnumeration")
@XmlEnum
public enum FamilyFacilityEnumeration {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("servicesForChildren")
    SERVICES_FOR_CHILDREN("servicesForChildren"),
    @XmlEnumValue("servicesForArmyFamilies")
    SERVICES_FOR_ARMY_FAMILIES("servicesForArmyFamilies"),
    @XmlEnumValue("nurseryService")
    NURSERY_SERVICE("nurseryService");
    private final String value;

    FamilyFacilityEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FamilyFacilityEnumeration fromValue(String v) {
        for (FamilyFacilityEnumeration c: FamilyFacilityEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}