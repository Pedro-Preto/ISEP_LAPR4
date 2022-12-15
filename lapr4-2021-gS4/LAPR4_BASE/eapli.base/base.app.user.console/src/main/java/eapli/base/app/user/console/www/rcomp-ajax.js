

function refreshTasks() {
    var request = new XMLHttpRequest();
    var vBoard=document.getElementById("requests");

    request.onload = function() {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "black";
        setTimeout(refreshTasks, 2000);
    };

    request.ontimeout = function() {
        vBoard.innerHTML = "Please log in first!";
        vBoard.style.color = "green";
        setTimeout(refreshTasks, 100);
    };

    request.onerror = function() {
        vBoard.innerHTML = "Please wait, connecting to server ...";
        vBoard.style.color = "blue";
        setTimeout(refreshTasks, 5000);
    };

    request.open("GET", "/requests", true);
    request.timeout = 5000;
    request.send();
}


