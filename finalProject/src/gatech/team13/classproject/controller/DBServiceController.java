package gatech.team13.classproject.controller;

import gatech.team13.classproject.dao.ClinicalDocDAOImpl;
import gatech.team13.classproject.jxab.ClinicalDocumentType;
import gatech.team13.classproject.jxab.ClinicalDocumentTypeDF;

public class DBServiceController {

	public DBServiceController() {
		
	}
	
	public ClinicalDocumentTypeDF getData(int id) {
		ClinicalDocDAOImpl impl = new ClinicalDocDAOImpl();
		ClinicalDocumentType result = impl.getDocumentData();
		ClinicalDocumentTypeDF toReturn = new ClinicalDocumentTypeDF(result);
		return toReturn;
	}
} 
