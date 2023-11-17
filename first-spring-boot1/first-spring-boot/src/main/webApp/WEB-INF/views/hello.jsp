<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center">
	<h1 style="color:blue">Hello KRUTHIK B . . . !</h1>
	<h2><%= request.getAttribute("name") %></h2>
	<a href="changePassword">Change Password</a>
</body>
</html>