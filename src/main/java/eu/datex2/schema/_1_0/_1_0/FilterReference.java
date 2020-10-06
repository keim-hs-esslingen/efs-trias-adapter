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
 * Details of a supplier's filter in a data exchange context.
 * 
 * <p>Java class for FilterReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilterReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deleteFilter" type="{http://datex2.eu/schema/1_0/1_0}Boolean" minOccurs="0"/>
 *         &lt;element name="filterOperationApproved" type="{http://datex2.eu/schema/1_0/1_0}Boolean" minOccurs="0"/>
 *         &lt;element name="keyFilterReference" type="{http://datex2.eu/schema/1_0/1_0}Reference"/>
 *         &lt;element name="filterReferenceExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterReference", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "deleteFilter",
    "filterOperationApproved",
    "keyFilterReference",
    "filterReferenceExtension"
})
@ToString
public class FilterReference {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Boolean deleteFilter;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Boolean filterOperationApproved;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    protected String keyFilterReference;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType filterReferenceExtension;

    /**
     * Gets the value of the deleteFilter property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleteFilter() {
        return deleteFilter;
    }

    /**
     * Sets the value of the deleteFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public FilterReference setDeleteFilter(Boolean value) {
        this.deleteFilter = value;
        return this;
    }

    /**
     * Gets the value of the filterOperationApproved property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFilterOperationApproved() {
        return filterOperationApproved;
    }

    /**
     * Sets the value of the filterOperationApproved property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public FilterReference setFilterOperationApproved(Boolean value) {
        this.filterOperationApproved = value;
        return this;
    }

    /**
     * Gets the value of the keyFilterReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyFilterReference() {
        return keyFilterReference;
    }

    /**
     * Sets the value of the keyFilterReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public FilterReference setKeyFilterReference(String value) {
        this.keyFilterReference = value;
        return this;
    }

    /**
     * Gets the value of the filterReferenceExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getFilterReferenceExtension() {
        return filterReferenceExtension;
    }

    /**
     * Sets the value of the filterReferenceExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public FilterReference setFilterReferenceExtension(ExtensionType value) {
        this.filterReferenceExtension = value;
        return this;
    }

}
