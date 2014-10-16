package gatech.team13.classproject.controller;

import java.util.Random;

import gatech.team13.classproject.dao.impl.ClinicalDocDAOImpl;
import gatech.team13.classproject.dao.impl.UserDAOImpl;
import gatech.team13.classproject.jxab.ClinicalDocumentType;
import gatech.team13.classproject.jxab.ClinicalDocumentTypeDF;


/*************************************************************************
 * This class servers as a proxy class between the application front
 * end and the back-end interactions with the database and XML file.
 * All calls from the front will come through this class which uses
 * DWR to communicate to the front end application. 
 * 
 * @author Craig Graham
 *************************************************************************/
public class DBServiceController {

	/*** Instance of the DAO class to interact with the XML file parser*/
	ClinicalDocDAOImpl daoImpl;
	
	/*** Instance of the DAO class to interact with the Google App Engine DataStore*/
	UserDAOImpl dataStoreDAOImpl;
	/*********************************************************************
	 * Default Constructor - Required by DWR
	 * 
	 *********************************************************************/
	public DBServiceController() {
		
		//Instantiate the DAO instance
		daoImpl = new ClinicalDocDAOImpl();
		
		dataStoreDAOImpl = new UserDAOImpl();
	}
	
	/*********************************************************************
	 * Starts off the process to get the XML file data via JaxB parsing.
	 * 
	 * @param id - integer user id which is used to verify that the 
	 * 			   user is able to access the information
	 * 
	 * @return the ClinicalDocument Object containing the information
	 * 			   requested
	 *********************************************************************/
	public ClinicalDocumentTypeDF getData(int id, String patient) {
		
		
		//Retrieve the XML data from the JaxB parser
		ClinicalDocumentType result = daoImpl.getDocumentData(patient);
		
		//Some conversion is required to remove dependencies which cannot be
		//represented by DWR.
		ClinicalDocumentTypeDF toReturn = new ClinicalDocumentTypeDF(result);
		
		return toReturn;
	}
	
	public long checkLogin(String username, String password)  {
		return dataStoreDAOImpl.checkLogin(username, password);
	}
	public boolean removeUser(long userId)  {
		return dataStoreDAOImpl.removeUser(userId);
	}
	public long createUser(String username, String password)  {
		Random random = new Random();
		Long userId = Long.valueOf(random.nextInt(1000));
		return dataStoreDAOImpl.addUser(username, password, userId) ? userId.longValue() : -1;
	}
} 
