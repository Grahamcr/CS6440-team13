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
			 // injectSomeInfo(value);
			  displayAlert("Successful Data Pull!! Here is some of the information pull, parsed and returned :)", "alert-success", "Victory!")
		  }
		});
});
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
var injectSomeInfo = function(info) {
	var authorAddr = info.author.assignedAuthor.addr;
	var html = "<h2 class='data-header voice-brand'>Assigned Author Information:</h2>";
	html = html + "<p class='data-title single-line-title voice-brand'>Author Name:</p>";
	html = html + "<p class='data-text single-line-data-text voice-brand'>" + info.author.assignedAuthor.assignedPerson.name.family + ", " + info.author.assignedAuthor.assignedPerson.name.given + ", " + info.author.assignedAuthor.assignedPerson.name.prefix + "</p>";
	
	html = html + "<p class='data-title multi-line-title voice-brand'>Address:</p>";
	html = html + "<p class='data-text multi-line-data-text voice-brand'>" + authorAddr.streetAddressLine + "</p>";
	html = html + "<p class='data-text multi-line-data-text voice-brand'>" + authorAddr.city + ", " + authorAddr.state + ", " + authorAddr.country + "</p>";
	
	html = html + "<p class='data-title multi-line-title voice-brand'>Id:</p>";
	html = html + "<p class='data-text multi-line-data-text voice-brand'>Extension: " + info.author.assignedAuthor.id.extension + "</p>";
	html = html + "<p class='data-text multi-line-data-text voice-brand'>Root: " + info.author.assignedAuthor.id.root + "</p>";
	html = html + "<p class='data-text multi-line-data-text voice-brand'>Value: " + info.author.assignedAuthor.id.value + "</p>";
	$('.author-info-block-wrapper')[0].innerHTML = html;
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