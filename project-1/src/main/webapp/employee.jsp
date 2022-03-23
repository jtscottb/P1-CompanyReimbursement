<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EMPLOYEE</title>
		<link rel="stylesheet" href="./CSS/main.css">
    	<script src="./JS/employee.js"></script>
	</head>
	
	<body>
		<div id="block">
		
			<h2 id="message">${message}</h2>
			<div id="choice">
				<a href="./SubmitReimbursement"><button>Submit a Reimbursement Request</button></a>
				
				<a href="./MyPendingRequests"><button>View Pending Requests</button></a>
				<a href="./MyResolvedRequests"><button>View Resolved Requests</button></a>
				<a href="./MyProfile"><button>My Profile</button></a>
				<a href="./UpdateInfo"><button>Update Information</button></a>
				<button onclick=Logout()>Logout</button>
			</div>
			
		</div>
		
		<br> <br>
		<div id="selection">${content}</div>
	</body>
</html>