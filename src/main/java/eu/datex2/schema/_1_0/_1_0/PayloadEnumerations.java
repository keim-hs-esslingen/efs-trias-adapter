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
 * A collection of lists of enumeration values used throughout the DATEX II model.
 * 
 * <p>Java class for PayloadEnumerations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PayloadEnumerations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locationEnumerations" type="{http://datex2.eu/schema/1_0/1_0}LocationEnumerations" minOccurs="0"/>
 *         &lt;element name="payloadEnumerationsExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayloadEnumerations", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "locationEnumerations",
    "payloadEnumerationsExtension"
})
public abstract class PayloadEnumerations {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected LocationEnumerations locationEnumerations;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType payloadEnumerationsExtension;

    /**
     * Gets the value of the locationEnumerations property.
     * 
     * @return
     *     possible object is
     *     {@link LocationEnumerations }
     *     
     */
    public LocationEnumerations getLocationEnumerations() {
        return locationEnumerations;
    }

    /**
     * Sets the value of the locationEnumerations property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationEnumerations }
     *     
     */
    public PayloadEnumerations setLocationEnumerations(LocationEnumerations value) {
        this.locationEnumerations = value;
        return this;
    }

    /**
     * Gets the value of the payloadEnumerationsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getPayloadEnumerationsExtension() {
        return payloadEnumerationsExtension;
    }

    /**
     * Sets the value of the payloadEnumerationsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public PayloadEnumerations setPayloadEnumerationsExtension(ExtensionType value) {
        this.payloadEnumerationsExtension = value;
        return this;
    }

}
