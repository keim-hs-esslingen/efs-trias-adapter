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
import javax.xml.bind.annotation.XmlType;


/**
 * Measurements of precipitation.
 * 
 * <p>Java class for PrecipitationInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrecipitationInformation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/1_0/1_0}WeatherValue">
 *       &lt;sequence>
 *         &lt;element name="precipitationDetail" type="{http://datex2.eu/schema/1_0/1_0}PrecipitationDetail"/>
 *         &lt;element name="precipitationInformationExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrecipitationInformation", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "precipitationDetail",
    "precipitationInformationExtension"
})
@ToString
public class PrecipitationInformation
    extends WeatherValue
{

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    protected PrecipitationDetail precipitationDetail;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType precipitationInformationExtension;

    /**
     * Gets the value of the precipitationDetail property.
     * 
     * @return
     *     possible object is
     *     {@link PrecipitationDetail }
     *     
     */
    public PrecipitationDetail getPrecipitationDetail() {
        return precipitationDetail;
    }

    /**
     * Sets the value of the precipitationDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrecipitationDetail }
     *     
     */
    public PrecipitationInformation setPrecipitationDetail(PrecipitationDetail value) {
        this.precipitationDetail = value;
        return this;
    }

    /**
     * Gets the value of the precipitationInformationExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getPrecipitationInformationExtension() {
        return precipitationInformationExtension;
    }

    /**
     * Sets the value of the precipitationInformationExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public PrecipitationInformation setPrecipitationInformationExtension(ExtensionType value) {
        this.precipitationInformationExtension = value;
        return this;
    }

}
