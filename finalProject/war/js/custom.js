this.ALLERGIES = "ALLERGIES, ADVERSE REACTIONS, ALERTS";
this.ENCOUNTERS = "Encounters";
this.MEDICATION ="Medications";
this.PROBLEMS = "PROBLEMS";
this.PROCEDURES = "PROCEDURES";
this.RESULTS = "RESULTS";
this.SOCIAL = "Soical History";//TODO let's fix this. The XML shouldn't be mispelled


/**************************************************************************
 * Typeahead Stuff
 *************************************************************************/
var substringMatcher = function(strs) {
	  return function findMatches(q, cb) {
	    var matches, substrRegex;
	 
	    // an array that will be populated with substring matches
	    matches = [];
	 
	    // regex used to determine if a string contains the substring `q`
	    substrRegex = new RegExp(q, 'i');
	 
	    // iterate through the pool of strings and for any string that
	    // contains the substring `q`, add it to the `matches` array
	    $.each(strs, function(i, str) {
	      if (substrRegex.test(str)) {
	        // the typeahead jQuery plugin expects suggestions to a
	        // JavaScript object, refer to typeahead docs for more info
	        matches.push({ value: str });
	      }
	    });
	 
	    cb(matches);
	  };
};
	 
var patients = ['Marla Dixon', 'Bob Dixon'];
	 
	$('#the-basics .typeahead').typeahead({
	  hint: true,
	  highlight: true,
	  minLength: 1
	},
	{
	  name: 'patient',
	  displayKey: 'value',
	  source: substringMatcher(patients),
	  updater: function(item) {
	    	openCCD();
	        return item;
	    }
	});


/*********************************************************************
 * On page load, pass a fake user id and then pull the XML data 
 ********************************************************************/
$(document).ready(function() {
	
	//Show the loading bar
	showHideLoadingWheel(true, "Loading Patient CCD...");
	
	var userId = localStorage.getItem("userId");
	
	//Make a DWR call to the Controller to ask for the user's role
	DBServiceController.getUserRoleById(userId, {
		  callback:function(returnVal) {
			  var value = returnVal;
			  highlightAreas(value);
			  localStorage.setItem("userrole", value);
			  injectUsername();
			 // displayAlert("You Are Registered as a: " + value, "alert-success", "Test Show Role Results:");
			  
		  }
		});
	
	//Make a DWR call to the Controller to ask for the XML data
	DBServiceController.getData(userId, 'Marla Dixon', {
		  callback:function(returnVal) {
			  var value = returnVal;
			  parseResults(value);
			  
			  
				
//			  displayAlert("Successful Data Pull!! Here is some of the information pull, parsed and returned :)", "alert-success", "Victory!")
			  showHideLoadingWheel(false);
		  }
		});
	  var picDiv = $('#user-pic-wrapper')[0];
	  picDiv.innerHTML = "<img id='userpic' src='/img/Marla.PNG'></img>";
});

var logout = function(){
	localStorage.clear();
	window.location = '/index.html';
}
/***************************************************************************
 * In The Auto-Complete search box if the user hits enter then open the
 * application that they have selected
 **************************************************************************/
$('#the-basics').bind('keypress', function(e) {
	if (e.keyCode == 13) {
		openCCD();
	}
});
/********************************************************************
 * Highlight the most relavent areas of the website for the 
 * type of role the user is.
 ********************************************************************/
var highlightAreas = function(role) {
	if(role == 'pcp') {
		var allergiesHeader = $('.allergies-header')[0];
		var allergiesContainer = $('#allergies-container')[0];
		$(allergiesHeader).css("color", "red");
		$(allergiesContainer).css("border", "3px solid red");
		$(allergiesContainer).css("color", "white !important");
	}else {
		var medicationWidget = $("#right-widget");
		medicationWidget.css("border", "3px solid lime");
		medicationWidget.css("color", "black");
		var medicationHeader = $('.right-widget-header')[0];
		$(medicationHeader).css('background-color', "#00CC00");
		$(medicationHeader).css('border-color', "green");
	}
};
/********************************************************************
 * Get the CCD for a given paitent and inject their information
 *******************************************************************/
