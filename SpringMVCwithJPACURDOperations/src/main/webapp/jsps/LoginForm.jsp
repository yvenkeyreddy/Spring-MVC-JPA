<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login Form</title>
</head>
<body>
	<center>
		<form:form modelAttribute="loginDetails">
			<table border="5" cellpadding="5" bgcolor="#ECF0F1">
				<th colspan="2" bgcolor="#FAE5D3">
					<h2>Admin Login Form</h2>
				</th>
				<tr>
					<td><b>Enter UserName</b></td>
					<td><form:input type="text" path="username" /> <font size="3"
						color="red"> <form:errors path="username" />
					</font></td>
				</tr>
				<tr>
					<td><b>Enter Password</b></td>
					<td><form:input type="password" path="password" /><font
						size="3" color="red"> <form:errors path="password" />
					</font></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="LOGIN" size="10" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>