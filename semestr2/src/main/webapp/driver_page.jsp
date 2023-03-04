<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

</head>
<body>

<h1>Добро пожаловать водитель!</h1>

<h2>Свободные заказы:</h2>
<div>
    <table>
        <c:forEach items="${trips}" var="trip">
        <tr>
            <td>${trip.addressFrom}</td><td>${trip.addressTo}</td><td>${trip.client.phone}</td>
            <td><a href="${pageContext.request.contextPath}/trip?id=${trip.id}">Перейти</a></td>
        </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>