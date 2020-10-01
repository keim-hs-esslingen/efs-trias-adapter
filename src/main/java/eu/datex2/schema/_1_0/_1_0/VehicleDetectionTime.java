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


package eu.datex2.schema._1_0._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Sets of measured times relating to an individual vehicle derived from a detector at the specified measurement point.
 * 
 * <p>Java class for VehicleDetectionTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleDetectionTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arrivalTime" type="{http://datex2.eu/schema/1_0/1_0}DateTime" minOccurs="0"/>
 *         &lt;element name="exitTime" type="{http://datex2.eu/schema/1_0/1_0}DateTime" minOccurs="0"/>
 *         &lt;element name="passageTime" type="{http://datex2.eu/schema/1_0/1_0}DateTime" minOccurs="0"/>
 *         &lt;element name="presenceTime" type="{http://datex2.eu/schema/1_0/1_0}DateTime" minOccurs="0"/>
 *         &lt;element name="timeGap" type="{http://datex2.eu/schema/1_0/1_0}Seconds" minOccurs="0"/>
 *         &lt;element name="timeHeadway" type="{http://datex2.eu/schema/1_0/1_0}Seconds" minOccurs="0"/>
 *         &lt;element name="vehicleDetectionTimeExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleDetectionTime", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "arrivalTime",
    "exitTime",
    "passageTime",
    "presenceTime",
    "timeGap",
    "timeHeadway",
    "vehicleDetectionTimeExtension"
})
public class VehicleDetectionTime {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected DateTime arrivalTime;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected DateTime exitTime;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected DateTime passageTime;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected DateTime presenceTime;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Float timeGap;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Float timeHeadway;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType vehicleDetectionTimeExtension;

    /**
     * Gets the value of the arrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the value of the arrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public VehicleDetectionTime setArrivalTime(DateTime value) {
        this.arrivalTime = value;
        return this;
    }

    /**
     * Gets the value of the exitTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getExitTime() {
        return exitTime;
    }

    /**
     * Sets the value of the exitTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public VehicleDetectionTime setExitTime(DateTime value) {
        this.exitTime = value;
        return this;
    }

    /**
     * Gets the value of the passageTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getPassageTime() {
        return passageTime;
    }

    /**
     * Sets the value of the passageTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public VehicleDetectionTime setPassageTime(DateTime value) {
        this.passageTime = value;
        return this;
    }

    /**
     * Gets the value of the presenceTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getPresenceTime() {
        return presenceTime;
    }

    /**
     * Sets the value of the presenceTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public VehicleDetectionTime setPresenceTime(DateTime value) {
        this.presenceTime = value;
        return this;
    }

    /**
     * Gets the value of the timeGap property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTimeGap() {
        return timeGap;
    }

    /**
     * Sets the value of the timeGap property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public VehicleDetectionTime setTimeGap(Float value) {
        this.timeGap = value;
        return this;
    }

    /**
     * Gets the value of the timeHeadway property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTimeHeadway() {
        return timeHeadway;
    }

    /**
     * Sets the value of the timeHeadway property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public VehicleDetectionTime setTimeHeadway(Float value) {
        this.timeHeadway = value;
        return this;
    }

    /**
     * Gets the value of the vehicleDetectionTimeExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getVehicleDetectionTimeExtension() {
        return vehicleDetectionTimeExtension;
    }

    /**
     * Sets the value of the vehicleDetectionTimeExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public VehicleDetectionTime setVehicleDetectionTimeExtension(ExtensionType value) {
        this.vehicleDetectionTimeExtension = value;
        return this;
    }

}