var openCCD = function() {
	var typeahead = $('.tt-input')[0];
	var paitent = typeahead.value;
	
	//TODO:just use userID for now....
	var role = localStorage.getItem("userId");
	
	showHideLoadingWheel(true, "Loading Patient CCD...");
	
	var userId = localStorage.getItem("userId");
	injectUsername();
	var open = true;
	//Inject the picture
	var picDiv = $('#user-pic-wrapper')[0];
	if(paitent == 'Marla Dixon') {
		picDiv.innerHTML = "<img id='userpic' src='/img/Marla.PNG'></img>";
		DBServiceController.getMarlasAllergies( {
			  callback:function(returnVal) {
				  var value = returnVal;
				  parseAllergyResults(value);
			  }
			});
	}else if(paitent == 'Bob Dixon') {
		picDiv.innerHTML = "<img id='userpic' src='/img/Bob.PNG'></img>";
		DBServiceController.getBobsAllergies( {
			  callback:function(returnVal) {
				  var value = returnVal;
				  parseAllergyResults(value);
			  }
			});
	}else {
		open = false;
		showHideLoadingWheel(false);
		displayAlert("We could not find a paitent by the name: " + paitent + ".  Did you mean \"Marla Dixon\" or \"Bob Dixon\"?", "alert-danger", "Paitent Not Found")
	}
	
	if(open) {
		//Make a DWR call to the Controller to ask for the XML data
		DBServiceController.getData(role, paitent, {
		  callback:function(returnVal) {
			  var value = returnVal;
			  parseResults(value);
			  showHideLoadingWheel(false);
		  }
		});
	}
}
/*********************************************************************
 * Display or hide the application level loading wheel
 *********************************************************************/
var showHideLoadingWheel = function(show, headerText) {
	var pleaseWaitDiv = $('#pleaseWaitDialog');
	var loadingHeader = $('.loading-modal-header')[0];
	
	//Set the message
	loadingHeader.innerHTML = headerText;
	
	//Show or hide the loading modal
	show ? pleaseWaitDiv.show() :  pleaseWaitDiv.hide();

};
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
				//parseAllergies(section.text.content);
			break;
			case this.ENCOUNTERS:
				parseEncounters(section.text.content);
			break;
			case this.MEDICATION:
				parseMedication(section.text.content, section.entry.entries);
			break;
			case this.PROBLEMS:
				parseProblems(section.text.content);
			break;
			case this.PROCEDURES:
				parseProcedures(section.text.content);
			break;
			case this.RESULTS:
				parseLabResults(section.text.content);
			break;
			case this.SOCIAL:
				parseSocialHistory(section.text.content);
			break;
		}
	}
	
	//parse and add the patient information
	parsePatientInfo(results);
};

/*********************************************************************
 * Parse patient information and inject it into the widget
 ********************************************************************/
var parsePatientInfo = function(results) {
	var parentLvl = results.recordTarget.patientRole;
	var name = parentLvl.patient.name;
	var gender = parentLvl.patient.administrativeGenderCode.code;
	var addressParentLvl = parentLvl.addr;
	$('#patient-name')[0].innerHTML = name.family + ", " + name.given + ", " + name.suffix;
	$('#patient-address-1')[0].innerHTML = addressParentLvl.streetAddressLine;
	$('#patient-address-2')[0].innerHTML = addressParentLvl.city + ", " + addressParentLvl.state + ", " + addressParentLvl.postalCode;
	$('#patient-gender')[0].innerHTML = gender;
};

/*********************************************************************
 * Parse patient encounter information and inject it into the widget
 ********************************************************************/
var parseProcedures = function(results) {
	var toReturn = new Array();
	for(var i = 0; i < results.length; i++) {
		var next = results[i];
		if(next.tbody && next.tbody.tr) {
			var data = next.tbody.tr;
			for(var n = 0; n < data.length; n++) {
				var td = data[n].td;
				var row = new Array();
				for(var d = 0; d < td.length; d++) {
					var value = td[d];
					row.push(value);
				}
				toReturn.push(row);
			}
		}
	}
	injectWidgetInfo('.procedure-text', toReturn[0]);
	injectTableRows('#procedure-tb', toReturn, "#procedure-table");
};

/*********************************************************************
 * Parse patient encounter information and inject it into the widget
 ********************************************************************/
var parseAllergyResults = function(results) {
	var toReturn = new Array();
	for(var i = 0; i < results.length; i++) {
		var next = results[i];
		var temp = new Array();
		temp[0] = next[0];
		temp[1] = next[3];
		toReturn.push(temp);
	}
	injectWidgetInfoAllergies('#allergies-container', toReturn);
	injectAllergyTable('#allergy-tb', results, "#allgery-table");
};
/*********************************************************************
 * Parse patient encounter information and inject it into the widget
 ********************************************************************/
