package gatech.team13.classproject.jxab;

public class ComponentTypeDF {

	protected SectionTypeDF section;
    protected ObservationType observation;
    protected StructuredBodyTypeDF structuredBody;
    
	public ComponentTypeDF(ComponentType component) {
		if(section != null) {
			this.section = new SectionTypeDF(component.getSection());
		}
		this.observation = component.getObservation();
		if(component.getStructuredBody() != null) {
			this.structuredBody = new StructuredBodyTypeDF(component.getStructuredBody());
		}
	}

	public SectionTypeDF getSection() {
		return section;
	}

	public void setSection(SectionTypeDF section) {
		this.section = section;
	}

	public ObservationType getObservation() {
		return observation;
	}

	public void setObservation(ObservationType observation) {
		this.observation = observation;
	}

	public StructuredBodyTypeDF getStructuredBody() {
		return structuredBody;
	}

	public void setStructuredBody(StructuredBodyTypeDF structuredBody) {
		this.structuredBody = structuredBody;
	}
	
}
