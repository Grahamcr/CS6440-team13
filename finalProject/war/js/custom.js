this.ALLERGIES = "ALLERGIES, ADVERSE REACTIONS, ALERTS";
this.ENCOUNTERS = "Encounters";
this.MEDICATION ="Medications";
this.PROBLEMS = "PROBLEMS";
this.PROCEDURES = "PROCEDURES";
this.RESULTS = "RESULTS";
this.SOCIAL = "Soical History";

/*********************************************************************
 * On page load, pass a fake user id and then pull the XML data 
 ********************************************************************/
$(document).ready(function() {
	var userId = localStorage.getItem("userId");
	injectUsername();
	//Make a DWR call to the Controller to ask for the XML data
	DBServiceController.getData(userId, {
		  callback:function(returnVal) {
			  var value = returnVal;
			  parseResults(value);
			  displayAlert("Successful Data Pull!! Here is some of the information pull, parsed and returned :)", "alert-success", "Victory!")
		  }
		});
});
/*********************************************************************
 * Parse the results that we care about and inject the content into
 * the DOM structure.
 ********************************************************************/
var parseResults = function(results) {
	var components = results.component.structuredBody.component;
	for(var i = 0; i < components.length; i++) {
		var section = components[i].section;
		switch(section.title) {
			case this.ALLERGIES:
				
			break;
			case this.ENCOUNTERS:
				parseEncounters(section.text.content);
			break;
			case this.MEDICATION:
				parseMedication(section.text.content);
			break;
			case this.PROBLEMS:
				
			break;
			case this.PROCEDURES:
				
			break;
			case this.RESULTS:
				
			break;
			case this.SOCIAL:
				
			break;
		}
	}
};
/*********************************************************************
 * Parse patient encounter information and inject it into the widget
 ********************************************************************/
var parseEncounters = function(results) {
	var encounterTable = $('#encounter-tb')[0];
	var toInject = new Array();
	
};
/*********************************************************************
 * Parse patient m information and inject it into the widget
 ********************************************************************/
var parseMedication = function(results) {
	var medicationTable = $('#medication-tb')[0];
	var toInject = new Array();
};

/*********************************************************************
 * Pull the username from local storage and welcome them to this page
 ********************************************************************/
var injectUsername = function() {
	var username =  localStorage.getItem("username");
	$('#username-div')[0].innerHTML = "<p class='voice-brand username-text'> Welcome " + username  + "</p>";
};

/*********************************************************************
 * If the call to get XML data is successful, inject the data
 * into the page by buliding HTML from the content
 ********************************************************************/
var injectTableRows = function(table, rows) {
	
};
/*********************************************************************
 * Display an alert message to the user
 ********************************************************************/
var displayAlert = function(text, classType, title) {
	
	//Create the alert HTML
    var alertHTML = '<div id="alert-div" class="alert ' + classType+' alert-dismissable" sytle="display:none;">' +
	  '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>' +
	  '<strong id="alert-title">'+ title +':</strong> <p id="alert-content">'+ text +'</p>' +
	'</div>';
	  
    //Get the alert div
    var alertDiv = $('#alert-div-wrapper')[0];
    //Inject html into the Widget Alert Div
    alertDiv.innerHTML = alertHTML;
    
    //Show the div using JQuery Show
    $(alertDiv).show();
    
    // Scroll to the top of the search results
	if (!!alertDiv && alertDiv.scrollIntoView) {
		alertDiv.scrollIntoView();
	}
    //Wait Six Seconds and then hide
    setTimeout(function() {
    	$(alertDiv).hide();
	}, 6000);
};