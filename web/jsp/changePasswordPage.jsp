
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>change pass</title>
</head>
<body>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="change_password">
    Password:<br>
    <input type="password" name="oldPassword" value=""><br>
    New password:<br>
    <input type="password" name="password" value=""><br>
    Repeat password:<br>
    <input type="password" name="repeatPassword" value=""><br>
    <br>
    <input type="submit" value="change">
    <br>
</form>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="SHOW_welcome_PAGE">
    <br>
    <input type="submit" value="main">
    <br>
</form>
</body>
</html>
