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
 * <p>Java class for assignedCustodianType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assignedCustodianType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="representedCustodianOrganization" type="{urn:hl7-org:v3}representedCustodianOrganizationType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assignedCustodianType", propOrder = {
    "representedCustodianOrganization"
})
public class AssignedCustodianType {

    @XmlElement(required = true)
    protected RepresentedCustodianOrganizationType representedCustodianOrganization;

    /**
     * Gets the value of the representedCustodianOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link RepresentedCustodianOrganizationType }
     *     
     */
    public RepresentedCustodianOrganizationType getRepresentedCustodianOrganization() {
        return representedCustodianOrganization;
    }

    /**
     * Sets the value of the representedCustodianOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepresentedCustodianOrganizationType }
     *     
     */
    public void setRepresentedCustodianOrganization(RepresentedCustodianOrganizationType value) {
        this.representedCustodianOrganization = value;
    }

}
