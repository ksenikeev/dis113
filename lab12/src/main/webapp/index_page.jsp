<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <style type="text/css">
        a {
            outline: none;
            text-decoration: none;
            padding: 2px 1px 0;
            color: #606060;
        }

        a:focus, a:hover {
            border-bottom: 1px solid;
        }
    </style>
</head>
<body>

<h1 align="center">Добро пожаловать!</h1>

<div>
<a href="${pageContext.request.contextPath}/fileupload">Пример загрузки на сервер файлов. Сохранение в директории на диске</a>
</div>

<div>
    <a href="${pageContext.request.contextPath}/newuser">Пример отправки формы с данными и файлом</a>
</div>

<div>
    <a href="${pageContext.request.contextPath}/users">Список всех пользователей</a>
</div>

</body>
</html>