<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome client</title>

</head>
<body>

<h1>Добро пожаловать клиент!</h1>

<div><a href="${pageContext.request.contextPath}/newtrip">Новая поездка</a> </div>

<div><a href="${pageContext.request.contextPath}/trips">Все заказы</a> </div>

</body>
</html>