<%@page import="com.valtech.training.firstspringboot.models.OrderModel"%>
<%@page import="java.util.List"%>
<%@page import="com.valtech.training.firstspringboot.entities.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders Display Page</title>
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

table {
    width: 100%;
    margin-top: 20px;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid #ddd;
}

th, td {
    padding: 10px;
    text-align: left;
}

th {
    background-color: #4caf50;
    color: white;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #f1f1f1;
}

a {
    color: #337ab7;
    text-decoration: none;
    margin-right: 10px;
}

a:hover {
    color: #23527c;
    text-decoration: underline;
}

tfoot {
    background-color: #ddd;
}

tfoot input[type="submit"] {
    background-color: #337ab7;
    color: white;
    padding: 8px 12px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

tfoot input[type="submit"]:hover {
    background-color: #23527c;
}

</style>
</head>
<body>
	<h3>List of orders</h3>
	<% List<OrderModel> orders=(List<OrderModel>) request.getAttribute("orders"); %>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Item</th>
			<th>ItemCount</th>
			<th>Description</th>
			<th>OrderDate</th>
			<th>Actions</th>
		</tr>
		<% for (OrderModel o : orders) { request.setAttribute("o",o); %>
			<tr>
				<td>${o.id}</td>
				<td>${o.item}</td>
				<td>${o.itemCount}</td>
				<td>${o.description}</td>
				<td>${o.orderDate}</td>
				<td>
					<a href="delete?id=${o.id}">Delete</a>
					<a href="edit?id=${o.id}">Edit</a>
				</td>
			</tr>
		<% } %>
		<tfoot>
			<tr>
				<td colspan="6" align="right">
					<form action="new" method="get">
						<input type="submit" name="submit" value="New Order"/>
					</form>
				</td>
			</tr>
		</tfoot>
		
	</table>
	
</body>
</html>