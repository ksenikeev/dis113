<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <title>Java Binding Example</title>
</head>
<body>
<h1>Bound Value</h1>
<p>You said: ${text}</p>
</body>
</html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>Welcome ${username}</h1>

<div>
<table>
<c:forEach items="${list}" var="user">
    <tr>
        <td>${user.username}</td>
    </tr>
</c:forEach>
</table>
</div>

<div>
<table>
<% for(int i = 0; i < list.size(); i+=1) { %>
        <tr>
            <td><%=list.get(i).getUsername()%></td>
        </tr>
    <% } %>
</table>
</div>

<p>
</body>
</html>