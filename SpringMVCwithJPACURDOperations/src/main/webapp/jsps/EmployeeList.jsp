<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body bgcolor="#D5D8DC">
	<table align="right">
		<th><a href="logout"> <input type="button" value="LOGOUT"/> </a></th>
		<td><a href="allemployees"> <input type="button" value="Home"/> </a></td>
		
	</table>
	<center>
		<font color="green">
			<h1>Welcome to Employee Management System !</h1>
		</font>
		<table border="5" cellpadding="5" bgcolor="#F5EEF8">
			<th><a href="newemployee"> <input type="button" value="Add New Employee Details"/></a></th>
			<th><a href="updateemployee"> <input type="button" value="Update Employee Details"/></a></th>
			<th><a href="deleteemployee"> <input type="button" value="Delete Employee Details"/></a></th>
			<th><a href="allemployees"> <input type="button" value=" Display All Employees Details"/></a></th>
		</table>

		<h3> <font color="#1A5276"> <u>List of Employees are</u></font> </h3>
		<table align="center" border="3" cellpadding="10" bgcolor="#A2D9CE">
			
			<tr align="center">
				<th>Employee Number</th>
				<th>Employee Name</th>
				<th>Employee Phone Number</th>
				<th>Employee Email</th>
				<th>Employee Salary</th>
				<th>Employee Location</th>
			</tr>
			<c:forEach var="employee" items="${employee}">
				<tr>
					<td align="center"><c:out value="${employee.employeeNumber}" /></td>
					<td><c:out value="${employee.employeeName}" /></td>
					<td><c:out value="${employee.employeePhoneNumber}" /></td>
					<td><c:out value="${employee.employeeMail}" /></td>
					<td><c:out value="${employee.employeeSalary}" /></td>
					<td><c:out value="${employee.employeeLocation}" /></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>