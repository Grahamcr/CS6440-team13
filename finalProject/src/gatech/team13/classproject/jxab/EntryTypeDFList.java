package gatech.team13.classproject.jxab;

import java.util.ArrayList;
import java.util.List;

public class EntryTypeDFList {

	protected List<EntryTypeDF> entries;
	
	public EntryTypeDFList(List<EntryType> entry) {
		entries = new ArrayList<EntryTypeDF>();
		if(entry != null)  {
			for(EntryType e : entry) {
				entries.add(new EntryTypeDF(e));
			}
		}
	}

	public List<EntryTypeDF> getEntries() {
		return entries;
	}

	public void setEntries(List<EntryTypeDF> entries) {
		this.entries = entries;
	}

	
}
