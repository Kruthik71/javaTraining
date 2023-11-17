<%@page import="com.valtech.training.firstspringboot.entities.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.valtech.training.firstspringboot.models.OrderModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% OrderModel order=(OrderModel)request.getAttribute("order"); %>
	<h3>Create a new order</h3>
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