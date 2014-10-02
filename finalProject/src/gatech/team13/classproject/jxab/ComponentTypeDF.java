package gatech.team13.classproject.jxab;

public class ComponentTypeDF {

	protected SectionTypeDF section;
    protected ObservationTypeDF observation;
    protected StructuredBodyTypeDF structuredBody;
    
	public ComponentTypeDF(ComponentType component) {
		if(component.getSection() != null) {
			this.section = new SectionTypeDF(component.getSection());
		}
		if(component.getObservation() != null) {
			this.observation = new ObservationTypeDF(component.getObservation());
		}
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

	public ObservationTypeDF getObservation() {
		return observation;
	}

	public void setObservation(ObservationTypeDF observation) {
		this.observation = observation;
	}

	public StructuredBodyTypeDF getStructuredBody() {
		return structuredBody;
	}

	public void setStructuredBody(StructuredBodyTypeDF structuredBody) {
		this.structuredBody = structuredBody;
	}
	
}
