<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Start Page</title>
</head>
<body>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="sign_in">
    Login:<br>
    <input type="text" name="login" value=""><br>
    Password:<br>
    <input type="password" name="password" value=""><br><br>
    <input type="submit" value="sign in">
</form>
<form>
    <input type="button" value="registration" onClick='location.href="jsp/registrationPage.jsp"'>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
</form>

</body>
</html>
