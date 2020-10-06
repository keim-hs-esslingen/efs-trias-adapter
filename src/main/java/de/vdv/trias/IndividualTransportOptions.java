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
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * Individual modes and their usage limits as stated by the passenger
 * 
 * <p>Java class for IndividualTransportOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualTransportOptionsStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mode" type="{http://www.vdv.de/trias}IndividualModesEnumeration"/>
 *         &lt;element name="MaxDistance" type="{http://www.vdv.de/trias}DistanceType" minOccurs="0"/>
 *         &lt;element name="MaxDuration" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="MinDistance" type="{http://www.vdv.de/trias}DistanceType" minOccurs="0"/>
 *         &lt;element name="MinDuration" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="Speed" type="{http://www.vdv.de/trias}OpenPercentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualTransportOptionsStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "mode",
    "maxDistance",
    "maxDuration",
    "minDistance",
    "minDuration",
    "speed"
})
@ToString
public class IndividualTransportOptions {

    @XmlElement(name = "Mode", namespace = "http://www.vdv.de/trias", required = true)
    @XmlSchemaType(name = "string")
    protected IndividualModesEnumeration mode;
    @XmlElement(name = "MaxDistance", namespace = "http://www.vdv.de/trias")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger maxDistance;
    @XmlElement(name = "MaxDuration", namespace = "http://www.vdv.de/trias")
    protected Duration maxDuration;
    @XmlElement(name = "MinDistance", namespace = "http://www.vdv.de/trias")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger minDistance;
    @XmlElement(name = "MinDuration", namespace = "http://www.vdv.de/trias")
    protected Duration minDuration;
    @XmlElement(name = "Speed", namespace = "http://www.vdv.de/trias")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger speed;

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link IndividualModesEnumeration }
     *     
     */
    public IndividualModesEnumeration getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualModesEnumeration }
     *     
     */
    public IndividualTransportOptions setMode(IndividualModesEnumeration value) {
        this.mode = value;
        return this;
    }

    /**
     * Gets the value of the maxDistance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxDistance() {
        return maxDistance;
    }

    /**
     * Sets the value of the maxDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public IndividualTransportOptions setMaxDistance(BigInteger value) {
        this.maxDistance = value;
        return this;
    }

    /**
     * Gets the value of the maxDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMaxDuration() {
        return maxDuration;
    }

    /**
     * Sets the value of the maxDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public IndividualTransportOptions setMaxDuration(Duration value) {
        this.maxDuration = value;
        return this;
    }

    /**
     * Gets the value of the minDistance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinDistance() {
        return minDistance;
    }

    /**
     * Sets the value of the minDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public IndividualTransportOptions setMinDistance(BigInteger value) {
        this.minDistance = value;
        return this;
    }

    /**
     * Gets the value of the minDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMinDuration() {
        return minDuration;
    }

    /**
     * Sets the value of the minDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public IndividualTransportOptions setMinDuration(Duration value) {
        this.minDuration = value;
        return this;
    }

    /**
     * Gets the value of the speed property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public IndividualTransportOptions setSpeed(BigInteger value) {
        this.speed = value;
        return this;
    }

}
