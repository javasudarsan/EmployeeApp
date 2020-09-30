<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h1 align="center">Welcome to login page</h1>
<a href="${pageContext.request.contextPath}/login1?lang=en">Login(English)</a>
<a href="${pageContext.request.contextPath}/login1?lang=hi">Login(Hindi)</a> 
			<a href="${pageContext.request.contextPath}/login1?lang=od">Login(Odia)</a>
			
</body>
 
</html>