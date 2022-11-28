<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>

<h1 align="center">Отправка на сервер формы с данными и файлом, сохранение в БД</h1>

<div>
<form action="${pageContext.request.contextPath}/saveuser"
    method="post" enctype="multipart/form-data">

    <div><label>Имя</label><input name="username" type="text"></div>
    <div><label>Пароль</label><input name="password" type="password"></div>
    <div><label>Телефон</label><input name="phone" type="text"></div>
    <div><input type="file" name="imgfile"></div>

    <div><button type="submit">Загрузить</button></div>

</form>
</div>

</body>
</html>