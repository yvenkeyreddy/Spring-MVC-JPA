<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Form</title>
</head>
<body>
	<center>
		<form:form modelAttribute="employee" action="updateemployee" method="post">
		
		
		
			<table border="5" cellpadding="5" bgcolor="#ECF0F1">
				<th colspan="2" bgcolor="#FAE5D3"><h2>Employee
						Registration Form</h2></th>
				<tr>
					<td><b>Employee Number</b></td>
					<td><form:input path="employeeNumber" /> <font size="3"
						color="red"> <form:errors path="employeeNumber" /></font></td>

				</tr>
				<tr>
					<td><b>Employee Name</b></td>
					<td><form:input path="employeeName" /><font size="3"
						color="red"> <form:errors path="employeeName" /></font></td>
				</tr>
				<tr>
					<td><b>Employee Phone Number</b></td>
					<td><form:input path="employeePhoneNumber" /><font size="3"
						color="red"> <form:errors path="employeePhoneNumber" /></font></td>
				</tr>
				<tr>
					<td><b>Employee Mail</b></td>
					<td><form:input path="employeeMail" /><font size="3"
						color="red"> <form:errors path="employeeMail" /></font></td>
				</tr>
				<tr>
					<td><b>Employee Salary</b></td>
					<td><form:input path="employeeSalary" /><font size="3"
						color="red"> <form:errors path="employeeSalary" /></font></td>
				</tr>
				<tr>
					<td><b>Employee Location</b></td>
					<td><form:input path="employeeLocation" /><font size="3"
						color="red"> <form:errors path="employeeLocation" /></font></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="SAVE" size="10" /></td>
				</tr>
			</table>
			<br>
			<br>
			<br>
			<a href="allemployees">Home</a>
		</form:form>
	</center>
</body>
</html>