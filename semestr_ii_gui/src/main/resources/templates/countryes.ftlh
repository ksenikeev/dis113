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

    <table>
        <th>ID</th><th>NAME</th>
        <#list countryes as country>
        <tr>
            <td>${country.id}</td>
            <td>${country.name}</td>
        </tr>
        </#list>
    </table>


</body>
</html>