<%--
  Created by IntelliJ IDEA.
  User: Ульяна
  Date: 09.07.2018
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="send_password">
    Email:<br>
    <input type="text" name="email" value=""><br>
    <input type="submit" value="send">
    <br>
</form>
</body>
</html>
