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
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.org.siri.siri.ProducerResponse;


/**
 * Basic response structure common for all TRIAS service responses.
 * 
 * <p>Java class for AbstractTriasResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractTriasResponseStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}ProducerResponseStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.vdv.de/trias}ResponseStatusGroup"/>
 *         &lt;group ref="{http://www.vdv.de/trias}ServiceResponseContextGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTriasResponseStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "status",
    "errorCondition",
    "moreData",
    "dataVersion",
    "language",
    "calcTime",
    "signature",
    "certificateId",
    "extension"
})
@XmlSeeAlso({
    ServiceDelivery.class
})
@ToString
public class AbstractTriasResponse
    extends ProducerResponse
{

    @XmlElement(name = "Status", namespace = "http://www.siri.org.uk/siri", defaultValue = "true")
    protected Boolean status;
    @XmlElement(name = "ErrorCondition", namespace = "http://www.siri.org.uk/siri")
    protected uk.org.siri.siri.ServiceDelivery.ErrorCondition errorCondition;
    @XmlElement(name = "MoreData", namespace = "http://www.vdv.de/trias", defaultValue = "false")
    protected Boolean moreData;
    @XmlElement(name = "DataVersion", namespace = "http://www.vdv.de/trias")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String dataVersion;
    @XmlElement(name = "Language", namespace = "http://www.vdv.de/trias", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String language;
    @XmlElement(name = "CalcTime", namespace = "http://www.vdv.de/trias")
    protected BigInteger calcTime;
    @XmlElement(name = "Signature", namespace = "http://www.vdv.de/trias")
    protected String signature;
    @XmlElement(name = "CertificateId", namespace = "http://www.vdv.de/trias")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String certificateId;
    @XmlElement(name = "Extension", namespace = "http://www.vdv.de/trias")
    protected Object extension;

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
    public AbstractTriasResponse setStatus(Boolean value) {
        this.status = value;
        return this;
    }

    /**
     * Gets the value of the errorCondition property.
     * 
     * @return
     *     possible object is
     *     {@link uk.org.siri.siri.ServiceDelivery.ErrorCondition }
     *     
     */
    public uk.org.siri.siri.ServiceDelivery.ErrorCondition getErrorCondition() {
        return errorCondition;
    }

    /**
     * Sets the value of the errorCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link uk.org.siri.siri.ServiceDelivery.ErrorCondition }
     *     
     */
    public void setErrorCondition(uk.org.siri.siri.ServiceDelivery.ErrorCondition value) {
        this.errorCondition = value;
    }

    /**
     * Gets the value of the moreData property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMoreData() {
        return moreData;
    }

    /**
     * Sets the value of the moreData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public AbstractTriasResponse setMoreData(Boolean value) {
        this.moreData = value;
        return this;
    }

    /**
     * Gets the value of the dataVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataVersion() {
        return dataVersion;
    }

    /**
     * Sets the value of the dataVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public AbstractTriasResponse setDataVersion(String value) {
        this.dataVersion = value;
        return this;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public AbstractTriasResponse setLanguage(String value) {
        this.language = value;
        return this;
    }

    /**
     * Gets the value of the calcTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCalcTime() {
        return calcTime;
    }

    /**
     * Sets the value of the calcTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public AbstractTriasResponse setCalcTime(BigInteger value) {
        this.calcTime = value;
        return this;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public AbstractTriasResponse setSignature(String value) {
        this.signature = value;
        return this;
    }

    /**
     * Gets the value of the certificateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateId() {
        return certificateId;
    }

    /**
     * Sets the value of the certificateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public AbstractTriasResponse setCertificateId(String value) {
        this.certificateId = value;
        return this;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public AbstractTriasResponse setExtension(Object value) {
        this.extension = value;
        return this;
    }

}
