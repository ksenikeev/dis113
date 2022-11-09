<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>Welcome ${username}</h1>

<form method="post" action="${pageContext.request.contextPath}/adduser">
    <div> Username: <input name="username"></div>
    <div> Password: <input name="password"></div>
    <div> Group: <input name="group" value="${group}"></div>

    <div><input type="submit" value="Add new user"></div>
</form>

<p>
</body>
</html>