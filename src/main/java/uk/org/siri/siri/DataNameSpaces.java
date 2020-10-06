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


package uk.org.siri.siri;

import lombok.ToString;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Name spaces.
 * 
 * <p>Java class for DataNameSpaces complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataNameSpacesStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StopPointNameSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="LineNameSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="ProductCategoryNameSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="ServiceFeatureNameSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="VehicleFeatureNameSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataNameSpacesStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "stopPointNameSpace",
    "lineNameSpace",
    "productCategoryNameSpace",
    "serviceFeatureNameSpace",
    "vehicleFeatureNameSpace"
})
@ToString
public class DataNameSpaces {

    @XmlElement(name = "StopPointNameSpace", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String stopPointNameSpace;
    @XmlElement(name = "LineNameSpace", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String lineNameSpace;
    @XmlElement(name = "ProductCategoryNameSpace", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String productCategoryNameSpace;
    @XmlElement(name = "ServiceFeatureNameSpace", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String serviceFeatureNameSpace;
    @XmlElement(name = "VehicleFeatureNameSpace", namespace = "http://www.siri.org.uk/siri")
    @XmlSchemaType(name = "anyURI")
    protected String vehicleFeatureNameSpace;

    /**
     * Gets the value of the stopPointNameSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopPointNameSpace() {
        return stopPointNameSpace;
    }

    /**
     * Sets the value of the stopPointNameSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public DataNameSpaces setStopPointNameSpace(String value) {
        this.stopPointNameSpace = value;
        return this;
    }

    /**
     * Gets the value of the lineNameSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineNameSpace() {
        return lineNameSpace;
    }

    /**
     * Sets the value of the lineNameSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public DataNameSpaces setLineNameSpace(String value) {
        this.lineNameSpace = value;
        return this;
    }

    /**
     * Gets the value of the productCategoryNameSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCategoryNameSpace() {
        return productCategoryNameSpace;
    }

    /**
     * Sets the value of the productCategoryNameSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public DataNameSpaces setProductCategoryNameSpace(String value) {
        this.productCategoryNameSpace = value;
        return this;
    }

    /**
     * Gets the value of the serviceFeatureNameSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceFeatureNameSpace() {
        return serviceFeatureNameSpace;
    }

    /**
     * Sets the value of the serviceFeatureNameSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public DataNameSpaces setServiceFeatureNameSpace(String value) {
        this.serviceFeatureNameSpace = value;
        return this;
    }

    /**
     * Gets the value of the vehicleFeatureNameSpace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleFeatureNameSpace() {
        return vehicleFeatureNameSpace;
    }

    /**
     * Sets the value of the vehicleFeatureNameSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public DataNameSpaces setVehicleFeatureNameSpace(String value) {
        this.vehicleFeatureNameSpace = value;
        return this;
    }

}
