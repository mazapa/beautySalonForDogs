
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>registration</title>
</head>
<body>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="change_information">
    Name:<br>
    <input type="text" name="name" value="Ульяна"><br>
    Surname:<br>
    <input type="text" name="surname" value=""><br>
    Email:<br>
    <input type="text" name="email" value=""><br>
    Phone Number:<br>
    <input type="text" name="phoneNumber" value=""><br>
    <br>
    <input type="submit" value="change information">
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
