var BrowserDetect = {
	init: function () {
		this.browser = this.searchString(this.dataBrowser) || "An unknown browser";
		this.version = this.searchVersion(navigator.userAgent)
			|| this.searchVersion(navigator.appVersion)
			|| "an unknown version";
		this.OS = this.searchString(this.dataOS) || "an unknown OS";
	},
	searchString: function (data) {
		for (var i=0;i<data.length;i++)	{
			var dataString = data[i].string;
			var dataProp = data[i].prop;
			this.versionSearchString = data[i].versionSearch || data[i].identity;
			if (dataString) {
				if (dataString.indexOf(data[i].subString) != -1)
					return data[i].identity;
			}
			else if (dataProp)
				return data[i].identity;
		}
	},
	searchVersion: function (dataString) {
		var index = dataString.indexOf(this.versionSearchString);
		if (index == -1) return;
		return parseFloat(dataString.substring(index+this.versionSearchString.length+1));
	},		
	checkResults: function () {
		var redirect = false;
		var displayAlert = false;
		if(this.browser == "Firefox") {
			redirect = this.version < 23.0 ? true : false;
		}
		else if(this.browser == "Safari") {
			//redirect = this.version < 6.0 ? true : false; 
			// allowing safari 5 in Dev for testing on our only iPad
			redirect = this.version < 5.0 ? true : false; 
			// end tjg
		}
		else if(this.browser == "Explorer") {
			redirect = this.version < 9.0 ? true : false;
		}
		else if(this.browser == "Chrome") {
			redirect = this.version < 25.0 ? true : false;
		}
		else if(this.browser == "an unknown OS") {
			
//			//We don't know what the user is running, so warn them our site
//			//may not be compatible with their browser
//			displayAlert = true;
			redirect = false;
		}
		else {
			
//			//We don't know what the user is running, so warn them our site
//			//may not be compatible with their browser
//			displayAlert = true;
			redirect = false;
		}
		
		if(redirect) {
			window.location="redirect.html";
		}else if(displayAlert)  {
						
			//The Recent Links Widget will take this argument as a 
			//sign to display the warning message on this scripts behalf
			window.location = window.document.URL + "?alert=true";

		}
	},
	dataBrowser: [
		{
			string: navigator.userAgent,
			subString: "Chrome",
			identity: "Chrome"
		},
		{ 	string: navigator.userAgent,
			subString: "OmniWeb",
			versionSearch: "OmniWeb/",
			identity: "OmniWeb"
		},
		{
			string: navigator.vendor,
			subString: "Apple",
			identity: "Safari",
			versionSearch: "Version"
		},
		{
			prop: window.opera,
			identity: "Opera",
			versionSearch: "Version"
		},
		{
			string: navigator.vendor,
			subString: "iCab",
			identity: "iCab"
		},
		{
			string: navigator.vendor,
			subString: "KDE",
			identity: "Konqueror"
		},
		{
			string: navigator.userAgent,
			subString: "Firefox",
			identity: "Firefox"
		},
		{
			string: navigator.vendor,
			subString: "Camino",
			identity: "Camino"
		},
		{		// for newer Netscapes (6+)
			string: navigator.userAgent,
			subString: "Netscape",
			identity: "Netscape"
		},
		{
			string: navigator.userAgent,
			subString: "MSIE",
			identity: "Explorer",
			versionSearch: "MSIE"
		},
		{
			string: navigator.userAgent,
			subString: "Gecko",
			identity: "Mozilla",
			versionSearch: "rv"
		},
		{ 		// for older Netscapes (4-)
			string: navigator.userAgent,
			subString: "Mozilla",
			identity: "Netscape",
			versionSearch: "Mozilla"
		}
	],
	dataOS : [
		{
			string: navigator.platform,
			subString: "Win",
			identity: "Windows"
		},
		{
			string: navigator.platform,
			subString: "Mac",
			identity: "Mac"
		},
		{
			   string: navigator.userAgent,
			   subString: "iPhone",
			   identity: "iPhone/iPod"
	    },
		{
			string: navigator.platform,
			subString: "Linux",
			identity: "Linux"
		}
	]

};

//if(window.document.URL.indexOf('?') <= 0) {
	BrowserDetect.init();
	BrowserDetect.checkResults();
//}