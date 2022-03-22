function Logout() {
    window.location.href = "index.html";
}

function SubmitReimbursement() {
    document.getElementById('selection').innerHTML =
    "<br><br>"
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
    + "</form>";
}

function PendingRequests() {

}

function ResolvedRequests() {

}

function Profile() {

}

function UpdateInfo() {
    document.getElementById("selection").innerHTML =
    "<br><br>"
    + "<form action=./Update method=post>"
    + "<label for=uname>Username</label> <br>"
    + "<input type=text id=uname name=uname placeholder=user> <br> <br>"

    + "<label for=pword>Password</label> <br>"
    + "<input type=password id=pword name=pword placeholder=password> <br> <br>"

    + "<label for=fname>First Name</label> <br>"
    + "<input type=text id=fname name=fname placeholder='first name'> <br> <br>"

    + "<label for=lname>Last Name</label> <br>"
    + "<input type=text id=lname name=lname placeholder='last name'> <br> <br>"

    + "<label for=email>Email</label> <br>"
    + "<input type=email id=email name=email placeholder=user@email.com> <br> <br>"

    + "<input type=submit value=Update>"
    + "</form>";
}

function Load() {
    document.getElementById('choice').innerHTML =
        "<button onclick=SubmitReimbursement()>Submit a Reimbursement Request</button>"

        + "<form action=./MyPendingRequests method=get>"
        + " <button onclick=PendingRequests()>View Pending Requests</button>"
        + "</form>"
        + "<form action=./MyResolvedRequests method=get>"
        + " <button onclick=ResolvedRequests()>View Resolved Requests</button>"
        + "</form>"
        + "<form action=./MyProfile method=get>"
        + " <button onclick=Profile()>My Profile</button>"
        + "</form>"
        + "<button onclick=UpdateInfo()>Update Information</button>"
        + "<br>"
        + "<button onclick=Logout()>Logout</button>";
}
