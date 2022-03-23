<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MANAGER</title>
		<link rel="stylesheet" href="./CSS/main.css">
		<script src="./JS/employee.js"></script>
    	<script src="./JS/manager.js"></script>
	</head>
	
	<body>
		<div id="block">
		
			<h2 id="message">${message}</h2>
			<div id="choice">
				<h4>Employee Services</h4>
				<a href="./SubmitReimbursement"><button>Submit a Reimbursement Request</button></a>
				
				<a href="./MyPendingRequests"><button>View Pending Requests</button></a>
				<a href="./MyResolvedRequests"><button>View Resolved Requests</button></a>
				<a href="./MyProfile"><button>My Profile</button></a>
				<a href="./UpdateInfo"><button>Update Information</button></a>
				
				<br>
				<h4>Manager Services</h4>
				<a href="./ApproveDeny"><button>Approve/Deny a Reimbursement Request</button></a>
            	<a href="./AllPendingRequests"><button>View All Pending Requests</button></a>

            	<a href="./AllResolvedRequests"><button>View All Resolved Requests</button></a>
            	<a href="./AllEmployees"><button>View All Employees</button></a>
            	<a href="./EmployeeRequests"><button>View Requests From An Employee</button></a>
				<button onclick=Logout()>Logout</button>
			</div>
			
		</div>
		
		<br> <br>
		<div id="selection">${content}</div>
	</body>
</html>