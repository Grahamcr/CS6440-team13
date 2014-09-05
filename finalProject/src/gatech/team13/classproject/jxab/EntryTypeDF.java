package gatech.team13.classproject.jxab;


public class EntryTypeDF {

	protected EncounterType encounter;
    protected SubstanceAdministrationType substanceAdministration;
    protected ActType act;
    protected OrganizerTypeDF organizer;
    protected ObservationType observation;
    protected String typeCode;
    
	 public EntryTypeDF(EntryType e) {
		this.encounter = e.getEncounter();
		this.substanceAdministration = e.getSubstanceAdministration();
		this.act = e.getAct();
		this.observation = e.getObservation();
		this.typeCode = e.getTypeCode();
		this.organizer = new OrganizerTypeDF(e.getOrganizer());
	}
	    
}
