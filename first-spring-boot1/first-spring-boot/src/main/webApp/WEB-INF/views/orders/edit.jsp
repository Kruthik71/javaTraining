<%@page import="com.valtech.training.firstspringboot.entities.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.valtech.training.firstspringboot.models.OrderModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Orders Page</title>
<style>
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

h3 {
    color: #333;
}

form {
    max-width: 400px;
    margin: 20px auto;
    background: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
    width: 100%;
}

table, th, td {
    border-collapse: collapse;
}

th, td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: left;
}

input[type="text"] {
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
    margin-right: 5px;
}

input[type="submit"]:last-child {
    margin-right: 0;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

</style>
</head>
<body>
<% OrderModel order=(OrderModel)request.getAttribute("order"); %>
	<form method="post" action="save?id=<%= order.getId() %>">
	<table>
		<tr>
			<th>Id</th>
			<td><input type="text" disabled="disabled" name="id" value="<%= order.getId()%>"></td>
		</tr>
		<tr>
			<th>Item</th>
			<td><input type="text" name="item" value="<%= order.getItem() %>"></td>
		</tr>
		<tr>
			<th>ItemCount</th>
			<td><input type="text" name="itemCount" value="<%= order.getItemCount()%>"></td>
		</tr>
		<tr>
			<th>Description</th>
			<td><input type="text" name="description" value="<%= order.getDescription()%>"></td>
		</tr>
		<tr>
			<th>OrderDate</th>
			<td><input type="text" name="orderDate" value="<%= order.getOrderDate()%>"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="submit" value="Create"/>	
				<input type="submit" name="submit" value="Cancel"/>			
			</td>
		</tr>	
	</table>
	</form>
</body>
</html>