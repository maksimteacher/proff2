<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../js/my.js"></script>
</head>
<body id="center">
<div align="center">

  <% String st = (String)request.getAttribute("message"); if(st != null)out.println(st); %>

  <form action="/questionAsk" method="post">
    <p><b>Enter your question:</b></p>
    <p><input type="text" name="newQuestionTitle" placeholder="Title"></p>
    <p><textarea rows="10" cols="45" name="newQuestionText" placeholder="Enter you question"></textarea></p>
    <br>
    <p><input type="submit" value="Submit"></p>
  </form>
  <br><br><br><br>
  <% String s = (String)request.getAttribute("questionsTable"); if(s != null)out.println(s); %>
</div>
</body>
</html>
