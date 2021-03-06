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
 * A group of locations defined by reference to a predefined set of locations.
 * 
 * <p>Java class for GroupOfLocationsByReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupOfLocationsByReference">
 *   &lt;complexContent>
 *     &lt;extension base="{http://datex2.eu/schema/1_0/1_0}GroupOfLocations">
 *       &lt;sequence>
 *         &lt;element name="predefinedLocationSetReference" type="{http://datex2.eu/schema/1_0/1_0}Reference"/>
 *         &lt;element name="groupOfLocationsByReferenceExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupOfLocationsByReference", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "predefinedLocationSetReference",
    "groupOfLocationsByReferenceExtension"
})
@ToString
public class GroupOfLocationsByReference
    extends GroupOfLocations
{

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    protected String predefinedLocationSetReference;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType groupOfLocationsByReferenceExtension;

    /**
     * Gets the value of the predefinedLocationSetReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPredefinedLocationSetReference() {
        return predefinedLocationSetReference;
    }

    /**
     * Sets the value of the predefinedLocationSetReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public GroupOfLocationsByReference setPredefinedLocationSetReference(String value) {
        this.predefinedLocationSetReference = value;
        return this;
    }

    /**
     * Gets the value of the groupOfLocationsByReferenceExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getGroupOfLocationsByReferenceExtension() {
        return groupOfLocationsByReferenceExtension;
    }

    /**
     * Sets the value of the groupOfLocationsByReferenceExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public GroupOfLocationsByReference setGroupOfLocationsByReferenceExtension(ExtensionType value) {
        this.groupOfLocationsByReferenceExtension = value;
        return this;
    }

}
