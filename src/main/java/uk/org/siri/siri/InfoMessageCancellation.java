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
import javax.xml.bind.annotation.XmlType;


/**
 * Type for Revocation of a previous message.
 * 
 * <p>Java class for InfoMessageCancellation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoMessageCancellationStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}AbstractReferencingItemStructure">
 *       &lt;sequence>
 *         &lt;element name="InfoMessageIdentifier" type="{http://www.siri.org.uk/siri}InfoMessageRefStructure"/>
 *         &lt;element name="InfoChannelRef" type="{http://www.siri.org.uk/siri}InfoChannelRefStructure" minOccurs="0"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoMessageCancellationStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "infoMessageIdentifier",
    "infoChannelRef",
    "extensions"
})
@ToString
public class InfoMessageCancellation
    extends AbstractReferencingItem
{

    @XmlElement(name = "InfoMessageIdentifier", namespace = "http://www.siri.org.uk/siri", required = true)
    protected InfoMessageRef infoMessageIdentifier;
    @XmlElement(name = "InfoChannelRef", namespace = "http://www.siri.org.uk/siri")
    protected InfoChannelRef infoChannelRef;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;

    /**
     * Gets the value of the infoMessageIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link InfoMessageRef }
     *     
     */
    public InfoMessageRef getInfoMessageIdentifier() {
        return infoMessageIdentifier;
    }

    /**
     * Sets the value of the infoMessageIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoMessageRef }
     *     
     */
    public InfoMessageCancellation setInfoMessageIdentifier(InfoMessageRef value) {
        this.infoMessageIdentifier = value;
        return this;
    }

    /**
     * Gets the value of the infoChannelRef property.
     * 
     * @return
     *     possible object is
     *     {@link InfoChannelRef }
     *     
     */
    public InfoChannelRef getInfoChannelRef() {
        return infoChannelRef;
    }

    /**
     * Sets the value of the infoChannelRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoChannelRef }
     *     
     */
    public InfoMessageCancellation setInfoChannelRef(InfoChannelRef value) {
        this.infoChannelRef = value;
        return this;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link Extensions }
     *     
     */
    public Extensions getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extensions }
     *     
     */
    public InfoMessageCancellation setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }

}
