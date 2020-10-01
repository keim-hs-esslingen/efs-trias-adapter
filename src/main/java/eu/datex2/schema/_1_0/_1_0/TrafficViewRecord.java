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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * An identifiable instance of a single record within a traffic view.
 * 
 * <p>Java class for TrafficViewRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrafficViewRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordSequenceNumber" type="{http://datex2.eu/schema/1_0/1_0}NonNegativeInteger"/>
 *         &lt;element name="trafficElement" type="{http://datex2.eu/schema/1_0/1_0}TrafficElement" minOccurs="0"/>
 *         &lt;element name="operatorAction" type="{http://datex2.eu/schema/1_0/1_0}OperatorAction" minOccurs="0"/>
 *         &lt;element name="elaboratedData" type="{http://datex2.eu/schema/1_0/1_0}ElaboratedData" minOccurs="0"/>
 *         &lt;element name="cctvimages" type="{http://datex2.eu/schema/1_0/1_0}CCTVImages" minOccurs="0"/>
 *         &lt;element name="trafficViewRecordExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafficViewRecord", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "recordSequenceNumber",
    "trafficElement",
    "operatorAction",
    "elaboratedData",
    "cctvimages",
    "trafficViewRecordExtension"
})
public class TrafficViewRecord {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger recordSequenceNumber;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected TrafficElement trafficElement;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected OperatorAction operatorAction;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ElaboratedData elaboratedData;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected CCTVImages cctvimages;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType trafficViewRecordExtension;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the recordSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRecordSequenceNumber() {
        return recordSequenceNumber;
    }

    /**
     * Sets the value of the recordSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public TrafficViewRecord setRecordSequenceNumber(BigInteger value) {
        this.recordSequenceNumber = value;
        return this;
    }

    /**
     * Gets the value of the trafficElement property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficElement }
     *     
     */
    public TrafficElement getTrafficElement() {
        return trafficElement;
    }

    /**
     * Sets the value of the trafficElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficElement }
     *     
     */
    public TrafficViewRecord setTrafficElement(TrafficElement value) {
        this.trafficElement = value;
        return this;
    }

    /**
     * Gets the value of the operatorAction property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorAction }
     *     
     */
    public OperatorAction getOperatorAction() {
        return operatorAction;
    }

    /**
     * Sets the value of the operatorAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorAction }
     *     
     */
    public TrafficViewRecord setOperatorAction(OperatorAction value) {
        this.operatorAction = value;
        return this;
    }

    /**
     * Gets the value of the elaboratedData property.
     * 
     * @return
     *     possible object is
     *     {@link ElaboratedData }
     *     
     */
    public ElaboratedData getElaboratedData() {
        return elaboratedData;
    }

    /**
     * Sets the value of the elaboratedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElaboratedData }
     *     
     */
    public TrafficViewRecord setElaboratedData(ElaboratedData value) {
        this.elaboratedData = value;
        return this;
    }

    /**
     * Gets the value of the cctvimages property.
     * 
     * @return
     *     possible object is
     *     {@link CCTVImages }
     *     
     */
    public CCTVImages getCctvimages() {
        return cctvimages;
    }

    /**
     * Sets the value of the cctvimages property.
     * 
     * @param value
     *     allowed object is
     *     {@link CCTVImages }
     *     
     */
    public TrafficViewRecord setCctvimages(CCTVImages value) {
        this.cctvimages = value;
        return this;
    }

    /**
     * Gets the value of the trafficViewRecordExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getTrafficViewRecordExtension() {
        return trafficViewRecordExtension;
    }

    /**
     * Sets the value of the trafficViewRecordExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public TrafficViewRecord setTrafficViewRecordExtension(ExtensionType value) {
        this.trafficViewRecordExtension = value;
        return this;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public TrafficViewRecord setId(String value) {
        this.id = value;
        return this;
    }

}
