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
 * Wind conditions on the road. 
 * 
 * <p>Java class for Wind complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Wind">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maximumWindSpeed" type="{http://datex2.eu/schema/1_0/1_0}KilometresPerHour" minOccurs="0"/>
 *         &lt;element name="windDirectionBearing" type="{http://datex2.eu/schema/1_0/1_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="windDirectionCompass" type="{http://datex2.eu/schema/1_0/1_0}DirectionCompassEnum" minOccurs="0"/>
 *         &lt;element name="windMeasurementHeight" type="{http://datex2.eu/schema/1_0/1_0}MetresAsNonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="windSpeed" type="{http://datex2.eu/schema/1_0/1_0}KilometresPerHour" minOccurs="0"/>
 *         &lt;element name="windExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Wind", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "maximumWindSpeed",
    "windDirectionBearing",
    "windDirectionCompass",
    "windMeasurementHeight",
    "windSpeed",
    "windExtension"
})
public class Wind {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Float maximumWindSpeed;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger windDirectionBearing;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected DirectionCompassEnum windDirectionCompass;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger windMeasurementHeight;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Float windSpeed;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType windExtension;

    /**
     * Gets the value of the maximumWindSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMaximumWindSpeed() {
        return maximumWindSpeed;
    }

    /**
     * Sets the value of the maximumWindSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public Wind setMaximumWindSpeed(Float value) {
        this.maximumWindSpeed = value;
        return this;
    }

    /**
     * Gets the value of the windDirectionBearing property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWindDirectionBearing() {
        return windDirectionBearing;
    }

    /**
     * Sets the value of the windDirectionBearing property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public Wind setWindDirectionBearing(BigInteger value) {
        this.windDirectionBearing = value;
        return this;
    }

    /**
     * Gets the value of the windDirectionCompass property.
     * 
     * @return
     *     possible object is
     *     {@link DirectionCompassEnum }
     *     
     */
    public DirectionCompassEnum getWindDirectionCompass() {
        return windDirectionCompass;
    }

    /**
     * Sets the value of the windDirectionCompass property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionCompassEnum }
     *     
     */
    public Wind setWindDirectionCompass(DirectionCompassEnum value) {
        this.windDirectionCompass = value;
        return this;
    }

    /**
     * Gets the value of the windMeasurementHeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWindMeasurementHeight() {
        return windMeasurementHeight;
    }

    /**
     * Sets the value of the windMeasurementHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public Wind setWindMeasurementHeight(BigInteger value) {
        this.windMeasurementHeight = value;
        return this;
    }

    /**
     * Gets the value of the windSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindSpeed() {
        return windSpeed;
    }

    /**
     * Sets the value of the windSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public Wind setWindSpeed(Float value) {
        this.windSpeed = value;
        return this;
    }

    /**
     * Gets the value of the windExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getWindExtension() {
        return windExtension;
    }

    /**
     * Sets the value of the windExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public Wind setWindExtension(ExtensionType value) {
        this.windExtension = value;
        return this;
    }

}
