<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ваша поездка</title>

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

<h1 align="center">Ваш заказ</h1>

<div>
    <table>
        <tr>
            <td>Откуда едете:</td><td>${address_from}</td>
        </tr>
        <tr>
            <td>Куда едете:</td><td>${address_to}</td>
        </tr>
        <tr>
            <td>Статус:</td><td>${trip_status}</td>
        </tr>
        <tr>
            <td>Марка:</td><td>${car_brand}</td>
        </tr>
        <tr>
            <td>Номер:</td><td>${car_number}</td>
        </tr>
        <tr>
            <td>Цвет:</td><td>${car_color}</td>
        </tr>
    </table>
</div>

</body>
</html>