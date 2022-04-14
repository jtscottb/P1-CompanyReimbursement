<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link rel="stylesheet" href="./CSS/main.css">
    	<script src="./JS/main.js"></script>
	</head>
	
	<body onload=${load}>
		<div id="block">
			<h3 id="message">${message}</h3>
			<div id="choice" class="bg-dark text-info pt-5 pb-5">
				<a href="./Login"><button>Login</button></a>
				<br> <br>
				<a href="./Register"><button>Register</button></a>
			</div>
		</div>
		<div id="selection" class="bg-dark text-info pt-5 pb-5">${content}</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>