var parseEncounters = function(results) {
	var toReturn = new Array();
	var chartData = new Array();
	for(var i = 0; i < results.length; i++) {
		var next = results[i];
		if(next.tbody && next.tbody.tr) {
			var data = next.tbody.tr;
			for(var n = 0; n < data.length; n++) {
				var td = data[n].td;
				var row = new Array();
				for(var d = 0; d < td.length; d++) {
					var value = td[d];
					row.push(value);
				}
				var bpString = row[8].content[0];
				var systolicBP = bpString.substring(0, bpString.indexOf("/"));
				var diastolicBP = bpString.substring(bpString.indexOf("/")+1, bpString.length);
				var date = row[0].content[1];
				var year = date.substring(0,4);
				var month = date.substring(4,6);
				var day = date.substring(6,8);
				date = year + "-" + month + "-" + day;
				chartData.push({ date: date, systolic: systolicBP, diastolic: diastolicBP});
				toReturn.push(row);
			}
		}
	}
	
	injectWidgetInfo('.enounter-text', toReturn[0]);
	injectTableRows('#encounter-tb', toReturn, "#encounter-table");
	
	var monthNames = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
	
	var chart = $("#bpchart");
	chart.empty();
	chart = new Morris.Area({
		element : 'bpchart',
		lineColors: ['red', 'blue'],  
		data : chartData,
		xkey : 'date',
        pointSize: 3,
		ykeys : [ 'systolic', 'diastolic' ],
		labels : [ 'Systolic', 'Diastolic' ],
		xLabelFormat: function (x){
            var date = new Date(x);
            return (date.getDate() + '-' + monthNames[date.getMonth()]);
        }
	});
};
/*******************************************************************************
 * Parse patient m information and inject it into the widget
 ******************************************************************************/
var parseMedication = function(results, entries) {
	var drugs = new Array();
	var toReturn = new Array();
	var activeMedications = new Array();
	for(var i = 0; i < results.length; i++) {
		var next = results[i];
		if(next.tbody && next.tbody.tr) {
			var data = next.tbody.tr;
			for(var n = 0; n < data.length; n++) {
				var td = data[n].td;
				var row = new Array();
				for(var d = 0; d < td.length; d++) {
					var value = td[d];
					if(d == 1) {
						drugs.push(value);
					}
					row.push(value);
				}
				var statusType = entries[toReturn.length].substanceAdministration.statusCode.code;
				if (statusType == 'active'){
					activeMedications.push(row[1]);
				}
				toReturn.push(row);
			}
		}
	}
	injectWidgetInfoCollective('.medication-text', activeMedications);
	injectTableRows('#medication-tb', toReturn, "#medication-table");
};

/*********************************************************************
 * Parse patient lab results information and inject it into the widget
 ********************************************************************/
var parseLabResults = function(results) {
	var toReturn = new Array();
	for(var i = 0; i < results.length; i++) {
		var next = results[i];
		if(next.tbody && next.tbody.tr) {
			var data = next.tbody.tr;
			for(var n = 0; n < data.length; n++) {
				var td = data[n].td;
				var row = new Array();
				for(var d = 0; d < td.length; d++) {
					var value = td[d];
					row.push(value);
				}
				toReturn.push(row);
			}
		}
	}
	//injectWidgetInfo('.medication-text', toReturn[0]);
	injectTableRows('#results-tb', toReturn, "#results-table");
};

/*********************************************************************
 * Parse patient social history information and inject it into the widget
 ********************************************************************/
var parseSocialHistory = function(results) {
	var toReturn = new Array();
	for(var i = 0; i < results.length; i++) {
		var next = results[i];
		if(next.tbody && next.tbody.tr) {
			var data = next.tbody.tr;
			for(var n = 0; n < data.length; n++) {
				var td = data[n].td;
				var row = new Array();
				for(var d = 0; d < td.length; d++) {
					var value = td[d];
					if (value.content.length == 2) {
						//get the second value
						row.push(value.content[1]);
					} else {
						row.push(value);
					}
				}
				toReturn.push(row);
			}
		}
	}
	injectTableRows('#social-history-tb', toReturn, "#social-history-table");
};

/*********************************************************************
 * Parse patient problems information and inject it into the widget
 ********************************************************************/
var parseProblems = function(results) {
	var toReturn = new Array();
	for(var i = 0; i < results.length; i++) {
		var next = results[i];
		if(next.item) {
			var data = next.item;
			for(var n = 0; n < data.length; n++) {
				var problemTd = {content : new Array()};
				problemTd.content.push(data[n].content.value);
				var row = new Array();
				row.push(problemTd);
				toReturn.push(row);
			}
		}
	}
	injectWidgetInfoProblem('.problem-text', toReturn);
	injectTableRows('#problems-tb', toReturn, "#problems-table");
};



/*********************************************************************
 * Pull the username from local storage and welcome them to this page
 ********************************************************************/
var injectUsername = function() {
	var username =  localStorage.getItem("username");
	var text = "Patient";
	if(localStorage.getItem("userrole") == "pcp") {
		text = "Primary Care Physician";
	}else if(localStorage.getItem("userrole") == "s1") {
		text = "Cardiologist";
	}
	var html = "<p class='voice-brand username-text'> Welcome " + username  + "</p>";
	html = html + "<p class='voice-brand role-text'>" + text  + "</p>";
	html = html + "<button type='button' class='logout-btn' onClick='logout()'>Logout</button>" + "</p>";
	 $('#username-div')[0].innerHTML = html;
	
};

