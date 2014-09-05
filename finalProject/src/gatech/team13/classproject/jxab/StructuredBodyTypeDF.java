package gatech.team13.classproject.jxab;

import java.util.ArrayList;
import java.util.List;

public class StructuredBodyTypeDF {

	protected List<ComponentTypeDF> component;
	
	public StructuredBodyTypeDF(StructuredBodyType structuredBody) {
		component = new ArrayList<ComponentTypeDF>();
		if(structuredBody != null)  {
			for(ComponentType c  : structuredBody.getComponent()) {
				component.add(new ComponentTypeDF(c));
			}
		}
	}

	public List<ComponentTypeDF> getComponent() {
		return component;
	}

	public void setComponent(List<ComponentTypeDF> component) {
		this.component = component;
	}

	
}
