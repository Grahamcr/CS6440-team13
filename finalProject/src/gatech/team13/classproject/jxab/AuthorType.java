//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.04 at 01:28:14 PM EDT 
//


package gatech.team13.classproject.jxab;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for authorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="time" type="{urn:hl7-org:v3}timeType"/>
 *         &lt;element name="assignedAuthor" type="{urn:hl7-org:v3}assignedAuthorType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authorType", propOrder = {
    "time",
    "assignedAuthor"
})
public class AuthorType {

    @XmlElement(required = true)
    protected TimeType time;
    @XmlElement(required = true)
    protected AssignedAuthorType assignedAuthor;

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setTime(TimeType value) {
        this.time = value;
    }

    /**
     * Gets the value of the assignedAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link AssignedAuthorType }
     *     
     */
    public AssignedAuthorType getAssignedAuthor() {
        return assignedAuthor;
    }

    /**
     * Sets the value of the assignedAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignedAuthorType }
     *     
     */
    public void setAssignedAuthor(AssignedAuthorType value) {
        this.assignedAuthor = value;
    }

}