function Logout() {
    window.location.href = "index.html";
}

function SubmitReimbursement() {
    document.getElementById('block').innerHTML +=
    "<br><br>"
    +"<div id=selection>"
    + "<form action=./SubmitReimbursement method=post>"
    + "<label for=amount>Amount</label> <br>"
    + "<input type=text id=amount name=amount> <br> <br>"

    + "<label for=description>Description</label> <br>"
    + "<textarea id=description name=description></textarea> <br> <br>"

    + "<label for=type>Type</label> <br>"
    + "<select id=type name=type>"
    + " <option value=1>Food</option>"
    + " <option value=2>Lodging</option>"
    + " <option value=3>Travel</option>"
    + " <option value=4>Other</option>"
    + "</select> <br> <br>"

    + "<input type=submit value=Submit>"
    + "</form>"
    + "</div>";
}

function PendingRequests() {

}

function ResolvedRequests() {

}

function Profile() {

}

function UpdateInfo() {

}

function Load() {
    document.getElementById('choice').innerHTML =
        + "<button onclick=SubmitReimbursement()>Submit a Reimbursement Request</button>"

        + "<button onclick=PendingRequests()>View Pending Requests</button>"
        + "<button onclick=ResolvedRequests()>View Resolved Requests</button>"
        + "<button onclick=Profile()>My Profile</button>"
        + "<button onclick=UpdateInfo()>Update Information</button>"
            
        + "<button onclick=Logout()>Logout</button>";
}
