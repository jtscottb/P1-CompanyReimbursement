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
				<a href="./Login"><button>Login</button></a>
				<br> <br>
				<a href="./Register"><button>Register</button></a>
			</div>
		</div>
		<br> <br>
		<div id="selection">${content}</div>
	</body>
</html>