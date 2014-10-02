package gatech.team13.classproject.jxab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class SectionTypeDF {

    protected TemplateIdType templateId;
    protected CodeTypeDF code;
    protected String title;
    protected SectionTypeDF.TextDF text;
    protected EntryTypeDFList entry;
    
    
	public SectionTypeDF(SectionType section) {
		this.templateId = section.getTemplateId();
		if(section.getCode() != null) {
			this.code = new CodeTypeDF(section.getCode());
		}
		this.title = section.getTitle();
		if(section.text != null) {
			this.text = new SectionTypeDF.TextDF(section.getText());
		}
		this.entry = new EntryTypeDFList(section.getEntry());
		
	}




	public TemplateIdType getTemplateId() {
		return templateId;
	}




	public void setTemplateId(TemplateIdType templateId) {
		this.templateId = templateId;
	}




	public CodeTypeDF getCode() {
		return code;
	}




	public void setCode(CodeTypeDF code) {
		this.code = code;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public SectionTypeDF.TextDF getText() {
		return text;
	}




	public void setText(SectionTypeDF.TextDF text) {
		this.text = text;
	}




	public EntryTypeDFList getEntry() {
		return entry;
	}




	public void setEntry(EntryTypeDFList entry) {
		this.entry = entry;
	}
    
	 public static class TextDF {

	    
	        protected List<Object> content;
	        
	        public TextDF(SectionType.Text text) {
	        	content = new ArrayList<Object>();
	        	for(Serializable s : text.getContent()) {
	        		if(s.getClass().equals(javax.xml.bind.JAXBElement.class)) {
	        			try {
	        				javax.xml.bind.JAXBElement tmp = (javax.xml.bind.JAXBElement) s;
	        				if(tmp.getDeclaredType().equals(TableType.class)) {
	        					content.add(new TableTypeDF((TableType)tmp.getValue()));
	        				}else if(tmp.getDeclaredType().equals(ContentType.class)) {
	        					content.add((ContentType)tmp.getValue());
	        				}else if(tmp.getDeclaredType().equals(ListType.class)) {
	        					content.add((ListType)tmp.getValue());
	        				}else {
	        					//(ReferenceType)
	        					content.add(tmp.getValue());
	        				}
	        			}catch(ClassCastException e) {
	        				System.out.println("Class Cast Expection SectionTypeDF.TextDF");
	        			}
	        		}else {
	        			content.add(s);
	        		}
	        	}
	        }
	        /**
	         * Gets the value of the content property.
	         * 
	         * <p>
	         * This accessor method returns a reference to the live list,
	         * not a snapshot. Therefore any modification you make to the
	         * returned list will be present inside the JAXB object.
	         * This is why there is not a <CODE>set</CODE> method for the content property.
	         * 
	         * <p>
	         * For example, to add a new item, do as follows:
	         * <pre>
	         *    getContent().add(newItem);
	         * </pre>
	         * 
	         * 
	         * <p>
	         * Objects of the following type(s) are allowed in the list
	         * {@link JAXBElement }{@code <}{@link ContentType }{@code >}
	         * {@link JAXBElement }{@code <}{@link TableType }{@code >}
	         * {@link String }
	         * {@link JAXBElement }{@code <}{@link ListType }{@code >}
	         * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
	         * 
	         * 
	         */
	        public List<Object> getContent() {
	            if (content == null) {
	                content = new ArrayList<Object>();
	            }
	            return this.content;
	        }

	    }
    
    
}
