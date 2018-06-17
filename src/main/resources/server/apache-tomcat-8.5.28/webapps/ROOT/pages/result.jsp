<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h3>${parsingResult}</h3>
<table>
    <c:forEach items="${list}" var="item">
        <tr>
            <td><c:out value="${item}" /></td>
        </tr>
    </c:forEach>
</table>
<h1>${error}</h1>

<form action="${pageContext.request.contextPath}/index.jsp">
    <input type="submit" value="${back}"/>
</form>

</body>
</html>
