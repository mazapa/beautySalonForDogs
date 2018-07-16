
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>set review</title>
</head>
<body>
<form action="/Controller" method="post">
    <input type="hidden" name="command" value="add_review">
    Review:<br>
    <input type="text" name="review" value=""><br>
    <br>
    <input type="submit" value="add">
    <br>
</form>

</body>
</html>
