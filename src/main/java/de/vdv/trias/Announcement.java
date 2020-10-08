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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Announcement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnnouncementStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AnnouncementRef" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnnouncementText" type="{http://www.vdv.de/trias}InternationalTextStructure" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AnnouncementTTSText" type="{http://www.vdv.de/trias}InternationalTextStructure" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnnouncementStructure", namespace = "http://www.vdv.de/trias", propOrder = {
    "announcementRef",
    "announcementText",
    "announcementTTSText"
})
@ToString
public class Announcement {

    @XmlElement(name = "AnnouncementRef", namespace = "http://www.vdv.de/trias")
    protected int announcementRef;
    @XmlElement(name = "AnnouncementText", namespace = "http://www.vdv.de/trias")
    protected List<InternationalText> announcementText;
    @XmlElement(name = "AnnouncementTTSText", namespace = "http://www.vdv.de/trias")
    protected List<InternationalText> announcementTTSText;

    /**
     * Gets the value of the announcementRef property.
     * 
     */
    public int getAnnouncementRef() {
        return announcementRef;
    }

    /**
     * Sets the value of the announcementRef property.
     * 
     */
    public Announcement setAnnouncementRef(int value) {
        this.announcementRef = value;
        return this;
    }

    /**
     * Gets the value of the announcementText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the announcementText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnnouncementText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalText }
     * 
     * 
     */
    public List<InternationalText> getAnnouncementText() {
        if (announcementText == null) {
            announcementText = new ArrayList<InternationalText>();
        }
        return this.announcementText;
    }

    /**
     * Gets the value of the announcementTTSText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the announcementTTSText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnnouncementTTSText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternationalText }
     * 
     * 
     */
    public List<InternationalText> getAnnouncementTTSText() {
        if (announcementTTSText == null) {
            announcementTTSText = new ArrayList<InternationalText>();
        }
        return this.announcementTTSText;
    }

}