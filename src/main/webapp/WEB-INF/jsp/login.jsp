<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DAE - Powered by Talas</title>
</head>
<portlet:renderURL var="viewLogin">
	<portlet:param name = 'renderme' value = 'login'/>
</portlet:renderURL>
<body>
	<h1>Log In</h1>
	<center>
		<h2>User Details</h2>
		<br/>User name:<input type="text" name="username">
		<br/>Password:<input type="password" name="password">
		<br/>
		<a href="${viewLogin}">
			<button type="button">Log In</button>
		</a>
	</center>
</body>
</html>