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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Specification of traffic management controls which affect the road network that have been instigated by the network/road operator. These controls may require either optional or mandatory compliance.
 * 
 * <p>Java class for TrafficControl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrafficControl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trafficControlOptions" type="{http://datex2.eu/schema/1_0/1_0}TrafficControlOptionsEnum" minOccurs="0"/>
 *         &lt;element name="trafficControlType" type="{http://datex2.eu/schema/1_0/1_0}TrafficControlTypeEnum" minOccurs="0"/>
 *         &lt;element name="trafficControlExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafficControl", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "trafficControlOptions",
    "trafficControlType",
    "trafficControlExtension"
})
@XmlSeeAlso({
    TemporaryLimits.class,
    Rerouting.class
})
public class TrafficControl {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected TrafficControlOptionsEnum trafficControlOptions;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected TrafficControlTypeEnum trafficControlType;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType trafficControlExtension;

    /**
     * Gets the value of the trafficControlOptions property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficControlOptionsEnum }
     *     
     */
    public TrafficControlOptionsEnum getTrafficControlOptions() {
        return trafficControlOptions;
    }

    /**
     * Sets the value of the trafficControlOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficControlOptionsEnum }
     *     
     */
    public TrafficControl setTrafficControlOptions(TrafficControlOptionsEnum value) {
        this.trafficControlOptions = value;
        return this;
    }

    /**
     * Gets the value of the trafficControlType property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficControlTypeEnum }
     *     
     */
    public TrafficControlTypeEnum getTrafficControlType() {
        return trafficControlType;
    }

    /**
     * Sets the value of the trafficControlType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficControlTypeEnum }
     *     
     */
    public TrafficControl setTrafficControlType(TrafficControlTypeEnum value) {
        this.trafficControlType = value;
        return this;
    }

    /**
     * Gets the value of the trafficControlExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getTrafficControlExtension() {
        return trafficControlExtension;
    }

    /**
     * Sets the value of the trafficControlExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public TrafficControl setTrafficControlExtension(ExtensionType value) {
        this.trafficControlExtension = value;
        return this;
    }

}
