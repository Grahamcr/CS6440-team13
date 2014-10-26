//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.04 at 01:28:14 PM EDT 
//


package gatech.team13.classproject.jxab;



/**
 * <p>Java class for substanceAdministrationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="substanceAdministrationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}templateIdType"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}idType"/>
 *         &lt;element name="text" type="{urn:hl7-org:v3}textType"/>
 *         &lt;element name="statusCode" type="{urn:hl7-org:v3}statusCodeType"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}effectiveTimeType"/>
 *         &lt;element name="routeCode" type="{urn:hl7-org:v3}routeCodeType"/>
 *         &lt;element name="doseQuantity" type="{urn:hl7-org:v3}doseQuantityType"/>
 *         &lt;element name="administrationUnitCode" type="{urn:hl7-org:v3}administrationUnitCodeType"/>
 *         &lt;element name="consumable" type="{urn:hl7-org:v3}consumableType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="classCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="moodCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class SubstanceAdministrationTypeDF {

    protected TemplateIdType templateId;
    protected IdType id;
    protected TextTypeDF text;
    protected StatusCodeType statusCode;
    protected EffectiveTimeTypeDF effectiveTime;
    protected RouteCodeType routeCode;
    protected DoseQuantityType doseQuantity;
    protected AdministrationUnitCodeType administrationUnitCode;
    protected ConsumableType consumable;
    protected String classCode;
    protected String moodCode;
    
    public SubstanceAdministrationTypeDF(SubstanceAdministrationType s) {
		this.templateId = s.getTemplateId();
		this.id = s.getId();
		if(s.getText() != null) {
			this.text = new TextTypeDF(s.getText());
		}
		this.statusCode = s.getStatusCode();
		if(s.getEffectiveTime() != null) {
			this.effectiveTime = new EffectiveTimeTypeDF(s.getEffectiveTime());
		}
		this.routeCode = s.getRouteCode();
		this.doseQuantity = s.getDoseQuantity();
		this.administrationUnitCode = s.getAdministrationUnitCode();
		this.consumable = s.getConsumable();
		this.classCode = s.getClassCode();
		this.moodCode = s.getMoodCode();
	}
    /**
     * Gets the value of the templateId property.
     * 
     * @return
     *     possible object is
     *     {@link TemplateIdType }
     *     
     */
    public TemplateIdType getTemplateId() {
        return templateId;
    }

    /**
     * Sets the value of the templateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateIdType }
     *     
     */
    public void setTemplateId(TemplateIdType value) {
        this.templateId = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setId(IdType value) {
        this.id = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextTypeDF getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setText(TextTypeDF value) {
        this.text = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link StatusCodeType }
     *     
     */
    public StatusCodeType getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusCodeType }
     *     
     */
    public void setStatusCode(StatusCodeType value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link EffectiveTimeType }
     *     
     */
    public EffectiveTimeTypeDF getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectiveTimeType }
     *     
     */
    public void setEffectiveTime(EffectiveTimeTypeDF value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the routeCode property.
     * 
     * @return
     *     possible object is
     *     {@link RouteCodeType }
     *     
     */
    public RouteCodeType getRouteCode() {
        return routeCode;
    }

    /**
     * Sets the value of the routeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteCodeType }
     *     
     */
    public void setRouteCode(RouteCodeType value) {
        this.routeCode = value;
    }

    /**
     * Gets the value of the doseQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link DoseQuantityType }
     *     
     */
    public DoseQuantityType getDoseQuantity() {
        return doseQuantity;
    }

    /**
     * Sets the value of the doseQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoseQuantityType }
     *     
     */
    public void setDoseQuantity(DoseQuantityType value) {
        this.doseQuantity = value;
    }

    /**
     * Gets the value of the administrationUnitCode property.
     * 
     * @return
     *     possible object is
     *     {@link AdministrationUnitCodeType }
     *     
     */
    public AdministrationUnitCodeType getAdministrationUnitCode() {
        return administrationUnitCode;
    }

    /**
     * Sets the value of the administrationUnitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdministrationUnitCodeType }
     *     
     */
    public void setAdministrationUnitCode(AdministrationUnitCodeType value) {
        this.administrationUnitCode = value;
    }

    /**
     * Gets the value of the consumable property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumableType }
     *     
     */
    public ConsumableType getConsumable() {
        return consumable;
    }

    /**
     * Sets the value of the consumable property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumableType }
     *     
     */
    public void setConsumable(ConsumableType value) {
        this.consumable = value;
    }

    /**
     * Gets the value of the classCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * Sets the value of the classCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassCode(String value) {
        this.classCode = value;
    }

    /**
     * Gets the value of the moodCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoodCode() {
        return moodCode;
    }

    /**
     * Sets the value of the moodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoodCode(String value) {
        this.moodCode = value;
    }

}