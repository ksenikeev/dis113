<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"r
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Тест</title>

    <link rel='stylesheet' href='/static/css/game.css'>
    <script src='/static/js/game.js'></script>
</head>
<body>

<div>
    <form action="/addproduct" method="post">
        <div>
            Product name: <input name="name" type="text"/>
        </div>
        <div>
            Unit:
            <select name="unitsCode">
                <option value="kg">Килограмм</option>
                <option value="m">Метр</option>
                <option value="liter">Литр</option>
            </select>
        </div>
        <div>
            <input type="submit">Сохранить</input>
        </div>

    </form>
</div>

</body>
</html>