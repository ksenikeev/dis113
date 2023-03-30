<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Тест</title>

    <link rel='stylesheet' href='/static/css/game.css'>
    <script src='/static/js/game.js'></script>
</head>
<body>

<div class="mcnt">
    <h2>Аутентификация прошла успешно</h2>
</div>

<#list protocols as protocol>
<div>
    ${protocol.id} ${protocol.username} ${protocol.accessTime}
</div>
</#list>


</body>
</html>