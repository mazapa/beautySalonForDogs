<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h2>${currentLoc} - ${locale}</h2>
<form action="Localisation" method="post">
    <select name="localisation">
        <option value="en_US">English</option>
        <option value="ru_RU">Русский</option>
    </select>
    <br/>
    <input type = "submit" value = "${loc}" />
</form>
        ${chooseFile}: <br />

        <form action = "UploadFiles" method = "post" enctype = "multipart/form-data">
            <input type = "file" name = "file" size = "50" />
            <br/>
            <select name="parsingMethod">
                <option value="dom">DOM</option>
                <option value="sax">SAX</option>
                <option value="stax">STAX</option>
                <option value="unm">UNM</option>
            </select>
            <br/>
            <input type = "submit" value = "${parseFile}" />
            <br/>
        </form>


</body>
</html>
