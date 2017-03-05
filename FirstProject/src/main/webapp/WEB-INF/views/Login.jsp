<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please Login</title>
</head>
<body>
	<h1>${ApplicationName}</h1>

	<h3>Enter Username and password to login</h3>
	<form:form action="/Login" method="post" modelAttribute="LoginForm">
		<spring:bind path="username">
			User Name : <input type="text" name="username" value="">
		</spring:bind>
		<spring:bind path="password">
			Password  : <input type="password" name="password" value="">
		</spring:bind>
		<input type="submit" value="Submit">

	</form:form>
</body>
</html>