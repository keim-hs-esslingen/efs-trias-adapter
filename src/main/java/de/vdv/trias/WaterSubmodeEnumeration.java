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
 * <p>Java class for WaterSubmodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WaterSubmodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="undefined"/>
 *     &lt;enumeration value="internationalCarFerry"/>
 *     &lt;enumeration value="nationalCarFerry"/>
 *     &lt;enumeration value="regionalCarFerry"/>
 *     &lt;enumeration value="localCarFerry"/>
 *     &lt;enumeration value="internationalPassengerFerry"/>
 *     &lt;enumeration value="nationalPassengerFerry"/>
 *     &lt;enumeration value="regionalPassengerFerry"/>
 *     &lt;enumeration value="localPassengerFerry"/>
 *     &lt;enumeration value="postBoat"/>
 *     &lt;enumeration value="trainFerry"/>
 *     &lt;enumeration value="roadFerryLink"/>
 *     &lt;enumeration value="airportBoatLink"/>
 *     &lt;enumeration value="highSpeedVehicleService"/>
 *     &lt;enumeration value="highSpeedPassengerService"/>
 *     &lt;enumeration value="sightseeingService"/>
 *     &lt;enumeration value="schoolBoat"/>
 *     &lt;enumeration value="cableFerry"/>
 *     &lt;enumeration value="riverBus"/>
 *     &lt;enumeration value="scheduledFerry"/>
 *     &lt;enumeration value="shuttleFerryService"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WaterSubmodeEnumeration", namespace = "http://www.vdv.de/trias")
@XmlEnum
public enum WaterSubmodeEnumeration {

    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("undefined")
    UNDEFINED("undefined"),
    @XmlEnumValue("internationalCarFerry")
    INTERNATIONAL_CAR_FERRY("internationalCarFerry"),
    @XmlEnumValue("nationalCarFerry")
    NATIONAL_CAR_FERRY("nationalCarFerry"),
    @XmlEnumValue("regionalCarFerry")
    REGIONAL_CAR_FERRY("regionalCarFerry"),
    @XmlEnumValue("localCarFerry")
    LOCAL_CAR_FERRY("localCarFerry"),
    @XmlEnumValue("internationalPassengerFerry")
    INTERNATIONAL_PASSENGER_FERRY("internationalPassengerFerry"),
    @XmlEnumValue("nationalPassengerFerry")
    NATIONAL_PASSENGER_FERRY("nationalPassengerFerry"),
    @XmlEnumValue("regionalPassengerFerry")
    REGIONAL_PASSENGER_FERRY("regionalPassengerFerry"),
    @XmlEnumValue("localPassengerFerry")
    LOCAL_PASSENGER_FERRY("localPassengerFerry"),
    @XmlEnumValue("postBoat")
    POST_BOAT("postBoat"),
    @XmlEnumValue("trainFerry")
    TRAIN_FERRY("trainFerry"),
    @XmlEnumValue("roadFerryLink")
    ROAD_FERRY_LINK("roadFerryLink"),
    @XmlEnumValue("airportBoatLink")
    AIRPORT_BOAT_LINK("airportBoatLink"),
    @XmlEnumValue("highSpeedVehicleService")
    HIGH_SPEED_VEHICLE_SERVICE("highSpeedVehicleService"),
    @XmlEnumValue("highSpeedPassengerService")
    HIGH_SPEED_PASSENGER_SERVICE("highSpeedPassengerService"),
    @XmlEnumValue("sightseeingService")
    SIGHTSEEING_SERVICE("sightseeingService"),
    @XmlEnumValue("schoolBoat")
    SCHOOL_BOAT("schoolBoat"),
    @XmlEnumValue("cableFerry")
    CABLE_FERRY("cableFerry"),
    @XmlEnumValue("riverBus")
    RIVER_BUS("riverBus"),
    @XmlEnumValue("scheduledFerry")
    SCHEDULED_FERRY("scheduledFerry"),
    @XmlEnumValue("shuttleFerryService")
    SHUTTLE_FERRY_SERVICE("shuttleFerryService");
    private final String value;

    WaterSubmodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WaterSubmodeEnumeration fromValue(String v) {
        for (WaterSubmodeEnumeration c: WaterSubmodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
