<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

form {
    max-width: 300px;
    margin: 20px auto;
    background: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
    width: 100%;
}

table, td {
    border-collapse: collapse;
}

td {
    padding: 10px;
    text-align: left;
}

input[type="text"],
input[type="password"] {
    width: calc(100% - 12px);
    padding: 8px;
    box-sizing: border-box;
    margin-top: 4px;
    margin-bottom: 10px;
}

input[type="submit"] {
    background-color: #4caf50;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

</style>
</head>
<body>
<form action="login" method="post">
	<table>
		<tr>
			<td>UserName</td>
			<td><input name="username" type="text"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input name="password" type="password"/></td>
		</tr>
		<tr>
			<td colspan="2"><input name="submit" type="submit" value="Login"/></td>
		</tr>
	</table>
</form>
</body>
</html>