<<%@ page language="java" contentType="text/html; charset=UTF-8"
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
  <% String st = (String)request.getSession().getAttribute("message"); if(st != null)out.println(st); %>
  <br><br><br>
  <p><b>Title:</b> <% String s = (String)request.getSession().getAttribute("questionTitle"); if(s != null)out.println(s); %></p>
  <p><b>Theme:</b> <% String s2 = (String)request.getSession().getAttribute("questionTheme"); if(s2 != null)out.println(s2); %></p>
  <p><b>Asked by:</b> <% String s3 = (String)request.getSession().getAttribute("questionAskedBy"); if(s3 != null)out.println(s3); %></p>
  <p>"<% String s4 = (String)request.getSession().getAttribute("questionContent"); if(s != null)out.println(s4); %>"</p>
  <p><form action = "employee" method="post">
  <textarea rows="10" cols="45" name="newAnswerText" placeholder="Enter your answer here"></textarea>
  <input type="submit" name="submitAnswer" value="answer">
  </form></p>
</div>
</body>
</html>
