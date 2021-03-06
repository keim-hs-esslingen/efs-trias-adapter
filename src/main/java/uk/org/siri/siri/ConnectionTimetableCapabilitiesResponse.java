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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Data type for Delivery for Connection TimetableService.
 * 
 * <p>Java class for ConnectionTimetableCapabilitiesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConnectionTimetableCapabilitiesResponseStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.siri.org.uk/siri}AbstractServiceCapabilitiesResponseStructure">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.siri.org.uk/siri}ConnectionTimetableServiceCapabilities" minOccurs="0"/>
 *         &lt;element name="ConnectionTimetablePermissions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.siri.org.uk/siri}PermissionsStructure">
 *                 &lt;sequence>
 *                   &lt;element name="ConnectionTimetablePermission" type="{http://www.siri.org.uk/siri}ConnectionServicePermissionStructure" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.siri.org.uk/siri}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.siri.org.uk/siri}VersionString" fixed="1.4" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectionTimetableCapabilitiesResponseStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "connectionTimetableServiceCapabilities",
    "connectionTimetablePermissions",
    "extensions"
})
@ToString
public class ConnectionTimetableCapabilitiesResponse
    extends AbstractServiceCapabilitiesResponse
{

    @XmlElement(name = "ConnectionTimetableServiceCapabilities", namespace = "http://www.siri.org.uk/siri")
    protected ConnectionTimetableServiceCapabilities connectionTimetableServiceCapabilities;
    @XmlElement(name = "ConnectionTimetablePermissions", namespace = "http://www.siri.org.uk/siri")
    protected ConnectionTimetableCapabilitiesResponse.ConnectionTimetablePermissions connectionTimetablePermissions;
    @XmlElement(name = "Extensions", namespace = "http://www.siri.org.uk/siri")
    protected Extensions extensions;
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String version;

    /**
     * Gets the value of the connectionTimetableServiceCapabilities property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionTimetableServiceCapabilities }
     *     
     */
    public ConnectionTimetableServiceCapabilities getConnectionTimetableServiceCapabilities() {
        return connectionTimetableServiceCapabilities;
    }

    /**
     * Sets the value of the connectionTimetableServiceCapabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionTimetableServiceCapabilities }
     *     
     */
    public ConnectionTimetableCapabilitiesResponse setConnectionTimetableServiceCapabilities(ConnectionTimetableServiceCapabilities value) {
        this.connectionTimetableServiceCapabilities = value;
        return this;
    }

    /**
     * Gets the value of the connectionTimetablePermissions property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionTimetableCapabilitiesResponse.ConnectionTimetablePermissions }
     *     
     */
    public ConnectionTimetableCapabilitiesResponse.ConnectionTimetablePermissions getConnectionTimetablePermissions() {
        return connectionTimetablePermissions;
    }

    /**
     * Sets the value of the connectionTimetablePermissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionTimetableCapabilitiesResponse.ConnectionTimetablePermissions }
     *     
     */
    public void setConnectionTimetablePermissions(ConnectionTimetableCapabilitiesResponse.ConnectionTimetablePermissions value) {
        this.connectionTimetablePermissions = value;
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
    public ConnectionTimetableCapabilitiesResponse setExtensions(Extensions value) {
        this.extensions = value;
        return this;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "1.4";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ConnectionTimetableCapabilitiesResponse setVersion(String value) {
        this.version = value;
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
     *     &lt;extension base="{http://www.siri.org.uk/siri}PermissionsStructure">
     *       &lt;sequence>
     *         &lt;element name="ConnectionTimetablePermission" type="{http://www.siri.org.uk/siri}ConnectionServicePermissionStructure" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "connectionTimetablePermission"
    })
    public static class ConnectionTimetablePermissions
        extends Permissions
    {

        @XmlElement(name = "ConnectionTimetablePermission", namespace = "http://www.siri.org.uk/siri")
        protected List<ConnectionServicePermission> connectionTimetablePermission;

        /**
         * Gets the value of the connectionTimetablePermission property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the connectionTimetablePermission property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConnectionTimetablePermission().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ConnectionServicePermission }
         * 
         * 
         */
        public List<ConnectionServicePermission> getConnectionTimetablePermission() {
            if (connectionTimetablePermission == null) {
                connectionTimetablePermission = new ArrayList<ConnectionServicePermission>();
            }
            return this.connectionTimetablePermission;
        }

    }

}
