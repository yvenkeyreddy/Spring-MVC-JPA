<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Search Form</title>
</head>
<body>
	<center>
		<form:form modelAttribute="employee">
			<table border="5" cellpadding="5" bgcolor="#ECF0F1">
				<th colspan="2" bgcolor="#FAE5D3"><h2>Employee
						Search Form</h2></th>
				<tr>
					<td><b>Employee Number</b></td>
					<td><form:input path="employeeNumber" /><font size="3"
						color="red"> <form:errors path="employeeNumber" /></font></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="DELETE" size="10" /></td>
				</tr>
			</table>
			<br>
			<br>
			<a href="allemployees">Home</a>
		</form:form>
	</center>
</body>
</html>