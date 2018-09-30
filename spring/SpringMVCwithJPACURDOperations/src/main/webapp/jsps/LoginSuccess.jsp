<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Form</title>
</head>
<body>
	<center>
		<h3>
			<font color="green"> Your successfully Logined <br>
				<c:if test="${loginDetails != null}">
					<c:out value="${loginDetails.username}" /> <br>
				</c:if> <br> <a href="allemployees">Home</a>
			</font>
		</h3>
	</center>
</body>
</html>