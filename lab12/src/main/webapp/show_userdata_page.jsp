<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>


</head>
<body>

<h1>Карточка пользователя!</h1>

<div>
    <table>
        <tr>
            <td>Имя пользователя:</td>
            <td>${userdata.username}</td>
        </tr>
        <tr>
            <td>Телефон:</td>
            <td>${userdata.phone}</td>
        </tr>
    </table>
</div>

Фотография через ShowImageFromDBServlet:
<div>
    <img src="${pageContext.request.contextPath}/userphoto/${userdata.id}">
</div>

Фотография через Base64:
<div>
    <img src="data:image/jpeg;base64,${userdata.base64Photo}">
</div>

</body>
</html>