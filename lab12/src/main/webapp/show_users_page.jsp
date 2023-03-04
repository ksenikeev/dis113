<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <style>
        body {
            background: #f2f2f280;
            font-family: sans-serif;
            font-size: 16px;
            color: #606266;
        }
        table {
            margin: 10px 50px 10px 50px;
            table-layout: fixed;
            border-collapse: collapse;
            border: 1px solid gray;
        }

        th {
            background: linear-gradient(to bottom, rgba(0,0,0,0.1), rgba(0,0,0,0.5));
            color: #A0A0A0;
        }

        td {
            padding: 10px;
            border: 1px solid gray;
            text-align: center;
        }

        .zebra {
            table-layout: fixed;
            border-collapse: collapse;
            border: 1px solid green;
        }

        .zebra tr:nth-child(odd) {
            background-color: #909090;
        }

        .zebra tr:nth-child(even) {
            background-color: #A0A0A0;
        }
    </style>


</head>
<body>

<h1>Добро пожаловать!</h1>

<div>
    <table class="zebra">
        <th>username</th><th>phone</th><th></th>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><a href="${pageContext.request.contextPath}/user?userId=${user.id}">${user.username}</a></td>
                <td>${user.phone}</td>
                <td><button onclick="location.href='${pageContext.request.contextPath}/user?userId=${user.id}'">Открыть</button></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>