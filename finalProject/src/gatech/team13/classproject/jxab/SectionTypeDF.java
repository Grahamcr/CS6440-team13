package gatech.team13.classproject.jxab;


public class SectionTypeDF {

    protected TemplateIdType templateId;
    protected CodeType code;
    protected String title;
    protected SectionType.Text text;
    protected EntryTypeDFList entry;
    
    
	public SectionTypeDF(SectionType section) {
		this.templateId = section.getTemplateId();
		this.code = section.getCode();
		this.title = section.getTitle();
		this.text = section.getText();
		this.entry = new EntryTypeDFList(section.getEntry());
	}




	public TemplateIdType getTemplateId() {
		return templateId;
	}




	public void setTemplateId(TemplateIdType templateId) {
		this.templateId = templateId;
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




	public SectionType.Text getText() {
		return text;
	}




	public void setText(SectionType.Text text) {
		this.text = text;
	}




	public EntryTypeDFList getEntry() {
		return entry;
	}




	public void setEntry(EntryTypeDFList entry) {
		this.entry = entry;
	}
    
    
    
}
