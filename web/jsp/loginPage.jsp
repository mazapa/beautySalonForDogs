<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Start Page</title>
</head>
<body>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="login">
    Login:<br>
    <input type="text" name="login" value=""><br>
    Password:<br>
    <input type="password" name="password" value=""><br><br>
    <input type="submit" value="login">
</form>

<form action="/Controller" method="post">
    <input type="hidden" name="command" value="SHOW_REGISTRATION_PAGE">
    <br>
    <input type="submit" value="registration">
    <br>
</form>

</body>
</html>
