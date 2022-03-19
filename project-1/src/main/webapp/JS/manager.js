function Logout() {
    window.location.href = "index.html";
}

function ApproveDeny() {

}

function AllPendingRequests() {

}

function ResolvedRequests() {

}

function AllEmployees() {

}

function EmployeeRequests() {

}

window.onload = function() {
    var selectionDiv = "<div id='start'>"
        + "<button onclick=ApproveDeny()>Approve/Deny a Reimbursement Request</button>"
        + "<br> <br>"

        + "<button onclick=AllPendingRequests()>View Pending Requests</button>"
        + "<br> <br>"
        + "<button onclick=ResolvedRequests()>View All Resolved Requests</button>"
        + "<br> <br>"
        + "<button onclick=AllEmployees()>View All Employees</button>"
        + "<br> <br>"
        + "<button onclick=EmployeeRequests()>View Requests From An Employee</button>"
        + "<br> <br>"
        + "<button onclick=Logout()>Logout</button>"
        + "</div>";

    var beginBlock = "<div class='block'>";
    var endBlock = "</div>"

    document.body.innerHTML += beginBlock + selectionDiv + endBlock;
}