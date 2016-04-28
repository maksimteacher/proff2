<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/my.js"></script>
</head>
<body>
	admin
	Я [<% String n = (String)request.getAttribute("atr"); out.println(n); %>
	<input type="button" id="ajaxAction" value="ajaxAction">
	<table id="table" border="2">
		<tr>
			<td>Имя</td>			
			<td>Пароль</td>
		</tr>
	</table>
</body>
</html>