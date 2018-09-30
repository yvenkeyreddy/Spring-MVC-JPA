<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Form</title>
</head>
<body>
	<center>
		<h3>
			<font color="red">Please recheck, Username/Password is incorrect.</font>
		</h3>
		<form:form modelAttribute="loginDetails">
			<table border="5" cellpadding="5" bgcolor="#ECF0F1">
				<th colspan="2" bgcolor="#FAE5D3">
					<h2>Admin Login Form</h2>
				</th>
				<tr>
					<td><b>Enter UserName</b></td>
					<td><form:input type="text" path="username" /> <form:errors
							path="username" /></td>
				</tr>
				<tr>
					<td><b>Enter Password</b></td>
					<td><form:input type="password" path="password" /> <form:errors
							path="password" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="LOGIN" size="10" /></td>
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