var validateCredentials = function() {
	var username = $('#usernameInput')[0];
	var password = $('#passInput')[0];
	showHideLoadingWheel(true, "Authenticating...");

	DBServiceController.checkLogin(username.value, password.value, {
		  callback:function(returnVal) {
			showHideLoadingWheel(false);

			  if(returnVal > 0) {
				  localStorage.setItem("userId", returnVal);
				  localStorage.setItem("username", username.value);
				  window.location = '/home.html';

			  }else {
				  displayAlert("Incorrect Username or Password", "alert-danger", "Login Failed");
			  }
			  
		  }
		});
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