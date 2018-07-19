<%--
  Created by IntelliJ IDEA.
  User: Ульяна
  Date: 28.03.2018
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
Hello!

<form action="/Controller" method="post">
    <input type="hidden" name="command" value="SHOW_REVIEW_PAGE">
    <br>
    <input type="submit" value="add review">
    <br>
</form>

<form action="/Controller" method="post">
    <input type="hidden" name="command" value="SHOW_CHANGE_INFORMATION_PAGE">
    <br>
    <input type="submit" value="change information">
    <br>
</form>

<form action="/Controller" method="post">
    <input type="hidden" name="command" value="SHOW_CHANGE_PASSWORD_PAGE">
    <br>
    <input type="submit" value="change password">
    <br>
</form>


<form action="/Controller" method="post">
    <input type="hidden" name="command" value="logout">
    <br>
    <input type="submit" value="sign out">
    <br>
</form>

</body>
</html>
