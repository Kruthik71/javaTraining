<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password Page</title>
<style>
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

h3 {
    color: red;
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
	<h3 style="color:red">${message}</h3>
	<form action="changePassword" method="post">
		<table>
			<tr>
				<td>Old Password :</td>
				<td><input type="password" name="oldPassword"></td>
			</tr>
			<tr>
				<td>New Password :</td>
				<td><input type="password" name="newPassword"></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="confirmPassword"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="Change Password"></td>
			</tr>
		</table>
	</form>
</body>
</html>