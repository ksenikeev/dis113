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

    <h2>${message}</h2>


<div class="mcnt">
    <form class="container" action="/login" method="post" onsubmit="validate()">
        <input class="field" name="username" placeholder="имя пользователя"/>
        <input type="password" class="field" name="password" placeholder="пароль"/>
        <br>
        <input class="field" type="submit" value="Вход"/>
    </form>
</div>

</body>
</html>