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

        + "<form action=./PendingRequests method=get>"
        + "     <button onclick=AllPendingRequests()>View Pending Requests</button>"
        + "</form>"
        + "<form action=./ResolvedRequests method=get>"
        + "     <button onclick=ResolvedRequests()>View All Resolved Requests</button>"
        + "</form>"
        + "<form action=./AllEmployees method=get>"
        + "     <button onclick=AllEmployees()>View All Employees</button>"
        + "</form>"
        + "<button onclick=EmployeeRequests()>View Requests From An Employee</button>"
        + "<button onclick=Logout()>Logout</button>";
}