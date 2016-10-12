//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:41:01 PM CET 
//


package org.rutebanken.tiamat.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FlexibleRouteTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FlexibleRouteTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="flexibleAreasOnly"/>
 *     &lt;enumeration value="hailAndRideSections"/>
 *     &lt;enumeration value="mixed"/>
 *     &lt;enumeration value="fixed"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FlexibleRouteTypeEnumeration")
@XmlEnum
public enum FlexibleRouteTypeEnumeration {

    @XmlEnumValue("flexibleAreasOnly")
    FLEXIBLE_AREAS_ONLY("flexibleAreasOnly"),
    @XmlEnumValue("hailAndRideSections")
    HAIL_AND_RIDE_SECTIONS("hailAndRideSections"),
    @XmlEnumValue("mixed")
    MIXED("mixed"),
    @XmlEnumValue("fixed")
    FIXED("fixed"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    FlexibleRouteTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FlexibleRouteTypeEnumeration fromValue(String v) {
        for (FlexibleRouteTypeEnumeration c: FlexibleRouteTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}