
// IMPORTANT: notice the next request is scheduled only after the
//            previous request is fully processed either successfully
//	      or not.

function refreshRequests() {
	var request = new XMLHttpRequest();
        var vBoard=document.getElementById("requests");
        
        request.onload = function() {
            vBoard.innerHTML = this.responseText;
            vBoard.style.color = "black";
            setTimeout(refreshRequests, 2000);
            };
            
        request.ontimeout = function() {
            vBoard.innerHTML = "Please log in first!";
            vBoard.style.color = "green";
            setTimeout(refreshRequests, 100);
        };
        
        request.onerror = function() { 
            vBoard.innerHTML = "Please wait, connecting to server ...";
            vBoard.style.color = "blue";
            setTimeout(refreshRequests, 5000);
        };
        
  	request.open("GET", "/requests", true);
	request.timeout = 5000;
  	request.send();
	}

	/*
    function addRequest(option) {
	    var request = new XMLHttpRequest();
  	    request.open("PUT", "/requests/" + option , true);
  	    request.send();
        var vBoard=document.getElementById("requests");
        vBoard.innerHTML = vBoard.innerHTML + "<p>Adding your request ... Please wait.";

	}
	*/
	

