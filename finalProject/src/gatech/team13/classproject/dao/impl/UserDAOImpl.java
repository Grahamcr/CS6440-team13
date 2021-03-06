package gatech.team13.classproject.dao.impl;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class UserDAOImpl {

	/**User Table Constants*/
	private static final String USER_UID = "uid";
	private static final String USER_NAME = "uname";
	private static final String USER_PASS = "upass";
	private static final String USER_ROLE = "urole";

	
	/*******************************************************************************
	 * Default Constructor
	 *******************************************************************************/
	public UserDAOImpl() {
		
	}
	
	/*******************************************************************************
	 * Create a new user account in WTM to match the one the user created in MTM.
	 * This information come via REST service call from MTM. 
	 *
	 * @param username - String: Username entered by the user on the login 
									screen of MTM
	 * @param password - String: Password entered by the user on the login 
									screen of MTM
	 * @param userId - long: The unique Id assgined to the user by MTM when they
								created their account
	 * @param role - String: role for the user (Such as PCP) 
	 *******************************************************************************/
	public boolean addUser(String username, String password, Long userId, String role) {
		
		//Use the userId as the key for the "User" table in the DataStore
		Key taskKey = KeyFactory.createKey("User", userId.longValue());
	    Entity task = new Entity("User", taskKey);
		
		//Add the username, password and userId to the entry
	    task.setProperty(USER_UID, userId.longValue());
	    task.setProperty(USER_NAME, username);
	    task.setProperty(USER_PASS, password);
	    task.setProperty(USER_ROLE, role);

		//Get connection to the DataStore and store the new user entry
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    datastore.put(task); 
	    
		//Make sure the store was successful....
	    @SuppressWarnings("deprecation")
		Query q = new Query("User")
        .addFilter(USER_NAME,
                   Query.FilterOperator.EQUAL,
                   username);
		PreparedQuery pq = datastore.prepare(q);
		for(Entity entityTask : pq.asIterable()) {
			String dbPass = (String) entityTask.getProperty(USER_PASS);
			Long dbId = (Long) entityTask.getProperty(USER_UID);
		}
	    
		//return success
	    return true;
	}
	/*****************************************************************************
	 * Verify the user has entered a valid username and password
	 * 
	 * @param long: The userId which corresponds to the username/password
	 * @return String: role for the user (Such as PCP)
	 *****************************************************************************/
	public String getRoleForID(Long userID) {
		String toReturn = "Not Found";
		
		//Establish connection to the DataStore
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		//Query the DataStore "User" table for any username matching the one entered
		@SuppressWarnings("deprecation")
		Query q = new Query("User")
        .addFilter(USER_UID,
                   Query.FilterOperator.EQUAL,
                   userID);
		PreparedQuery pq = datastore.prepare(q);
		
		//Check to see if the user has a role in the system
		for(Entity entityTask : pq.asIterable()) {
			String role = (String) entityTask.getProperty(USER_ROLE);
			if(role != null && role.length() > 0) {
				toReturn = role;
				break;
			}
		}
		
		//Return the role as a String
		return toReturn;
	}
	/*****************************************************************************
	 * Verify the user has entered a valid username and password
	 * 
	 * @param username - String: Username entered by the user on the login 
									screen of WTM
	 * @param password - String: Password entered by the user on the login 
									screen of WTM
	 * @return long: The userId which corresponds to the username/password
	 *****************************************************************************/
	public long checkLogin(String username, String password) {
		long toReturn = -1;
		
		//Establish connection to the DataStore
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		//Query the DataStore "User" table for any username matching the one entered
		@SuppressWarnings("deprecation")
		Query q = new Query("User")
        .addFilter(USER_NAME,
                   Query.FilterOperator.EQUAL,
                   username);
		PreparedQuery pq = datastore.prepare(q);
		
		//Check to see if any matching usernames have the same password as entered
		for(Entity entityTask : pq.asIterable()) {
			String dbPass = (String) entityTask.getProperty(USER_PASS);
			
			//If passwords match, return the the userId
			if(password.equals(dbPass)) {
				Long dbId = (Long) entityTask.getProperty(USER_UID);
				toReturn = dbId.longValue();
				break;
			}
		}
		
		//Return the userId
		return toReturn;
	}
	

	/*******************************************************************************
	 * Create a new user account in WTM to match the one the user created in MTM.
	 * This information come via REST service call from MTM. 
	 *
	 * @param userId - long: The unique Id assigned to the user by MTM when they
								created their account
	 *******************************************************************************/
	public boolean removeUser(Long userId) {
		
		//Establish a connection with the DataStore
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
				
		//Use the userId as the key to remove the user account
		Key userKey = KeyFactory.createKey("User", userId.longValue());
		
		@SuppressWarnings("deprecation")
		Query q = new Query("User")
        .addFilter(USER_UID,
                   Query.FilterOperator.EQUAL,
                   userId.longValue());
		PreparedQuery pq = datastore.prepare(q);
		for(Entity entityTask : pq.asIterable()) {
			//remove the user accounts
			datastore.delete(entityTask.getKey());
		}
			    		
		//return success
	    return true;
	}
}
