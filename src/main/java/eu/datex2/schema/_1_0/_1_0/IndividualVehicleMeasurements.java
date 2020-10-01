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
 * Measurements relating to individual vehicles.
 * 
 * <p>Java class for IndividualVehicleMeasurements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualVehicleMeasurements">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/1_0/1_0}TrafficValue">
 *       &lt;sequence>
 *         &lt;element name="vehicleSpeed" type="{http://datex2.eu/schema/1_0/1_0}VehicleSpeed" minOccurs="0"/>
 *         &lt;element name="vehicleDetectionTime" type="{http://datex2.eu/schema/1_0/1_0}VehicleDetectionTime" minOccurs="0"/>
 *         &lt;element name="vehicleHeadway" type="{http://datex2.eu/schema/1_0/1_0}VehicleHeadway" minOccurs="0"/>
 *         &lt;element name="individualVehicleMeasurementsExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualVehicleMeasurements", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "vehicleSpeed",
    "vehicleDetectionTime",
    "vehicleHeadway",
    "individualVehicleMeasurementsExtension"
})
public class IndividualVehicleMeasurements
    extends TrafficValue
{

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected VehicleSpeed vehicleSpeed;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected VehicleDetectionTime vehicleDetectionTime;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected VehicleHeadway vehicleHeadway;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType individualVehicleMeasurementsExtension;

    /**
     * Gets the value of the vehicleSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleSpeed }
     *     
     */
    public VehicleSpeed getVehicleSpeed() {
        return vehicleSpeed;
    }

    /**
     * Sets the value of the vehicleSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleSpeed }
     *     
     */
    public IndividualVehicleMeasurements setVehicleSpeed(VehicleSpeed value) {
        this.vehicleSpeed = value;
        return this;
    }

    /**
     * Gets the value of the vehicleDetectionTime property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleDetectionTime }
     *     
     */
    public VehicleDetectionTime getVehicleDetectionTime() {
        return vehicleDetectionTime;
    }

    /**
     * Sets the value of the vehicleDetectionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleDetectionTime }
     *     
     */
    public IndividualVehicleMeasurements setVehicleDetectionTime(VehicleDetectionTime value) {
        this.vehicleDetectionTime = value;
        return this;
    }

    /**
     * Gets the value of the vehicleHeadway property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleHeadway }
     *     
     */
    public VehicleHeadway getVehicleHeadway() {
        return vehicleHeadway;
    }

    /**
     * Sets the value of the vehicleHeadway property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleHeadway }
     *     
     */
    public IndividualVehicleMeasurements setVehicleHeadway(VehicleHeadway value) {
        this.vehicleHeadway = value;
        return this;
    }

    /**
     * Gets the value of the individualVehicleMeasurementsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getIndividualVehicleMeasurementsExtension() {
        return individualVehicleMeasurementsExtension;
    }

    /**
     * Sets the value of the individualVehicleMeasurementsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public IndividualVehicleMeasurements setIndividualVehicleMeasurementsExtension(ExtensionType value) {
        this.individualVehicleMeasurementsExtension = value;
        return this;
    }

}
