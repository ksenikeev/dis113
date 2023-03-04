<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Новая поездка</title>

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
    <form action="${pageContext.request.contextPath}/addtrip" method="post"
          enctype="application/x-www-form-urlencoded">
        <p>
            <label>Ваш адрес:</label>
            <input name="address_from" type="text">

        <p>
            <label>Куда поедете:</label>
            <input name="address_to" type="text">

        <p>
        <input type="submit" value="Заказать">
    </form>

</div>

</body>
</html>