<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${role}</title>
		<link rel="stylesheet" href="./CSS/main.css">
    	<script src="./JS/${js}"></script>
	</head>
	
	<body onload=Load()>
	
		<div id="block">
			<h2 id="message">${message}</h2>
			<div id="choice"></div>
		</div>
		<br> <br>
		<div id="selection">${content}</div>
		
	</body>
	
</html>