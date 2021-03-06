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

import lombok.ToString;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specification of the default value for traffic status on a set of predefined locations on the road network. Only when traffic status differs from this value at a location in the set need a value be sent.
 * 
 * <p>Java class for ReferenceSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReferenceSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locationSetReference" type="{http://datex2.eu/schema/1_0/1_0}Reference" minOccurs="0"/>
 *         &lt;element name="trafficStatusDefault" type="{http://datex2.eu/schema/1_0/1_0}TrafficStatusEnum" minOccurs="0"/>
 *         &lt;element name="referenceSettingsExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenceSettings", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "locationSetReference",
    "trafficStatusDefault",
    "referenceSettingsExtension"
})
@ToString
public class ReferenceSettings {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected String locationSetReference;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected TrafficStatusEnum trafficStatusDefault;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType referenceSettingsExtension;

    /**
     * Gets the value of the locationSetReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationSetReference() {
        return locationSetReference;
    }

    /**
     * Sets the value of the locationSetReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ReferenceSettings setLocationSetReference(String value) {
        this.locationSetReference = value;
        return this;
    }

    /**
     * Gets the value of the trafficStatusDefault property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficStatusEnum }
     *     
     */
    public TrafficStatusEnum getTrafficStatusDefault() {
        return trafficStatusDefault;
    }

    /**
     * Sets the value of the trafficStatusDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficStatusEnum }
     *     
     */
    public ReferenceSettings setTrafficStatusDefault(TrafficStatusEnum value) {
        this.trafficStatusDefault = value;
        return this;
    }

    /**
     * Gets the value of the referenceSettingsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getReferenceSettingsExtension() {
        return referenceSettingsExtension;
    }

    /**
     * Sets the value of the referenceSettingsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public ReferenceSettings setReferenceSettingsExtension(ExtensionType value) {
        this.referenceSettingsExtension = value;
        return this;
    }

}
