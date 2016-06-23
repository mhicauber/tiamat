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
 * <p>Java class for QuayTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QuayTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="airlineGate"/>
 *     &lt;enumeration value="railPlatform"/>
 *     &lt;enumeration value="metroPlatform"/>
 *     &lt;enumeration value="coachStop"/>
 *     &lt;enumeration value="busStop"/>
 *     &lt;enumeration value="busBay"/>
 *     &lt;enumeration value="tramPlatform"/>
 *     &lt;enumeration value="tramStop"/>
 *     &lt;enumeration value="boatQuay"/>
 *     &lt;enumeration value="ferryLanding"/>
 *     &lt;enumeration value="telecabinePlatform"/>
 *     &lt;enumeration value="taxiStand"/>
 *     &lt;enumeration value="setDownPlace"/>
 *     &lt;enumeration value="vehicleLoadingPlace"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "QuayTypeEnumeration")
@XmlEnum
public enum QuayTypeEnumeration {

    @XmlEnumValue("airlineGate")
    AIRLINE_GATE("airlineGate"),
    @XmlEnumValue("railPlatform")
    RAIL_PLATFORM("railPlatform"),
    @XmlEnumValue("metroPlatform")
    METRO_PLATFORM("metroPlatform"),
    @XmlEnumValue("coachStop")
    COACH_STOP("coachStop"),
    @XmlEnumValue("busStop")
    BUS_STOP("busStop"),
    @XmlEnumValue("busBay")
    BUS_BAY("busBay"),
    @XmlEnumValue("tramPlatform")
    TRAM_PLATFORM("tramPlatform"),
    @XmlEnumValue("tramStop")
    TRAM_STOP("tramStop"),
    @XmlEnumValue("boatQuay")
    BOAT_QUAY("boatQuay"),
    @XmlEnumValue("ferryLanding")
    FERRY_LANDING("ferryLanding"),
    @XmlEnumValue("telecabinePlatform")
    TELECABINE_PLATFORM("telecabinePlatform"),
    @XmlEnumValue("taxiStand")
    TAXI_STAND("taxiStand"),
    @XmlEnumValue("setDownPlace")
    SET_DOWN_PLACE("setDownPlace"),
    @XmlEnumValue("vehicleLoadingPlace")
    VEHICLE_LOADING_PLACE("vehicleLoadingPlace"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    QuayTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QuayTypeEnumeration fromValue(String v) {
        for (QuayTypeEnumeration c: QuayTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}