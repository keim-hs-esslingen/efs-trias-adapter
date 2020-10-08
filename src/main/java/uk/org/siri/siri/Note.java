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
 * DataType for a note
 * 
 * <p>Java class for Note complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NoteStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.siri.org.uk/siri}SituationRef" minOccurs="0"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}SituationSimpleRef" minOccurs="0"/>
 *         &lt;element ref="{http://www.siri.org.uk/siri}SituationFullRef" minOccurs="0"/>
 *         &lt;element name="Note" type="{http://www.siri.org.uk/siri}NaturalLanguageStringStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoteStructure", namespace = "http://www.siri.org.uk/siri", propOrder = {
    "situationRef",
    "situationSimpleRef",
    "situationFullRef",
    "note"
})
@ToString
public class Note {

    @XmlElement(name = "SituationRef", namespace = "http://www.siri.org.uk/siri")
    protected SituationRef situationRef;
    @XmlElement(name = "SituationSimpleRef", namespace = "http://www.siri.org.uk/siri")
    protected SituationSimpleRef situationSimpleRef;
    @XmlElement(name = "SituationFullRef", namespace = "http://www.siri.org.uk/siri")
    protected SituationFullRef situationFullRef;
    @XmlElement(name = "Note", namespace = "http://www.siri.org.uk/siri")
    protected NaturalLanguageString note;

    /**
     * Gets the value of the situationRef property.
     * 
     * @return
     *     possible object is
     *     {@link SituationRef }
     *     
     */
    public SituationRef getSituationRef() {
        return situationRef;
    }

    /**
     * Sets the value of the situationRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationRef }
     *     
     */
    public Note setSituationRef(SituationRef value) {
        this.situationRef = value;
        return this;
    }

    /**
     * Gets the value of the situationSimpleRef property.
     * 
     * @return
     *     possible object is
     *     {@link SituationSimpleRef }
     *     
     */
    public SituationSimpleRef getSituationSimpleRef() {
        return situationSimpleRef;
    }

    /**
     * Sets the value of the situationSimpleRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationSimpleRef }
     *     
     */
    public Note setSituationSimpleRef(SituationSimpleRef value) {
        this.situationSimpleRef = value;
        return this;
    }

    /**
     * Gets the value of the situationFullRef property.
     * 
     * @return
     *     possible object is
     *     {@link SituationFullRef }
     *     
     */
    public SituationFullRef getSituationFullRef() {
        return situationFullRef;
    }

    /**
     * Sets the value of the situationFullRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationFullRef }
     *     
     */
    public Note setSituationFullRef(SituationFullRef value) {
        this.situationFullRef = value;
        return this;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageString }
     *     
     */
    public NaturalLanguageString getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageString }
     *     
     */
    public Note setNote(NaturalLanguageString value) {
        this.note = value;
        return this;
    }

}