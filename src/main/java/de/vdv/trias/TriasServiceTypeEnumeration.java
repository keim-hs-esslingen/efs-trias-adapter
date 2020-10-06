/*
 * MIT License
 * 
 * Copyright (c) 2020 Hochschule Esslingen
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE. 
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package de.vdv.trias;

import lombok.ToString;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TriasServiceTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TriasServiceTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Alerts"/>
 *     &lt;enumeration value="BookingInfo"/>
 *     &lt;enumeration value="ConnectionDemand"/>
 *     &lt;enumeration value="Facilities"/>
 *     &lt;enumeration value="Fares"/>
 *     &lt;enumeration value="IndividualRoutes"/>
 *     &lt;enumeration value="IndividualRoutesRefine"/>
 *     &lt;enumeration value="Locations"/>
 *     &lt;enumeration value="LocationsRefine"/>
 *     &lt;enumeration value="Maps"/>
 *     &lt;enumeration value="Positioning"/>
 *     &lt;enumeration value="ServiceRegister"/>
 *     &lt;enumeration value="StopEvents"/>
 *     &lt;enumeration value="StopEventsRefine"/>
 *     &lt;enumeration value="TripInfo"/>
 *     &lt;enumeration value="TripInfoRefine"/>
 *     &lt;enumeration value="Trips"/>
 *     &lt;enumeration value="TripsRefine"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TriasServiceTypeEnumeration", namespace = "http://www.vdv.de/trias")
@XmlEnum
public enum TriasServiceTypeEnumeration {

    @XmlEnumValue("Alerts")
    ALERTS("Alerts"),
    @XmlEnumValue("BookingInfo")
    BOOKING_INFO("BookingInfo"),
    @XmlEnumValue("ConnectionDemand")
    CONNECTION_DEMAND("ConnectionDemand"),
    @XmlEnumValue("Facilities")
    FACILITIES("Facilities"),
    @XmlEnumValue("Fares")
    FARES("Fares"),
    @XmlEnumValue("IndividualRoutes")
    INDIVIDUAL_ROUTES("IndividualRoutes"),
    @XmlEnumValue("IndividualRoutesRefine")
    INDIVIDUAL_ROUTES_REFINE("IndividualRoutesRefine"),
    @XmlEnumValue("Locations")
    LOCATIONS("Locations"),
    @XmlEnumValue("LocationsRefine")
    LOCATIONS_REFINE("LocationsRefine"),
    @XmlEnumValue("Maps")
    MAPS("Maps"),
    @XmlEnumValue("Positioning")
    POSITIONING("Positioning"),
    @XmlEnumValue("ServiceRegister")
    SERVICE_REGISTER("ServiceRegister"),
    @XmlEnumValue("StopEvents")
    STOP_EVENTS("StopEvents"),
    @XmlEnumValue("StopEventsRefine")
    STOP_EVENTS_REFINE("StopEventsRefine"),
    @XmlEnumValue("TripInfo")
    TRIP_INFO("TripInfo"),
    @XmlEnumValue("TripInfoRefine")
    TRIP_INFO_REFINE("TripInfoRefine"),
    @XmlEnumValue("Trips")
    TRIPS("Trips"),
    @XmlEnumValue("TripsRefine")
    TRIPS_REFINE("TripsRefine");
    private final String value;

    TriasServiceTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TriasServiceTypeEnumeration fromValue(String v) {
        for (TriasServiceTypeEnumeration c: TriasServiceTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
