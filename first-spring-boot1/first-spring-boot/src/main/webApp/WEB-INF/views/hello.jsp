<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style>
	/* styles.css */

body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
    text-align: center;
}

h1 {
    color: blue;
}

h2 {
    color: #333;
}

a {
    color: #337ab7;
    text-decoration: none;
}

a:hover {
    color: #23527c;
    text-decoration: underline;
}

/* Add more styles as needed */
	
</style>
</head>
<body style="text-align:center">
	<h1 style="color:blue">Hello KRUTHIK B . . . !</h1>
	<h2><%= request.getAttribute("name") %></h2>
	<a href="changePassword">Change Password</a>
</body>
</html>