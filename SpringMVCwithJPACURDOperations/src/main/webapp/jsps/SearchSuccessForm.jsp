<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employee Details</title>
</head>
<body>
	<center>
		<form:form modelAttribute="employee">
			<table border="5" cellpadding="5" bgcolor="#ECF0F1">
				<th colspan="2" bgcolor="#FAE5D3"><h2>Employee Search Form</h2></th>
				<tr>
					<td><b>Employee Number</b></td>
					<td><form:input path="employeeNumber" /><font size="3"
						color="red"> <form:errors path="employeeNumber" /></font></td>
					<input type="submit" value="search" />
				</tr>

				<c:if test="${employee != null}">
					<table align="center" border="2" cellpadding="10" bgcolor="#A2D9CE">
						<tr align="center">
							<th>Employee Number</th>
							<th>Employee Name</th>
							<th>Employee Phone Number</th>
							<th>Employee Email</th>
							<th>Employee Salary</th>
							<th>Employee Location</th>
						</tr>
						<tr align="center">
							<td><c:out value="${employee.employeeNumber}" /></td>
							<td><c:out value="${employee.employeeName}" /></td>
							<td><c:out value="${employee.employeePhoneNumber}" /></td>
							<td><c:out value="${employee.employeeMail}" /></td>
							<td><c:out value="${employee.employeeSalary}" /></td>
							<td><c:out value="${employee.employeeLocation}" /></td>
						</tr>
					</table>
				</c:if>
				<c:if test="${employee == null}">
					<br>
					<h3>
						<font color="red"> Please enter valid employee number </font>
					</h3>
				</c:if>
			</table>
		</form:form>
	</center>
</body>
</html>