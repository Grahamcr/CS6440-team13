package gatech.team13.classproject.dao.impl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import gatech.team13.classproject.jxab.ClinicalDocumentType;

/***********************************************************************************************
 * This DAO class serves as the data retrieval service for the Clinical Data XML file.
 * It utilizes JAXB to parse the XML file based on a generated XSD.  That parsed information 
 * is then placed into a Java Class hierarchy which the highest level class being 
 * ClinicalDocumentType 
 * 
 * @author Craig Graham
 ************************************************************************************************/
public class ClinicalDocDAOImpl {

	/********************************************************************************************
	 * Default Constructor
	 ********************************************************************************************/
	public ClinicalDocDAOImpl() {

	}
	
	/********************************************************************************************
	 * Method to read the XML file and parse the data into a Java class hierarchy using JAXB.
	 * @param patient 
	 * 
	 * @param - String name: XML file name
	 * @return ClinicalDocumentType Object containing the information from the XML file
	 ********************************************************************************************/
	public ClinicalDocumentType getDocumentData(String patient) {
		
		//Object to eventually return
		ClinicalDocumentType toReturn = null;
		try {
			Source source = null;
			
			if(patient.equals("Marla Dixon")) {
				//	Pull in the requested file
				source = new StreamSource(new File("MarlasCCD.xml"));
			}
			
			//TODO:Change this to pull in the second CCD
			else if(patient.equals("Patient2 Lastname")) {
				source = new StreamSource(new File("MarlasCCD.xml"));
			}
			//Create the JaxB Parser Instance
			JAXBContext jc = JAXBContext.newInstance(ClinicalDocumentType.class);
			Unmarshaller u = jc.createUnmarshaller();
			
			//Unmarshal/parse the data
			JAXBElement<ClinicalDocumentType> root = u.unmarshal(source,  ClinicalDocumentType.class);
			
			//Get the Java Object we are looking for from the results
			toReturn = root.getValue();
		
		//Just keep track of anything that might go wrong for now.....
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

}
