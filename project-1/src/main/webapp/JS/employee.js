function Logout() {
    window.location.href = "index.html";
}

function SubmitReimbursement() {
    "<form action=/SubmitReimbursement method=post>"
    + "<label for=uname>Username</label> <br>"
    + "<input type=text id=uname name=uname> <br> <br>"

    + "<label for=pword>Password</label> <br>"
    + "<input type=text id=pword name=pword> <br> <br>"

    + "<input type=submit value=Enter>"
    + "</form>";
}

function PendingRequests() {

}

function ResolvedRequests() {

}

function Profile() {

}

function UpdateInfo() {

}

window.onload = function() {
    var selectionDiv = "<div id='start'>"
        + "<button onclick=SubmitReimbursement()>Submit a Reimbursement Request</button>"
        + "<br> <br>"

        + "<button onclick=PendingRequests()>View Pending Requests</button>"
        + "<br> <br>"
        + "<button onclick=ResolvedRequests()>View Resolved Requests</button>"
        + "<br> <br>"
        + "<button onclick=Profile()>My Profile</button>"
        + "<br> <br>"
        + "<button onclick=UpdateInfo()>Update Information</button>"
        + "<br> <br>"
            
        + "<button onclick=Logout()>Logout</button>"
        + "</div>";

    var beginBlock = "<div class='block'>";
    var endBlock = "</div>"

    document.body.innerHTML += beginBlock + selectionDiv + endBlock;
}