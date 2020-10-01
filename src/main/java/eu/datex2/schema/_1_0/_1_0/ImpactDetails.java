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
 * Detailed assessment of the impact that an unplanned event or operator action defined by the situation record has on the driving conditions.
 * 
 * <p>Java class for ImpactDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImpactDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capacityRemaining" type="{http://datex2.eu/schema/1_0/1_0}Percentage" minOccurs="0"/>
 *         &lt;element name="numberOfLanesRestricted" type="{http://datex2.eu/schema/1_0/1_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="numberOfOperationalLanes" type="{http://datex2.eu/schema/1_0/1_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="originalNumberOfLanes" type="{http://datex2.eu/schema/1_0/1_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="trafficRestrictionType" type="{http://datex2.eu/schema/1_0/1_0}TrafficRestrictionTypeEnum" minOccurs="0"/>
 *         &lt;element name="impactDetailsExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImpactDetails", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "capacityRemaining",
    "numberOfLanesRestricted",
    "numberOfOperationalLanes",
    "originalNumberOfLanes",
    "trafficRestrictionType",
    "impactDetailsExtension"
})
public class ImpactDetails {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Float capacityRemaining;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfLanesRestricted;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfOperationalLanes;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger originalNumberOfLanes;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected TrafficRestrictionTypeEnum trafficRestrictionType;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType impactDetailsExtension;

    /**
     * Gets the value of the capacityRemaining property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCapacityRemaining() {
        return capacityRemaining;
    }

    /**
     * Sets the value of the capacityRemaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public ImpactDetails setCapacityRemaining(Float value) {
        this.capacityRemaining = value;
        return this;
    }

    /**
     * Gets the value of the numberOfLanesRestricted property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfLanesRestricted() {
        return numberOfLanesRestricted;
    }

    /**
     * Sets the value of the numberOfLanesRestricted property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public ImpactDetails setNumberOfLanesRestricted(BigInteger value) {
        this.numberOfLanesRestricted = value;
        return this;
    }

    /**
     * Gets the value of the numberOfOperationalLanes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfOperationalLanes() {
        return numberOfOperationalLanes;
    }

    /**
     * Sets the value of the numberOfOperationalLanes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public ImpactDetails setNumberOfOperationalLanes(BigInteger value) {
        this.numberOfOperationalLanes = value;
        return this;
    }

    /**
     * Gets the value of the originalNumberOfLanes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOriginalNumberOfLanes() {
        return originalNumberOfLanes;
    }

    /**
     * Sets the value of the originalNumberOfLanes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public ImpactDetails setOriginalNumberOfLanes(BigInteger value) {
        this.originalNumberOfLanes = value;
        return this;
    }

    /**
     * Gets the value of the trafficRestrictionType property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficRestrictionTypeEnum }
     *     
     */
    public TrafficRestrictionTypeEnum getTrafficRestrictionType() {
        return trafficRestrictionType;
    }

    /**
     * Sets the value of the trafficRestrictionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficRestrictionTypeEnum }
     *     
     */
    public ImpactDetails setTrafficRestrictionType(TrafficRestrictionTypeEnum value) {
        this.trafficRestrictionType = value;
        return this;
    }

    /**
     * Gets the value of the impactDetailsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getImpactDetailsExtension() {
        return impactDetailsExtension;
    }

    /**
     * Sets the value of the impactDetailsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public ImpactDetails setImpactDetailsExtension(ExtensionType value) {
        this.impactDetailsExtension = value;
        return this;
    }

}