/*********************************************************************
 * Inject the most recent/relvent infromation directly into the
 * widget itself for the user to see.
 ********************************************************************/
var injectWidgetInfo = function(widget, info) {
	var cells = $(widget);
	if(info && cells.length == info.length) {
		for(var i = 0; i < cells.length; i++) {
			var value = info[i].content;
			if(value && value.length > 1) {
				var date = value[1];
				var year = date.substring(0,4);
				var month = date.substring(4,6);
				var day = date.substring(6,8);
				date = day + "/" + month + "/" + year;
				cells[i].innerHTML = date;
			}else {
				cells[i].innerHTML = value[0];
			}
		}
	}
}
/*********************************************************************
 * Inject the most recent/relvent infromation directly into the
 * widget itself for the user to see.
 ********************************************************************/
var injectWidgetInfoCollective = function(widget, info) {
	var cells = $(widget)[0];
	var html = "";
	if(info && info.length) {
		for(var i = 0; i < info.length; i++) {
			var value = info[i].content;
			html = html + '<p class="inject-txt">' + value[0] + '</p>';
		}
		cells.innerHTML = html;
	}else {
		cells.innerHTML = "No Known Allergies";
	}
};
/*********************************************************************
 * Inject the most recent/relvent infromation directly into the
 * widget itself for the user to see.
 ********************************************************************/
var injectWidgetInfoProblem = function(widget, info) {
	var cells = $(widget)[0];
	var html = "";
	if(info && info.length) {
		for(var i = 0; i < info.length; i++) {
			var value = info[i][0].content[0];
			html = html + '<p class="inject-txt">' + value + '</p>';
		}
		cells.innerHTML = html;
	}else {
		cells.innerHTML = "No Known Problems";
	}
};
/*********************************************************************
 * Inject the most recent/relvent infromation directly into the
 * widget itself for the user to see.
 ********************************************************************/
var injectWidgetInfoAllergies = function(widget, info) {
	var cells = $(widget)[0];
	var html = "";
	if(info && info.length) {
		for(var i = 0; i < info.length; i++) {
			var value = info[i];
			var isActive = value[1] == "Active" ? "active-allergy-text" : "inactive-allergy-text";
			html = html + '<p class="allergy-text-left ' + isActive + '">' + value[0] + '</p>';
			html = html + '<p class="allergy-text-right ' + isActive + '">' + value[1] + '</p>';
		}
		cells.innerHTML = html;
	}else {
		cells.innerHTML = "none";
	}
}
/*********************************************************************
 * If the call to get XML data is successful, inject the data
 * into the page by buliding HTML from the content
 ********************************************************************/
var injectTableRows = function(table_body, rows, table) {
	var table = $(table).dataTable();
	var cleanRows = new Array();
	
	for(var i = 0; i < rows.length; i++) {
		var row = rows[i];
		var nextRow = new Array();
		for(var q = 0; q < row.length; q++) {
			var value = row[q].content || row[q];
			//special case for dates
			if(value && value.length == 2) {
				var date = value[1];
				var year = date.substring(0,4);
				var month = date.substring(4,6);
				var day = date.substring(6,8);
				date = day + "/" + month + "/" + year;
				nextRow.push(date);
			}
			//everything else
			else {
				if(value.length > 1) {
					nextRow.push(value);
				}else {
					nextRow.push(value[0]);
				}
			}
		}
		cleanRows.push(nextRow);
	}
	
	table.fnClearTable();
	for(var i = 0; i < cleanRows.length; i++) {
		var cleanRow = cleanRows[i];
		table.fnAddData( cleanRow );
		table.fnDraw();
	}
};
/*************************************************************
 * Old school way of injecting data into a DataTable
 * used only for the allergy information
 *************************************************************/
var injectAllergyTable = function(table_body, rows, table) {
	var html = "";
	for(var i = 0; i < rows.length; i++) {
		var row = rows[i];
		html = html + "<tr>";
		for(var q = 0; q < row.length; q++) {
			var value = row[q].content || row[q];
			html = html + "<td>";
			//special case for dates
			if(value && value.length == 2) {
				var date = value[1];
				var year = date.substring(0,4);
				var month = date.substring(4,6);
				var day = date.substring(6,8);
				date = day + "/" + month + "/" + year;
				html = html + date;
			}
			//everything else
			else {
				if(value.length > 1) {
					html = html + value;
				}else {
					html = html + value[0];
				}
			}
			html = html + "</td>";
		}
		html = html + "</tr>";
	}
	$(table_body)[0].innerHTML = html;
	var table = $(table).dataTable();
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
