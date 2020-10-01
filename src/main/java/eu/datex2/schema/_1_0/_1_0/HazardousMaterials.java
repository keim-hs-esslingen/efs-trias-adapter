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
 * Details of hazardous materials.
 * 
 * <p>Java class for HazardousMaterials complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HazardousMaterials">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chemicalName">
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
 *         &lt;element name="dangerousGoodsFlashPoint" type="{http://datex2.eu/schema/1_0/1_0}TemperatureCelsius" minOccurs="0"/>
 *         &lt;element name="dangerousGoodsRegulations" type="{http://datex2.eu/schema/1_0/1_0}DangerousGoodRegulationsEnum" minOccurs="0"/>
 *         &lt;element name="hazardCodeIdentification" type="{http://datex2.eu/schema/1_0/1_0}String" minOccurs="0"/>
 *         &lt;element name="hazardCodeVersionNumber" type="{http://datex2.eu/schema/1_0/1_0}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="hazardSubstanceItemPageNumber" type="{http://datex2.eu/schema/1_0/1_0}String" minOccurs="0"/>
 *         &lt;element name="tremCardNumber" type="{http://datex2.eu/schema/1_0/1_0}String" minOccurs="0"/>
 *         &lt;element name="uNDGNumber" type="{http://datex2.eu/schema/1_0/1_0}String" minOccurs="0"/>
 *         &lt;element name="volumeOfDangerousGoods" type="{http://datex2.eu/schema/1_0/1_0}CubicMetres" minOccurs="0"/>
 *         &lt;element name="weightOfDangerousGoods" type="{http://datex2.eu/schema/1_0/1_0}Tonnes" minOccurs="0"/>
 *         &lt;element name="hazardousMaterialsExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HazardousMaterials", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "chemicalName",
    "dangerousGoodsFlashPoint",
    "dangerousGoodsRegulations",
    "hazardCodeIdentification",
    "hazardCodeVersionNumber",
    "hazardSubstanceItemPageNumber",
    "tremCardNumber",
    "undgNumber",
    "volumeOfDangerousGoods",
    "weightOfDangerousGoods",
    "hazardousMaterialsExtension"
})
public class HazardousMaterials {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    protected HazardousMaterials.ChemicalName chemicalName;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Float dangerousGoodsFlashPoint;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "string")
    protected DangerousGoodRegulationsEnum dangerousGoodsRegulations;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected String hazardCodeIdentification;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger hazardCodeVersionNumber;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected String hazardSubstanceItemPageNumber;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected String tremCardNumber;
    @XmlElement(name = "uNDGNumber", namespace = "http://datex2.eu/schema/1_0/1_0")
    protected String undgNumber;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Float volumeOfDangerousGoods;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected Float weightOfDangerousGoods;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType hazardousMaterialsExtension;

    /**
     * Gets the value of the chemicalName property.
     * 
     * @return
     *     possible object is
     *     {@link HazardousMaterials.ChemicalName }
     *     
     */
    public HazardousMaterials.ChemicalName getChemicalName() {
        return chemicalName;
    }

    /**
     * Sets the value of the chemicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousMaterials.ChemicalName }
     *     
     */
    public void setChemicalName(HazardousMaterials.ChemicalName value) {
        this.chemicalName = value;
    }

    /**
     * Gets the value of the dangerousGoodsFlashPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDangerousGoodsFlashPoint() {
        return dangerousGoodsFlashPoint;
    }

    /**
     * Sets the value of the dangerousGoodsFlashPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public HazardousMaterials setDangerousGoodsFlashPoint(Float value) {
        this.dangerousGoodsFlashPoint = value;
        return this;
    }

    /**
     * Gets the value of the dangerousGoodsRegulations property.
     * 
     * @return
     *     possible object is
     *     {@link DangerousGoodRegulationsEnum }
     *     
     */
    public DangerousGoodRegulationsEnum getDangerousGoodsRegulations() {
        return dangerousGoodsRegulations;
    }

    /**
     * Sets the value of the dangerousGoodsRegulations property.
     * 
     * @param value
     *     allowed object is
     *     {@link DangerousGoodRegulationsEnum }
     *     
     */
    public HazardousMaterials setDangerousGoodsRegulations(DangerousGoodRegulationsEnum value) {
        this.dangerousGoodsRegulations = value;
        return this;
    }

    /**
     * Gets the value of the hazardCodeIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazardCodeIdentification() {
        return hazardCodeIdentification;
    }

    /**
     * Sets the value of the hazardCodeIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public HazardousMaterials setHazardCodeIdentification(String value) {
        this.hazardCodeIdentification = value;
        return this;
    }

    /**
     * Gets the value of the hazardCodeVersionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHazardCodeVersionNumber() {
        return hazardCodeVersionNumber;
    }

    /**
     * Sets the value of the hazardCodeVersionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public HazardousMaterials setHazardCodeVersionNumber(BigInteger value) {
        this.hazardCodeVersionNumber = value;
        return this;
    }

    /**
     * Gets the value of the hazardSubstanceItemPageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazardSubstanceItemPageNumber() {
        return hazardSubstanceItemPageNumber;
    }

    /**
     * Sets the value of the hazardSubstanceItemPageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public HazardousMaterials setHazardSubstanceItemPageNumber(String value) {
        this.hazardSubstanceItemPageNumber = value;
        return this;
    }

    /**
     * Gets the value of the tremCardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTremCardNumber() {
        return tremCardNumber;
    }

    /**
     * Sets the value of the tremCardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public HazardousMaterials setTremCardNumber(String value) {
        this.tremCardNumber = value;
        return this;
    }

    /**
     * Gets the value of the undgNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNDGNumber() {
        return undgNumber;
    }

    /**
     * Sets the value of the undgNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public HazardousMaterials setUNDGNumber(String value) {
        this.undgNumber = value;
        return this;
    }

    /**
     * Gets the value of the volumeOfDangerousGoods property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVolumeOfDangerousGoods() {
        return volumeOfDangerousGoods;
    }

    /**
     * Sets the value of the volumeOfDangerousGoods property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public HazardousMaterials setVolumeOfDangerousGoods(Float value) {
        this.volumeOfDangerousGoods = value;
        return this;
    }

    /**
     * Gets the value of the weightOfDangerousGoods property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWeightOfDangerousGoods() {
        return weightOfDangerousGoods;
    }

    /**
     * Sets the value of the weightOfDangerousGoods property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public HazardousMaterials setWeightOfDangerousGoods(Float value) {
        this.weightOfDangerousGoods = value;
        return this;
    }

    /**
     * Gets the value of the hazardousMaterialsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getHazardousMaterialsExtension() {
        return hazardousMaterialsExtension;
    }

    /**
     * Sets the value of the hazardousMaterialsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public HazardousMaterials setHazardousMaterialsExtension(ExtensionType value) {
        this.hazardousMaterialsExtension = value;
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
    public static class ChemicalName {

        @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
        protected List<HazardousMaterials.ChemicalName.Value> value;

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
         * {@link HazardousMaterials.ChemicalName.Value }
         * 
         * 
         */
        public List<HazardousMaterials.ChemicalName.Value> getValue() {
            if (value == null) {
                value = new ArrayList<HazardousMaterials.ChemicalName.Value>();
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
