package gatech.team13.classproject.jxab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class EffectiveTimeTypeDF {

	
    protected List<Object> content;
    protected String value;
    
	public EffectiveTimeTypeDF(EffectiveTimeType effectiveTime) {
		content = new ArrayList<Object>();
		for(Serializable s : effectiveTime.getContent()) {
    		if(s.getClass().equals(javax.xml.bind.JAXBElement.class)) {
    			try {
    				javax.xml.bind.JAXBElement tmp = (javax.xml.bind.JAXBElement) s;
    				if(tmp.getDeclaredType().equals(LowType.class)) {
    					content.add((LowType)tmp.getValue());
    				}else if(tmp.getDeclaredType().equals(HighType.class)) {
    					content.add((HighType)tmp.getValue());
    				}else {
    					//(ReferenceType)
    					content.add(tmp.getValue());
    				}
    			}catch(ClassCastException e) {
    				System.out.println("Class Cast Expection EffectiveTimeTypeDF");
    			}
    		}else {
    			content.add(s);
    		}
    	}
		this.value = effectiveTime.getValue();
	}

	public List<Object> getContent() {
		return content;
	}

	public void setContent(List<Object> content) {
		this.content = content;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
