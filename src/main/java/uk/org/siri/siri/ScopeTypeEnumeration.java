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


package uk.org.siri.siri;

import lombok.ToString;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScopeTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScopeTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="general"/>
 *     &lt;enumeration value="operator"/>
 *     &lt;enumeration value="network"/>
 *     &lt;enumeration value="route"/>
 *     &lt;enumeration value="line"/>
 *     &lt;enumeration value="place"/>
 *     &lt;enumeration value="stopPlace"/>
 *     &lt;enumeration value="stopPlaceComponent"/>
 *     &lt;enumeration value="stopPoint"/>
 *     &lt;enumeration value="vehicleJourney"/>
 *     &lt;enumeration value="datedVehicleJourney"/>
 *     &lt;enumeration value="connectionLink"/>
 *     &lt;enumeration value="interchange"/>
 *     &lt;enumeration value="road"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScopeTypeEnumeration", namespace = "http://www.siri.org.uk/siri")
@XmlEnum
public enum ScopeTypeEnumeration {

    @XmlEnumValue("general")
    GENERAL("general"),
    @XmlEnumValue("operator")
    OPERATOR("operator"),
    @XmlEnumValue("network")
    NETWORK("network"),
    @XmlEnumValue("route")
    ROUTE("route"),
    @XmlEnumValue("line")
    LINE("line"),
    @XmlEnumValue("place")
    PLACE("place"),
    @XmlEnumValue("stopPlace")
    STOP_PLACE("stopPlace"),
    @XmlEnumValue("stopPlaceComponent")
    STOP_PLACE_COMPONENT("stopPlaceComponent"),
    @XmlEnumValue("stopPoint")
    STOP_POINT("stopPoint"),
    @XmlEnumValue("vehicleJourney")
    VEHICLE_JOURNEY("vehicleJourney"),
    @XmlEnumValue("datedVehicleJourney")
    DATED_VEHICLE_JOURNEY("datedVehicleJourney"),
    @XmlEnumValue("connectionLink")
    CONNECTION_LINK("connectionLink"),
    @XmlEnumValue("interchange")
    INTERCHANGE("interchange"),
    @XmlEnumValue("road")
    ROAD("road");
    private final String value;

    ScopeTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScopeTypeEnumeration fromValue(String v) {
        for (ScopeTypeEnumeration c: ScopeTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
