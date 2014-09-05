package gatech.team13.classproject.jxab;

import java.io.Serializable;
import java.util.List;


public class EffectiveTimeTypeDF {

	
    protected List<Serializable> content;
    protected String value;
    
	public EffectiveTimeTypeDF(EffectiveTimeType effectiveTime) {
		this.content = effectiveTime.getContent();
		this.value = effectiveTime.getValue();
	}

	public List<Serializable> getContent() {
		return content;
	}

	public void setContent(List<Serializable> content) {
		this.content = content;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
