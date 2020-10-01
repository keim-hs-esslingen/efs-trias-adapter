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

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A traffic condition which is not normal.
 * 
 * <p>Java class for AbnormalTraffic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbnormalTraffic">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/1_0/1_0}TrafficElement">
 *       &lt;sequence>
 *         &lt;element name="abnormalTrafficType" type="{http://datex2.eu/schema/1_0/1_0}AbnormalTrafficTypeEnum" minOccurs="0"/>
 *         &lt;element name="numberOfVehiclesWaiting" type="{http://datex2.eu/schema/1_0/1_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="queueLength" type="{http://datex2.eu/schema/1_0/1_0}MetresAsNonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="relativeTrafficFlow" type="{http://datex2.eu/schema/1_0/1_0}RelativeTrafficFlowEnum" minOccurs="0"/>
 *         &lt;element name="trafficTrendType" type="{http://datex2.eu/schema/1_0/1_0}TrafficTrendTypeEnum" minOccurs="0"/>
 *         &lt;element name="abnormalTrafficExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbnormalTraffic", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "abnormalTrafficType",
    "numberOfVehiclesWaiting",
    "queueLength",
    "relativeTrafficFlow",
    "trafficTrendType",
    "abnormalTrafficExtension"
})
public class AbnormalTraffic
    extends TrafficElement
{

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected AbnormalTrafficTypeEnum abnormalTrafficType;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfVehiclesWaiting;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger queueLength;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected RelativeTrafficFlowEnum relativeTrafficFlow;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected TrafficTrendTypeEnum trafficTrendType;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType abnormalTrafficExtension;

    /**
     * Gets the value of the abnormalTrafficType property.
     * 
     * @return
     *     possible object is
     *     {@link AbnormalTrafficTypeEnum }
     *     
     */
    public AbnormalTrafficTypeEnum getAbnormalTrafficType() {
        return abnormalTrafficType;
    }

    /**
     * Sets the value of the abnormalTrafficType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbnormalTrafficTypeEnum }
     *     
     */
    public AbnormalTraffic setAbnormalTrafficType(AbnormalTrafficTypeEnum value) {
        this.abnormalTrafficType = value;
        return this;
    }

    /**
     * Gets the value of the numberOfVehiclesWaiting property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfVehiclesWaiting() {
        return numberOfVehiclesWaiting;
    }

    /**
     * Sets the value of the numberOfVehiclesWaiting property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public AbnormalTraffic setNumberOfVehiclesWaiting(BigInteger value) {
        this.numberOfVehiclesWaiting = value;
        return this;
    }

    /**
     * Gets the value of the queueLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQueueLength() {
        return queueLength;
    }

    /**
     * Sets the value of the queueLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public AbnormalTraffic setQueueLength(BigInteger value) {
        this.queueLength = value;
        return this;
    }

    /**
     * Gets the value of the relativeTrafficFlow property.
     * 
     * @return
     *     possible object is
     *     {@link RelativeTrafficFlowEnum }
     *     
     */
    public RelativeTrafficFlowEnum getRelativeTrafficFlow() {
        return relativeTrafficFlow;
    }

    /**
     * Sets the value of the relativeTrafficFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelativeTrafficFlowEnum }
     *     
     */
    public AbnormalTraffic setRelativeTrafficFlow(RelativeTrafficFlowEnum value) {
        this.relativeTrafficFlow = value;
        return this;
    }

    /**
     * Gets the value of the trafficTrendType property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficTrendTypeEnum }
     *     
     */
    public TrafficTrendTypeEnum getTrafficTrendType() {
        return trafficTrendType;
    }

    /**
     * Sets the value of the trafficTrendType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficTrendTypeEnum }
     *     
     */
    public AbnormalTraffic setTrafficTrendType(TrafficTrendTypeEnum value) {
        this.trafficTrendType = value;
        return this;
    }

    /**
     * Gets the value of the abnormalTrafficExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getAbnormalTrafficExtension() {
        return abnormalTrafficExtension;
    }

    /**
     * Sets the value of the abnormalTrafficExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public AbnormalTraffic setAbnormalTrafficExtension(ExtensionType value) {
        this.abnormalTrafficExtension = value;
        return this;
    }

}
