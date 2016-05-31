<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	FORM EXAMPLE:
	<br><hr><br>
		Simple scriplet:
		<% String name = (String)request.getAttribute("nameUser"); %>
		<% out.println(name); %>
	<br><hr><br>
		<c:set var="usName" value="Simon"/>
		<h1><c:out value = "${usName}"/></h1>
	<br><hr><br>
		<c:forEach var="product" items="${products}">
    		<p>${product}</p>
		</c:forEach>
	<br><hr><br>	
	<c:set var="var" value="331"/>
	<c:out value="${var}"/>
	<br><hr><br>	
	<c:out value="Hello ${name}"/>
</body>
</html>