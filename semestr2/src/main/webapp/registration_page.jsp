<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>

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

<script type="text/javascript">
    function hide_car() {
        let select = document.getElementById("role");
        let div = document.getElementById("car_data");

        if (select.value == 1) {
            div.style.display="none";
        } else {
            div.style.display="block";
        }
    }
</script>

<div>
    <form action="${pageContext.request.contextPath}/savereg" method="post"
          enctype="application/x-www-form-urlencoded">
        <p>
        <label for="role">Выберите роль:</label>
        <select id="role" name="user_role" onchange="hide_car();">
            <option value="1">Клиент</option>
            <option value="2">Водитель</option>
        </select>

        <p>
            <label>Ваше имя:</label>
            <input name="name" type="text">

        <p>
            <label>Телефон:</label>
            <input name="phone" type="text">

        <p>
            <label>Номер карты:</label>
            <input name="card_number" type="text">

        <p>
            <label>Логин:</label>
            <input name="username" type="text">

        <p>
            <label>Пароль:</label>
            <input name="password" type="password">

        <div id="car_data" style="display:none">
            Данные автомобиля:
            <p>
                <label>Номер:</label>
                <input name="car_number" type="text">
            <p>
                <label>Марка:</label>
                <input name="car_brand" type="text">
            <p>
                <label>Цвет:</label>
                <input name="color" type="text">
        </div>

        <input type="submit" value="Зарегистрироваться">
    </form>

</div>

</body>
</html>