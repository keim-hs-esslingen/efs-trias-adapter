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
import javax.xml.bind.annotation.XmlType;


/**
 * High level assessment of the impact that an unplanned event or operator action defined by the situation record has on the driving conditions.
 * 
 * <p>Java class for Impact complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Impact">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="impactOnTraffic" type="{http://datex2.eu/schema/1_0/1_0}TrafficStatusEnum" minOccurs="0"/>
 *         &lt;element name="impactDetails" type="{http://datex2.eu/schema/1_0/1_0}ImpactDetails" minOccurs="0"/>
 *         &lt;element name="delays" type="{http://datex2.eu/schema/1_0/1_0}Delays" minOccurs="0"/>
 *         &lt;element name="impactExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Impact", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "impactOnTraffic",
    "impactDetails",
    "delays",
    "impactExtension"
})
public class Impact {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected TrafficStatusEnum impactOnTraffic;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ImpactDetails impactDetails;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Delays delays;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType impactExtension;

    /**
     * Gets the value of the impactOnTraffic property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficStatusEnum }
     *     
     */
    public TrafficStatusEnum getImpactOnTraffic() {
        return impactOnTraffic;
    }

    /**
     * Sets the value of the impactOnTraffic property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficStatusEnum }
     *     
     */
    public Impact setImpactOnTraffic(TrafficStatusEnum value) {
        this.impactOnTraffic = value;
        return this;
    }

    /**
     * Gets the value of the impactDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ImpactDetails }
     *     
     */
    public ImpactDetails getImpactDetails() {
        return impactDetails;
    }

    /**
     * Sets the value of the impactDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImpactDetails }
     *     
     */
    public Impact setImpactDetails(ImpactDetails value) {
        this.impactDetails = value;
        return this;
    }

    /**
     * Gets the value of the delays property.
     * 
     * @return
     *     possible object is
     *     {@link Delays }
     *     
     */
    public Delays getDelays() {
        return delays;
    }

    /**
     * Sets the value of the delays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Delays }
     *     
     */
    public Impact setDelays(Delays value) {
        this.delays = value;
        return this;
    }

    /**
     * Gets the value of the impactExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getImpactExtension() {
        return impactExtension;
    }

    /**
     * Sets the value of the impactExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public Impact setImpactExtension(ExtensionType value) {
        this.impactExtension = value;
        return this;
    }

}
