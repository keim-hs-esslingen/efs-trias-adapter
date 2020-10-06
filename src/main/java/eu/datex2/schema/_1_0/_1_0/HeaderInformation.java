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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Management information relating to the data contained within a publication.
 * 
 * <p>Java class for HeaderInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeaderInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="areaOfInterest" type="{http://datex2.eu/schema/1_0/1_0}AreaOfInterestEnum" minOccurs="0"/>
 *         &lt;element name="confidentiality" type="{http://datex2.eu/schema/1_0/1_0}ConfidentialityValueEnum"/>
 *         &lt;element name="informationUsage" type="{http://datex2.eu/schema/1_0/1_0}InformationUsageEnum" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="informationStatus" type="{http://datex2.eu/schema/1_0/1_0}InformationStatusEnum"/>
 *         &lt;element name="urgency" type="{http://datex2.eu/schema/1_0/1_0}UrgencyEnum" minOccurs="0"/>
 *         &lt;element name="headerInformationExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderInformation", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "areaOfInterest",
    "confidentiality",
    "informationUsage",
    "informationStatus",
    "urgency",
    "headerInformationExtension"
})
@ToString
public class HeaderInformation {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected AreaOfInterestEnum areaOfInterest;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    @XmlSchemaType(name = "string")
    protected ConfidentialityValueEnum confidentiality;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected List<InformationUsageEnum> informationUsage;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    @XmlSchemaType(name = "string")
    protected InformationStatusEnum informationStatus;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected UrgencyEnum urgency;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType headerInformationExtension;

    /**
     * Gets the value of the areaOfInterest property.
     * 
     * @return
     *     possible object is
     *     {@link AreaOfInterestEnum }
     *     
     */
    public AreaOfInterestEnum getAreaOfInterest() {
        return areaOfInterest;
    }

    /**
     * Sets the value of the areaOfInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaOfInterestEnum }
     *     
     */
    public HeaderInformation setAreaOfInterest(AreaOfInterestEnum value) {
        this.areaOfInterest = value;
        return this;
    }

    /**
     * Gets the value of the confidentiality property.
     * 
     * @return
     *     possible object is
     *     {@link ConfidentialityValueEnum }
     *     
     */
    public ConfidentialityValueEnum getConfidentiality() {
        return confidentiality;
    }

    /**
     * Sets the value of the confidentiality property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfidentialityValueEnum }
     *     
     */
    public HeaderInformation setConfidentiality(ConfidentialityValueEnum value) {
        this.confidentiality = value;
        return this;
    }

    /**
     * Gets the value of the informationUsage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationUsage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformationUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformationUsageEnum }
     * 
     * 
     */
    public List<InformationUsageEnum> getInformationUsage() {
        if (informationUsage == null) {
            informationUsage = new ArrayList<InformationUsageEnum>();
        }
        return this.informationUsage;
    }

    /**
     * Gets the value of the informationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link InformationStatusEnum }
     *     
     */
    public InformationStatusEnum getInformationStatus() {
        return informationStatus;
    }

    /**
     * Sets the value of the informationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationStatusEnum }
     *     
     */
    public HeaderInformation setInformationStatus(InformationStatusEnum value) {
        this.informationStatus = value;
        return this;
    }

    /**
     * Gets the value of the urgency property.
     * 
     * @return
     *     possible object is
     *     {@link UrgencyEnum }
     *     
     */
    public UrgencyEnum getUrgency() {
        return urgency;
    }

    /**
     * Sets the value of the urgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link UrgencyEnum }
     *     
     */
    public HeaderInformation setUrgency(UrgencyEnum value) {
        this.urgency = value;
        return this;
    }

    /**
     * Gets the value of the headerInformationExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getHeaderInformationExtension() {
        return headerInformationExtension;
    }

    /**
     * Sets the value of the headerInformationExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public HeaderInformation setHeaderInformationExtension(ExtensionType value) {
        this.headerInformationExtension = value;
        return this;
    }

}
