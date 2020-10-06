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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * Type for publication action.
 * 
 * <p>Java class for PushedAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PushedActionStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}ParameterisedActionStructure">
 *       &lt;sequence>
 *         &lt;element name="BeforeNotices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Interval" type="{http://www.siri.org.uk/siri}DurationType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ClearNotice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PushedActionStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "beforeNotices",
    "clearNotice"
})
@XmlSeeAlso({
    PublishToAlertsAction.class,
    NotifyBySmsAction.class,
    NotifyByPagerAction.class,
    NotifyByEmailAction.class,
    NotifyUserAction.class
})
@ToString
public class PushedAction
    extends ParameterisedAction
{

    @XmlElement(name = "BeforeNotices", namespace = "http://www.siri.org.uk/siri")
    protected PushedAction.BeforeNotices beforeNotices;
    @XmlElement(name = "ClearNotice", namespace = "http://www.siri.org.uk/siri")
    protected Boolean clearNotice;

    /**
     * Gets the value of the beforeNotices property.
     * 
     * @return
     *     possible object is
     *     {@link PushedAction.BeforeNotices }
     *     
     */
    public PushedAction.BeforeNotices getBeforeNotices() {
        return beforeNotices;
    }

    /**
     * Sets the value of the beforeNotices property.
     * 
     * @param value
     *     allowed object is
     *     {@link PushedAction.BeforeNotices }
     *     
     */
    public void setBeforeNotices(PushedAction.BeforeNotices value) {
        this.beforeNotices = value;
    }

    /**
     * Gets the value of the clearNotice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClearNotice() {
        return clearNotice;
    }

    /**
     * Sets the value of the clearNotice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public PushedAction setClearNotice(Boolean value) {
        this.clearNotice = value;
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
     *         &lt;element name="Interval" type="{http://www.siri.org.uk/siri}DurationType" maxOccurs="unbounded" minOccurs="0"/>
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
        "interval"
    })
    public static class BeforeNotices {

        @XmlElement(name = "Interval", namespace = "http://www.siri.org.uk/siri")
        protected List<Duration> interval;

        /**
         * Gets the value of the interval property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the interval property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInterval().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Duration }
         * 
         * 
         */
        public List<Duration> getInterval() {
            if (interval == null) {
                interval = new ArrayList<Duration>();
            }
            return this.interval;
        }

    }

}
