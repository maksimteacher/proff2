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
  <form action="/admin" method="post">
    <p><b>Edit your question:</b></p>
    <p><input type="text" name="questionTitle" size="43" value="<% String st = (String)request.getSession().getAttribute("questionTitle"); if(st != null)out.println(st); %>"></p>
    <br>
    <p><textarea rows="10" cols="45" name="questionContent">
      <% String str = (String)request.getSession().getAttribute("questionContent"); if(str != null)out.println(str); %>
    </textarea></p>
    <br>
    <p><% String strg = (String)request.getSession().getAttribute("droplist"); if(strg != null)out.println(strg); %></p>
    <br>
    <p><input type="submit" name="questionStatus" value="approved"></p>
    <input type="submit" name="questionStatus" value="disapproved">
  </form>
</div>
</body>
</html>
