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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.org.ifopt.ifopt.CountryRef;


/**
 * Common parameters for all situations.
 * 
 * <p>Java class for Context complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContextStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountryRef" type="{http://www.ifopt.org.uk/ifopt}CountryRefStructure" minOccurs="0"/>
 *         &lt;element name="ParticipantRef" type="{http://www.siri.org.uk/siri}ParticipantRefStructure"/>
 *         &lt;element name="TopographicPlaceRef" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" minOccurs="0"/>
 *         &lt;element name="TopographicPlaceName" type="{http://www.siri.org.uk/siri}NaturalLanguageStringStructure" minOccurs="0"/>
 *         &lt;element name="DefaultLanguage" type="{http://www.w3.org/2001/XMLSchema}language" minOccurs="0"/>
 *         &lt;element name="NetworkContext" type="{http://www.siri.org.uk/siri}NetworkContextStructure" minOccurs="0"/>
 *         &lt;element name="Actions" type="{http://www.siri.org.uk/siri}ActionsStructure" minOccurs="0"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContextStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "countryRef",
    "participantRef",
    "topographicPlaceRef",
    "topographicPlaceName",
    "defaultLanguage",
    "networkContext",
    "actions",
    "extensions"
})
@ToString
public class Context {

    @XmlElement(name = "CountryRef", namespace = "http://www.siri.org.uk/siri")
    protected CountryRef countryRef;
    @XmlElement(name = "ParticipantRef", namespace = "http://www.siri.org.uk/siri", required = true)
    protected ParticipantRef participantRef;
    @XmlElement(name = "TopographicPlaceRef", namespace = "http://www.siri.org.uk/siri")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String topographicPlaceRef;
    @XmlElement(name = "TopographicPlaceName", namespace = "http://www.siri.org.uk/siri")
    protected NaturalLanguageString topographicPlaceName;
    @XmlElement(name = "DefaultLanguage", namespace = "http://www.siri.org.uk/siri")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String defaultLanguage;
    @XmlElement(name = "NetworkContext", namespace = "http://www.siri.org.uk/siri")
    protected NetworkContext networkContext;
    @XmlElement(name = "Actions", namespace = "http://www.siri.org.uk/siri")
    protected Actions actions;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;

    /**
     * Gets the value of the countryRef property.
     * 
     * @return
     *     possible object is
     *     {@link CountryRef }
     *     
     */
    public CountryRef getCountryRef() {
        return countryRef;
    }

    /**
     * Sets the value of the countryRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryRef }
     *     
     */
    public Context setCountryRef(CountryRef value) {
        this.countryRef = value;
        return this;
    }

    /**
     * Gets the value of the participantRef property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantRef }
     *     
     */
    public ParticipantRef getParticipantRef() {
        return participantRef;
    }

    /**
     * Sets the value of the participantRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantRef }
     *     
     */
    public Context setParticipantRef(ParticipantRef value) {
        this.participantRef = value;
        return this;
    }

    /**
     * Gets the value of the topographicPlaceRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopographicPlaceRef() {
        return topographicPlaceRef;
    }

    /**
     * Sets the value of the topographicPlaceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public Context setTopographicPlaceRef(String value) {
        this.topographicPlaceRef = value;
        return this;
    }

    /**
     * Gets the value of the topographicPlaceName property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageString }
     *     
     */
    public NaturalLanguageString getTopographicPlaceName() {
        return topographicPlaceName;
    }

    /**
     * Sets the value of the topographicPlaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageString }
     *     
     */
    public Context setTopographicPlaceName(NaturalLanguageString value) {
        this.topographicPlaceName = value;
        return this;
    }

    /**
     * Gets the value of the defaultLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * Sets the value of the defaultLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public Context setDefaultLanguage(String value) {
        this.defaultLanguage = value;
        return this;
    }

    /**
     * Gets the value of the networkContext property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkContext }
     *     
     */
    public NetworkContext getNetworkContext() {
        return networkContext;
    }

    /**
     * Sets the value of the networkContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkContext }
     *     
     */
    public Context setNetworkContext(NetworkContext value) {
        this.networkContext = value;
        return this;
    }

    /**
     * Gets the value of the actions property.
     * 
     * @return
     *     possible object is
     *     {@link Actions }
     *     
     */
    public Actions getActions() {
        return actions;
    }

    /**
     * Sets the value of the actions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Actions }
     *     
     */
    public Context setActions(Actions value) {
        this.actions = value;
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
    public Context setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }

}
