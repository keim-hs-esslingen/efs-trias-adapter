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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Details of the source from which the information was obtained.
 * 
 * <p>Java class for SourceInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SourceInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sourceCountry" type="{http://datex2.eu/schema/1_0/1_0}CountryEnum" minOccurs="0"/>
 *         &lt;element name="sourceIdentification" type="{http://datex2.eu/schema/1_0/1_0}String" minOccurs="0"/>
 *         &lt;element name="sourceName" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="value" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://datex2.eu/schema/1_0/1_0>MultiLingualString">
 *                           &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}language" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sourceType" type="{http://datex2.eu/schema/1_0/1_0}SourceTypeEnum" minOccurs="0"/>
 *         &lt;element name="reliable" type="{http://datex2.eu/schema/1_0/1_0}Boolean" minOccurs="0"/>
 *         &lt;element name="sourceInformationExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceInformation", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "sourceCountry",
    "sourceIdentification",
    "sourceName",
    "sourceType",
    "reliable",
    "sourceInformationExtension"
})
public class SourceInformation {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected CountryEnum sourceCountry;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected String sourceIdentification;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected SourceInformation.SourceName sourceName;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected SourceTypeEnum sourceType;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Boolean reliable;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType sourceInformationExtension;

    /**
     * Gets the value of the sourceCountry property.
     * 
     * @return
     *     possible object is
     *     {@link CountryEnum }
     *     
     */
    public CountryEnum getSourceCountry() {
        return sourceCountry;
    }

    /**
     * Sets the value of the sourceCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryEnum }
     *     
     */
    public SourceInformation setSourceCountry(CountryEnum value) {
        this.sourceCountry = value;
        return this;
    }

    /**
     * Gets the value of the sourceIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceIdentification() {
        return sourceIdentification;
    }

    /**
     * Sets the value of the sourceIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public SourceInformation setSourceIdentification(String value) {
        this.sourceIdentification = value;
        return this;
    }

    /**
     * Gets the value of the sourceName property.
     * 
     * @return
     *     possible object is
     *     {@link SourceInformation.SourceName }
     *     
     */
    public SourceInformation.SourceName getSourceName() {
        return sourceName;
    }

    /**
     * Sets the value of the sourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceInformation.SourceName }
     *     
     */
    public void setSourceName(SourceInformation.SourceName value) {
        this.sourceName = value;
    }

    /**
     * Gets the value of the sourceType property.
     * 
     * @return
     *     possible object is
     *     {@link SourceTypeEnum }
     *     
     */
    public SourceTypeEnum getSourceType() {
        return sourceType;
    }

    /**
     * Sets the value of the sourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceTypeEnum }
     *     
     */
    public SourceInformation setSourceType(SourceTypeEnum value) {
        this.sourceType = value;
        return this;
    }

    /**
     * Gets the value of the reliable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReliable() {
        return reliable;
    }

    /**
     * Sets the value of the reliable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public SourceInformation setReliable(Boolean value) {
        this.reliable = value;
        return this;
    }

    /**
     * Gets the value of the sourceInformationExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getSourceInformationExtension() {
        return sourceInformationExtension;
    }

    /**
     * Sets the value of the sourceInformationExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public SourceInformation setSourceInformationExtension(ExtensionType value) {
        this.sourceInformationExtension = value;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="value" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://datex2.eu/schema/1_0/1_0>MultiLingualString">
     *                 &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}language" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class SourceName {

        @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
        protected List<SourceInformation.SourceName.Value> value;

        /**
         * Gets the value of the value property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the value property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SourceInformation.SourceName.Value }
         * 
         * 
         */
        public List<SourceInformation.SourceName.Value> getValue() {
            if (value == null) {
                value = new ArrayList<SourceInformation.SourceName.Value>();
            }
            return this.value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://datex2.eu/schema/1_0/1_0>MultiLingualString">
         *       &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}language" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Value {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "lang")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "language")
            protected String lang;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the lang property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLang() {
                return lang;
            }

            /**
             * Sets the value of the lang property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLang(String value) {
                this.lang = value;
            }

        }

    }

}
