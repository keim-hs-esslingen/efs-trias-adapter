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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A  measurement data set derived from a specific measurement site.
 * 
 * <p>Java class for SiteMeasurements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SiteMeasurements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="measurementSiteReference" type="{http://datex2.eu/schema/1_0/1_0}Reference"/>
 *         &lt;element name="measurementTimeDefault" type="{http://datex2.eu/schema/1_0/1_0}DateTime"/>
 *         &lt;element name="measuredValue" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://datex2.eu/schema/1_0/1_0}MeasuredValue">
 *                 &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="siteMeasurementsExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiteMeasurements", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "measurementSiteReference",
    "measurementTimeDefault",
    "measuredValue",
    "siteMeasurementsExtension"
})
@ToString
public class SiteMeasurements {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    protected String measurementSiteReference;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    protected DateTime measurementTimeDefault;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    protected List<SiteMeasurements.MeasuredValue> measuredValue;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType siteMeasurementsExtension;

    /**
     * Gets the value of the measurementSiteReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasurementSiteReference() {
        return measurementSiteReference;
    }

    /**
     * Sets the value of the measurementSiteReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public SiteMeasurements setMeasurementSiteReference(String value) {
        this.measurementSiteReference = value;
        return this;
    }

    /**
     * Gets the value of the measurementTimeDefault property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getMeasurementTimeDefault() {
        return measurementTimeDefault;
    }

    /**
     * Sets the value of the measurementTimeDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public SiteMeasurements setMeasurementTimeDefault(DateTime value) {
        this.measurementTimeDefault = value;
        return this;
    }

    /**
     * Gets the value of the measuredValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measuredValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasuredValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SiteMeasurements.MeasuredValue }
     * 
     * 
     */
    public List<SiteMeasurements.MeasuredValue> getMeasuredValue() {
        if (measuredValue == null) {
            measuredValue = new ArrayList<SiteMeasurements.MeasuredValue>();
        }
        return this.measuredValue;
    }

    /**
     * Gets the value of the siteMeasurementsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getSiteMeasurementsExtension() {
        return siteMeasurementsExtension;
    }

    /**
     * Sets the value of the siteMeasurementsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public SiteMeasurements setSiteMeasurementsExtension(ExtensionType value) {
        this.siteMeasurementsExtension = value;
        return this;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://datex2.eu/schema/1_0/1_0}MeasuredValue">
     *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MeasuredValue
        extends eu.datex2.schema._1_0._1_0.MeasuredValue
    {

        @XmlAttribute(name = "index", required = true)
        protected int index;

        /**
         * Gets the value of the index property.
         * 
         */
        public int getIndex() {
            return index;
        }

        /**
         * Sets the value of the index property.
         * 
         */
        public void setIndex(int value) {
            this.index = value;
        }

    }

}
