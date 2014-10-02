package gatech.team13.classproject.jxab;


public class EntryTypeDF {

	protected EncounterTypeDF encounter;
    protected SubstanceAdministrationTypeDF substanceAdministration;
    protected ActTypeDF act;
    protected OrganizerTypeDF organizer;
    protected ObservationTypeDF observation;
    protected String typeCode;
    
	 public EntryTypeDF(EntryType e) {
		 if(e.getEncounter() != null) {
			 this.encounter = new EncounterTypeDF(e.getEncounter()); 
		 }
		 if(e.getSubstanceAdministration() != null) {
			 this.substanceAdministration = new SubstanceAdministrationTypeDF(e.getSubstanceAdministration());
		 }
		 if(e.getAct() != null) {
			 this.act = new ActTypeDF(e.getAct());
		 }
		 if(e.getObservation() != null) {
			 this.observation = new ObservationTypeDF(e.getObservation());
		 }
		this.typeCode = e.getTypeCode();
		if(e.getOrganizer() != null) {
			this.organizer = new OrganizerTypeDF(e.getOrganizer());
		}
	}

	public EncounterTypeDF getEncounter() {
		return encounter;
	}

	public void setEncounter(EncounterTypeDF encounter) {
		this.encounter = encounter;
	}

	public SubstanceAdministrationTypeDF getSubstanceAdministration() {
		return substanceAdministration;
	}

	public void setSubstanceAdministration(
			SubstanceAdministrationTypeDF substanceAdministration) {
		this.substanceAdministration = substanceAdministration;
	}

	public ActTypeDF getAct() {
		return act;
	}

	public void setAct(ActTypeDF act) {
		this.act = act;
	}

	public OrganizerTypeDF getOrganizer() {
		return organizer;
	}

	public void setOrganizer(OrganizerTypeDF organizer) {
		this.organizer = organizer;
	}

	public ObservationTypeDF getObservation() {
		return observation;
	}

	public void setObservation(ObservationTypeDF observation) {
		this.observation = observation;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	 
	    
}
