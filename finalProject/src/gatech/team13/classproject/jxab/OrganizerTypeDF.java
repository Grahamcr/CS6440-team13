package gatech.team13.classproject.jxab;


public class OrganizerTypeDF {

    protected TemplateIdType templateId;
    protected IdType id;
    protected CodeType code;
    protected StatusCodeType statusCode;
    protected ComponentType component;
    protected String classCode;
    protected String moodCode;

    
	public OrganizerTypeDF(OrganizerType organizer) {
		this.templateId = organizer.getTemplateId();
		this.id = organizer.getId();
		this.code = organizer.getCode();
		this.statusCode = organizer.getStatusCode();
		this.component = organizer.getComponent();
		this.classCode = organizer.getClassCode();
		this.moodCode = organizer.getMoodCode();
	}


	public TemplateIdType getTemplateId() {
		return templateId;
	}


	public void setTemplateId(TemplateIdType templateId) {
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


	public StatusCodeType getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(StatusCodeType statusCode) {
		this.statusCode = statusCode;
	}


	public ComponentType getComponent() {
		return component;
	}


	public void setComponent(ComponentType component) {
		this.component = component;
	}


	public String getClassCode() {
		return classCode;
	}


	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}


	public String getMoodCode() {
		return moodCode;
	}


	public void setMoodCode(String moodCode) {
		this.moodCode = moodCode;
	}

}
