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
<input type="button" value="change password" onClick='location.href="jsp/changePasswordPage.jsp"'>
<input type="button" value="change info" onClick='location.href="jsp/changeInformationPage.jsp"'>
<input type="button" value="add review" onClick='location.href="jsp/addReviewPage.jsp"'>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="logout">
    <br>
    <input type="submit" value="sign out">
    <br>
</form>
</body>
</html>
