function Logout() {
    window.location.href = "index.jsp";
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

function Load() {
    document.getElementById('choice').innerHTML =
        + "<button onclick=ApproveDeny()>Approve/Deny a Reimbursement Request</button>"

        + "<button onclick=AllPendingRequests()>View Pending Requests</button>"
        + "<button onclick=ResolvedRequests()>View All Resolved Requests</button>"
        + "<button onclick=AllEmployees()>View All Employees</button>"
        + "<button onclick=EmployeeRequests()>View Requests From An Employee</button>"
        + "<button onclick=Logout()>Logout</button>";
}