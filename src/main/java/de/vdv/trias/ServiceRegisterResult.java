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


package de.vdv.trias;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Service register result structure.
 * 
 * <p>Java class for ServiceRegisterResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceRegisterResultStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultId" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN"/>
 *         &lt;element name="ErrorMessage" type="{http://www.vdv.de/trias}ErrorMessageStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="RegisterResponse" type="{http://www.vdv.de/trias}ServiceRegisterRegisterResponseStructure"/>
 *           &lt;element name="UpdateResponse" type="{http://www.vdv.de/trias}ServiceRegisterUpdateResponseStructure"/>
 *           &lt;element name="LookupResponse" type="{http://www.vdv.de/trias}ServiceRegisterLookupResponseStructure"/>
 *           &lt;element name="UnregisterResponse" type="{http://www.vdv.de/trias}ServiceRegisterUnregisterResponseStructure"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceRegisterResultStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "resultId",
    "errorMessage",
    "registerResponse",
    "updateResponse",
    "lookupResponse",
    "unregisterResponse"
})
@ToString
public class ServiceRegisterResult {

    @XmlElement(name = "ResultId", namespace = "http://www.vdv.de/trias", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String resultId;
    @XmlElement(name = "ErrorMessage", namespace = "http://www.vdv.de/trias")
    protected List<ErrorMessage> errorMessage;
    @XmlElement(name = "RegisterResponse", namespace = "http://www.vdv.de/trias")
    protected ServiceRegisterRegisterResponse registerResponse;
    @XmlElement(name = "UpdateResponse", namespace = "http://www.vdv.de/trias")
    protected ServiceRegisterUpdateResponse updateResponse;
    @XmlElement(name = "LookupResponse", namespace = "http://www.vdv.de/trias")
    protected ServiceRegisterLookupResponse lookupResponse;
    @XmlElement(name = "UnregisterResponse", namespace = "http://www.vdv.de/trias")
    protected ServiceRegisterUnregisterResponse unregisterResponse;

    /**
     * Gets the value of the resultId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultId() {
        return resultId;
    }

    /**
     * Sets the value of the resultId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ServiceRegisterResult setResultId(String value) {
        this.resultId = value;
        return this;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorMessage }
     * 
     * 
     */
    public List<ErrorMessage> getErrorMessage() {
        if (errorMessage == null) {
            errorMessage = new ArrayList<ErrorMessage>();
        }
        return this.errorMessage;
    }

    /**
     * Gets the value of the registerResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRegisterRegisterResponse }
     *     
     */
    public ServiceRegisterRegisterResponse getRegisterResponse() {
        return registerResponse;
    }

    /**
     * Sets the value of the registerResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRegisterRegisterResponse }
     *     
     */
    public ServiceRegisterResult setRegisterResponse(ServiceRegisterRegisterResponse value) {
        this.registerResponse = value;
        return this;
    }

    /**
     * Gets the value of the updateResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRegisterUpdateResponse }
     *     
     */
    public ServiceRegisterUpdateResponse getUpdateResponse() {
        return updateResponse;
    }

    /**
     * Sets the value of the updateResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRegisterUpdateResponse }
     *     
     */
    public ServiceRegisterResult setUpdateResponse(ServiceRegisterUpdateResponse value) {
        this.updateResponse = value;
        return this;
    }

    /**
     * Gets the value of the lookupResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRegisterLookupResponse }
     *     
     */
    public ServiceRegisterLookupResponse getLookupResponse() {
        return lookupResponse;
    }

    /**
     * Sets the value of the lookupResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRegisterLookupResponse }
     *     
     */
    public ServiceRegisterResult setLookupResponse(ServiceRegisterLookupResponse value) {
        this.lookupResponse = value;
        return this;
    }

    /**
     * Gets the value of the unregisterResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRegisterUnregisterResponse }
     *     
     */
    public ServiceRegisterUnregisterResponse getUnregisterResponse() {
        return unregisterResponse;
    }

    /**
     * Sets the value of the unregisterResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRegisterUnregisterResponse }
     *     
     */
    public ServiceRegisterResult setUnregisterResponse(ServiceRegisterUnregisterResponse value) {
        this.unregisterResponse = value;
        return this;
    }

}
