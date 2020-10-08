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
import java.time.ZonedDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;
import de.hsesslingen.keim.efs.adapter.trias.jaxb.ZonedDateTimeAdapter;


/**
 * Same as CheckStatusResponseStructure, but without extension to be consistent with the other operation definition.
 * 
 * <p>Java class for CheckStatusResponseBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckStatusResponseBodyStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.siri.org.uk/siri}CheckStatusPayloadGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckStatusResponseBodyStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "status",
    "errorCondition",
    "validUntil",
    "shortestPossibleCycle",
    "serviceStartedTime"
})
@ToString
public class CheckStatusResponseBody {

    @XmlElement(name = "Status", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
    protected Boolean status;
    @XmlElement(name = "ErrorCondition", namespace = "http://www.siri.org.uk/siri")
    protected CheckStatusResponseBody.ErrorCondition errorCondition;
    @XmlElement(name = "ValidUntil", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime validUntil;
    @XmlElement(name = "ShortestPossibleCycle", namespace = "http://www.siri.org.uk/siri")
    protected Duration shortestPossibleCycle;
    @XmlElement(name = "ServiceStartedTime", namespace = "http://www.siri.org.uk/siri", type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime serviceStartedTime;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public CheckStatusResponseBody setStatus(Boolean value) {
        this.status = value;
        return this;
    }

    /**
     * Gets the value of the errorCondition property.
     * 
     * @return
     *     possible object is
     *     {@link CheckStatusResponseBody.ErrorCondition }
     *     
     */
    public CheckStatusResponseBody.ErrorCondition getErrorCondition() {
        return errorCondition;
    }

    /**
     * Sets the value of the errorCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckStatusResponseBody.ErrorCondition }
     *     
     */
    public void setErrorCondition(CheckStatusResponseBody.ErrorCondition value) {
        this.errorCondition = value;
    }

    /**
     * Gets the value of the validUntil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getValidUntil() {
        return validUntil;
    }

    /**
     * Sets the value of the validUntil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public CheckStatusResponseBody setValidUntil(ZonedDateTime value) {
        this.validUntil = value;
        return this;
    }

    /**
     * Gets the value of the shortestPossibleCycle property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getShortestPossibleCycle() {
        return shortestPossibleCycle;
    }

    /**
     * Sets the value of the shortestPossibleCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public CheckStatusResponseBody setShortestPossibleCycle(Duration value) {
        this.shortestPossibleCycle = value;
        return this;
    }

    /**
     * Gets the value of the serviceStartedTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getServiceStartedTime() {
        return serviceStartedTime;
    }

    /**
     * Sets the value of the serviceStartedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public CheckStatusResponseBody setServiceStartedTime(ZonedDateTime value) {
        this.serviceStartedTime = value;
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
     *         &lt;choice>
     *           &lt;element ref="{http://www.siri.org.uk/siri}ServiceNotAvailableError"/>
     *           &lt;element ref="{http://www.siri.org.uk/siri}OtherError"/>
     *         &lt;/choice>
     *         &lt;element name="Description" type="{http://www.siri.org.uk/siri}ErrorDescriptionStructure" minOccurs="0"/>
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
        "serviceNotAvailableError",
        "otherError",
        "description"
    })
    public static class ErrorCondition {

        @XmlElement(name = "ServiceNotAvailableError", namespace = "http://www.siri.org.uk/siri")
        protected ServiceNotAvailableError serviceNotAvailableError;
        @XmlElement(name = "OtherError", namespace = "http://www.siri.org.uk/siri")
        protected OtherError otherError;
        @XmlElement(name = "Description", namespace = "http://www.siri.org.uk/siri")
        protected ErrorDescription description;

        /**
         * Gets the value of the serviceNotAvailableError property.
         * 
         * @return
         *     possible object is
         *     {@link ServiceNotAvailableError }
         *     
         */
        public ServiceNotAvailableError getServiceNotAvailableError() {
            return serviceNotAvailableError;
        }

        /**
         * Sets the value of the serviceNotAvailableError property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceNotAvailableError }
         *     
         */
        public void setServiceNotAvailableError(ServiceNotAvailableError value) {
            this.serviceNotAvailableError = value;
        }

        /**
         * Gets the value of the otherError property.
         * 
         * @return
         *     possible object is
         *     {@link OtherError }
         *     
         */
        public OtherError getOtherError() {
            return otherError;
        }

        /**
         * Sets the value of the otherError property.
         * 
         * @param value
         *     allowed object is
         *     {@link OtherError }
         *     
         */
        public void setOtherError(OtherError value) {
            this.otherError = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link ErrorDescription }
         *     
         */
        public ErrorDescription getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link ErrorDescription }
         *     
         */
        public void setDescription(ErrorDescription value) {
            this.description = value;
        }

    }

}