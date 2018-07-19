
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>registration</title>
</head>
<body>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="registration">
    Name:<br>
    <input type="text" name="name" value=""><br>
    Surname:<br>
    <input type="text" name="surname" value=""><br>
    Email:<br>
    <input type="text" name="email" value=""><br>
    Phone Number:<br>
    <input type="text" name="phoneNumber" value=""><br>
    Login:<br>
    <input type="text" name="login" value=""><br>
    Password:<br>
    <input type="password" name="password" value=""><br>
    Repeat password:<br>
    <input type="password" name="repeatPassword" value=""><br>
    <br>
    <input type="submit" value="registration">
    <br>
</form>

<form action="/Controller" method="post">
    <input type="hidden" name="command" value="SHOW_LOGIN_PAGE">
    <br>
    <input type="submit" value="back">
    <br>
</form>
</body>
</html>
