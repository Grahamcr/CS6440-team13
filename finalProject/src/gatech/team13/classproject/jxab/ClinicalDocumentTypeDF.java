package gatech.team13.classproject.jxab;

import java.util.List;


public class ClinicalDocumentTypeDF {

	protected RealmCodeType realmCode;
    protected TypeIdType typeId;
    protected List<TemplateIdType> templateId;
    protected IdType id;
    protected CodeType code;
    protected String title;
    protected EffectiveTimeTypeDF effectiveTime;
    protected ConfidentialityCodeType confidentialityCode;
    protected LanguageCodeType languageCode;
    protected RecordTargetType recordTarget;
    protected AuthorType author;
    protected CustodianType custodian;
    protected ComponentTypeDF component;
    
    public ClinicalDocumentTypeDF(ClinicalDocumentType result) {
		this.realmCode = result.getRealmCode();
		this.typeId = result.getTypeId();
		this.templateId = result.getTemplateId();
		this.id = result.getId();
		this.code = result.getCode();
		this.title = result.title;
		this.effectiveTime = new EffectiveTimeTypeDF(result.getEffectiveTime());
		this.confidentialityCode = result.getConfidentialityCode();
		this.languageCode = result.languageCode;
		this.recordTarget = result.getRecordTarget();
		this.author = result.getAuthor();
		this.custodian = result.getCustodian();
		this.component = new ComponentTypeDF(result.getComponent());
	}

	public RealmCodeType getRealmCode() {
		return realmCode;
	}

	public void setRealmCode(RealmCodeType realmCode) {
		this.realmCode = realmCode;
	}

	public TypeIdType getTypeId() {
		return typeId;
	}

	public void setTypeId(TypeIdType typeId) {
		this.typeId = typeId;
	}

	public List<TemplateIdType> getTemplateId() {
		return templateId;
	}

	public void setTemplateId(List<TemplateIdType> templateId) {
		this.templateId = templateId;
	}

	public IdType getId() {
		return id;
	}

	public void setId(IdType id) {
		this.id = id;
	}

	public CodeType getCode() {
		return code;
	}

	public void setCode(CodeType code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public EffectiveTimeTypeDF getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(EffectiveTimeTypeDF effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public ConfidentialityCodeType getConfidentialityCode() {
		return confidentialityCode;
	}

	public void setConfidentialityCode(ConfidentialityCodeType confidentialityCode) {
		this.confidentialityCode = confidentialityCode;
	}

	public LanguageCodeType getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(LanguageCodeType languageCode) {
		this.languageCode = languageCode;
	}

	public RecordTargetType getRecordTarget() {
		return recordTarget;
	}

	public void setRecordTarget(RecordTargetType recordTarget) {
		this.recordTarget = recordTarget;
	}

	public AuthorType getAuthor() {
		return author;
	}

	public void setAuthor(AuthorType author) {
		this.author = author;
	}

	public CustodianType getCustodian() {
		return custodian;
	}

	public void setCustodian(CustodianType custodian) {
		this.custodian = custodian;
	}

	public ComponentTypeDF getComponent() {
		return component;
	}

	public void setComponent(ComponentTypeDF component) {
		this.component = component;
	}
    
    
}
