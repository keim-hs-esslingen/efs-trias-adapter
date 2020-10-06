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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A geographic or geometric area defined by a TPEG-Loc structure which may include height information for additional geospatial descrimination.
 * 
 * <p>Java class for TPEGAreaLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPEGAreaLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpegLocationType" type="{http://datex2.eu/schema/1_0/1_0}TPEGLoc01AreaLocationSubtypeEnum"/>
 *         &lt;element name="tpegheight" type="{http://datex2.eu/schema/1_0/1_0}TPEGHeight" minOccurs="0"/>
 *         &lt;element name="tpegareaLocationExtension" type="{http://datex2.eu/schema/1_0/1_0}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPEGAreaLocation", namespace = "http://datex2.eu/schema/1_0/1_0", propOrder = {
    "tpegLocationType",
    "tpegheight",
    "tpegareaLocationExtension"
})
@XmlSeeAlso({
    TPEGGeometricArea.class,
    TPEGNamedOnlyArea.class
})
public abstract class TPEGAreaLocation {

    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0", required = true)
    @XmlSchemaType(name = "string")
    protected TPEGLoc01AreaLocationSubtypeEnum tpegLocationType;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected TPEGHeight tpegheight;
    @XmlElement(namespace = "http://datex2.eu/schema/1_0/1_0")
    protected ExtensionType tpegareaLocationExtension;

    /**
     * Gets the value of the tpegLocationType property.
     * 
     * @return
     *     possible object is
     *     {@link TPEGLoc01AreaLocationSubtypeEnum }
     *     
     */
    public TPEGLoc01AreaLocationSubtypeEnum getTpegLocationType() {
        return tpegLocationType;
    }

    /**
     * Sets the value of the tpegLocationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPEGLoc01AreaLocationSubtypeEnum }
     *     
     */
    public TPEGAreaLocation setTpegLocationType(TPEGLoc01AreaLocationSubtypeEnum value) {
        this.tpegLocationType = value;
        return this;
    }

    /**
     * Gets the value of the tpegheight property.
     * 
     * @return
     *     possible object is
     *     {@link TPEGHeight }
     *     
     */
    public TPEGHeight getTpegheight() {
        return tpegheight;
    }

    /**
     * Sets the value of the tpegheight property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPEGHeight }
     *     
     */
    public TPEGAreaLocation setTpegheight(TPEGHeight value) {
        this.tpegheight = value;
        return this;
    }

    /**
     * Gets the value of the tpegareaLocationExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getTpegareaLocationExtension() {
        return tpegareaLocationExtension;
    }

    /**
     * Sets the value of the tpegareaLocationExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public TPEGAreaLocation setTpegareaLocationExtension(ExtensionType value) {
        this.tpegareaLocationExtension = value;
        return this;
    }

}
