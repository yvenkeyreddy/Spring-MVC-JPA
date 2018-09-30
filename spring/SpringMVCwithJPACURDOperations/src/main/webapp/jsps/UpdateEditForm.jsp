<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Edit Details</title>
</head>
<body bgcolor="#D5D8DC">
	<center>
		<form:form modelAttribute="employee">
			<font color="green">
				<h1>Welcome to Employee Management System !</h1>
			</font>
			<h3>
				<font color="#1A5276"> <u>Employees Details are</u></font>
			</h3>
			<table align="center" border="3" cellpadding="10" bgcolor="#A2D9CE">
				<tr align="center">
					<th>Employee Number</th>
					<th>Employee Name</th>
					<th>Employee Phone Number</th>
					<th>Employee Email</th>
					<th>Employee Salary</th>
					<th>Employee Location</th>
				</tr>

				<c:if test="${employeeData != null}">
					<tr>
						<td><input type="text" value="${employeeData.employeeNumber}" /></td>
						<td><input type="text" value="${employeeData.employeeName}" /></td>
						<td><input type="text"
							value="${employeeData.employeePhoneNumber}" /></td>
						<td><input type="text" value="${employeeData.employeeMail}" /></td>
						<td><input type="text" value="${employeeData.employeeSalary}" /></td>
						<td><input type="text"
							value="${employeeData.employeeLocation}" /></td>
					</tr>
					<tr>
						<td colspan="6" align="center"><input type="submit"
							value="UPDATE" size="10" /></td>
					</tr>
				</c:if>
			</table>

			<c:if test="${employeeData == null}">
				<br>
				<h3>
					<font color="red"> Please enter valid employee number </font>
				</h3>
			</c:if>
			<br>
			<br>
			<a href="allemployees">Home</a>
		</form:form>
	</center>
</body>
</html>