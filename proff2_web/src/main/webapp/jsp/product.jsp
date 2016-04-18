<!--  product.jsp  -->
<%@ page import="java.util.List"%>
<%@ page import="domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<Product> list = (List<Product>)request.getAttribute("products"); %>
	<table border="1">
		<% out.println(Product.toTableHeader());%>
		<% if(list!=null) for(Product pr:list)out.println(pr.toTable());%>
	</table>
	<form method="get" action="/proff2_web/product">
		<input type="text" name="productName"/>
		<input type="text" name="productCode"/>
		<input type="submit" value="Отправить на сервер данные формы"/>	
	</form>

	
</body>
</html>