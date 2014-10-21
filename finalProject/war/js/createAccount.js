var createUser = function() {
	var username = $('#usernameInput')[0];
	var password = $('#passInput')[0];
	var passwordRE = $('#passInputRE')[0];
	var role = $('#sselect')[0].value;
	
	if(passwordRE.value == password.value) {
		DBServiceController.createUser(username.value, password.value, role, {
			  callback:function(returnVal) {
				  
				  if(returnVal > 0) {
					  localStorage.setItem("userId", returnVal);
					  localStorage.setItem("username", username.value);
					  window.location = '/home.html'
	
				  }else {
					  displayAlert("Failed to Create Account - Please Try Again", "alert-danger", "Yikes...That Didn't Work");
				  }
				  
			  }
			});
	}else {
		displayAlert("Looks Like Your Passwords Don't Match", "alert-danger", "Oops...");
	}
}
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