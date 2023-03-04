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

<input id="driverID" type="hidden">

<div>
    <table>
        <tr>
            <td>Откуда едете:</td><td>${trip.addressFrom}</td>
        </tr>
        <tr>
            <td>Куда едете:</td><td>${trip.addressTo}</td>
        </tr>
        <tr>
            <td>Статус:</td><td>${trip.status.name}</td>
        </tr>
        <tr>
            <td>Телефон:</td><td>${trip.client.phone}</td>
        </tr>
    </table>
</div>

<div>
    <button onclick="accept_trip();">Принять</button>
</div>

<script type = "text/javascript">

    var wsUri = "ws://localhost:8080${pageContext.request.contextPath}/accept_trip";
    var webSocket1 = new WebSocket(wsUri);

    function accept_trip() {

        let driverId = document.getElementById("driverID").value;
        let message = {
            driverId : driverId,
            tripId : ${trip.id}
        }
        webSocket1.send(JSON.stringify(message));
    }

    webSocket1.onmessage = function(message) {

    }

    webSocket1.onopen = function() {
        console.log("connection opened");
    };

    webSocket1.onclose = function() {
        console.log("connection closed");
    };

    webSocket1.onerror = function wserror(message) {
        console.log("error: " + message);
    }

</script>

</body>
</html>