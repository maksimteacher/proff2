<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/my.js"></script>
</head>
<body>
    <form action="" id="regForm" class="formMain regForm">
        <h2>Регистрация</h2>
        <input type="text" name="nameReg" placeholder="Введите имя">
        <input type="text" name="loginReg" placeholder="Введите логин">
        <input type="text" name="passReg" placeholder="Введите пароль">
        <input type="submit" value="Зарегистрироваться">
    </form>
    <form action="" id="authForm" class="formMain authForm">
        <h2>Авторизация</h2>
        <% String cookName = (String) request.getAttribute("cookName");
 			if(cookName==null)cookName="";       
        %>
        <input type="text" name="loginIn" placeholder="логин" value="<%out.println(cookName); %>">
        <input type="text" name="passIn" placeholder="Введите пароль">
        Запомнить <input type="checkbox">
        <input type="button" id="openReg" class="MiniButton" value="регистрация">
        <input type="submit" value="Войти">        
    </form>

</body>
</html>