<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
</head>
<body>

<div>
<table>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.username}</td>
    </tr>
</c:forEach>
</table>
</div>

<p>
</body>
</html>