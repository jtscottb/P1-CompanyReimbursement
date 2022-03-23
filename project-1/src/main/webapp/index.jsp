<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome</title>
		<link rel="stylesheet" href="./CSS/main.css">
    	<script src="./JS/main.js"></script>
	</head>
	
	<body onload=${load}>
		<div id="block">
			<h3 id="message">${message}</h3>
			<div id="choice">
				<button onclick=Login()>Login</button>
				<br> <br>
				<button onclick=Register()>Register</button>
			</div>
		</div>
		<div id="selection"></div>
	</body>
</html>