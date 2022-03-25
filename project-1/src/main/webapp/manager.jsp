<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MANAGER</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<!-- <link rel="stylesheet" href="./CSS/main.css"> -->
		<script src="./JS/employee.js"></script>
    	<script src="./JS/manager.js"></script>
	</head>
	
	<body>
		<div id="block">
		
			<h2 id="message">${message}</h2>
			
			<nav class="navbar navbar-expand-lg navbar-info bg-info">
				<div class="container-fluid">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<!-- EMPLOYEE SERVICES -->
							<li class="nav-item">
								<a class="nav-link" href="./SubmitReimbursement">Submit a Reimbursement Request</a>
							</li>
					
							<li class="nav-item">
								<a class="nav-link" href="./MyPendingRequests">View Pending Requests</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="./MyResolvedRequests">View Resolved Requests</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="./MyProfile">My Profile</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="./UpdateInfo">Update Information</a>
							</li>
							<!-- MANAGER SERVICES -->
							<li class="nav-item">
								<a class="nav-link" href="./ApproveDeny">Approve/Deny a Reimbursement Request</a>
							</li>
							<li class="nav-item">
				            	<a class="nav-link" href="./AllPendingRequests">View All Pending Requests</a>
				            </li>
				            
							<li class="nav-item">
				            	<a class="nav-link" href="./AllResolvedRequests">View All Resolved Requests</a>
				            </li>
							<li class="nav-item">
				            	<a class="nav-link" href="./AllEmployees">View All Employees</a>
				            </li>
							<li class="nav-item">
				            	<a class="nav-link" href="./EmployeeRequests">View Requests From An Employee</a>
				            </li>
							<li class="nav-item">
								<a class="nav-link"><button onclick=Logout()>Logout</button></a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		
		<br> <br>
		<div id="selection">${content}</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>