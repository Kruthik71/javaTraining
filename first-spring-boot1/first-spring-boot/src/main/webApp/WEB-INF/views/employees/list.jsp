<%@page
	import="com.valtech.training.firstspringboot.models.DepartmentModels"%>
<%@page
	import="com.valtech.training.firstspringboot.models.EmployeeModels"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Page</title>
<style>
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

h1 {
    color: #333;
}

table {
    width: 100%;
    margin: 20px 0;
    border-collapse: collapse;
}

th, td {
    padding: 12px;
    text-align: left;
    border: 1px solid #ddd;
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

a {
    color: #337ab7;
    text-decoration: none;
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
	<h1>List of Employees</h1>
	<%
	List<EmployeeModels> employees = (List<EmployeeModels>) request.getAttribute("employees");
	%>
	<%
	/* List<DepartmentModels> departments = (List<DepartmentModels>) request.getAttribute("departments"); */
	DepartmentModels departmentModels = (DepartmentModels) request.getAttribute("departments");
	request.setAttribute("current", departmentModels.getId());
	%>
	<table>
		<tr>
			<th>Department_ID</th>
			<th>Department_Name</th>
			<th>Department_Location</th>
		</tr>
		<%-- <%
		for (DepartmentModels department : departments) {
			request.setAttribute("department", department);
		%> --%>
		<%
		request.setAttribute("department", departmentModels);
		%>
		<tr>
			<td>${department.id}</td>
			<td>${department.dname}</td>
			<td>${department.dlocation}</td>
		</tr>

		<%-- <%
		}
		%> --%>
		<tr>
			<td colspan="3">
				<form action="list" method="post">
					<input type="submit" name="submit" value="First" /> 
					<input type="submit" name="submit" value="Previous" /> 
					<input type="submit" name="submit" value="Next" /> 
					<input type="submit" name="submit" value="Last" />
				</form>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>Employee_ID</th>
			<th>Employee_Name</th>
			<th>Age</th>
			<th>Experience</th>
			<th>Seniority</th>
			<th>Salary</th>
			<th>Department_ID</th>
			<th>Actions</th>
		</tr>
		<%
		for (EmployeeModels employee : employees) {
			request.setAttribute("employee", employee);
		%>
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.age}</td>
			<td>${employee.experience}</td>
			<td>${employee.seniority}</td>
			<td>${employee.salary}</td>
			<td>${employee.department.id}</td>
			<td><a href="delete?id=${employee.id}">Delete</a> <a
				href="edit?id=${employee.id}">Edit</a></td>
		</tr>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="8" align="right" class="buttonstd">
					<form method="get" action="new">
						<input type="submit" name="submit" value="Add New Employee" />
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>