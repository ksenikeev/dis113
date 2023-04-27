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

<h2>Добавление/изменение студента</h2>

<div>
    <form method="post" action="/addstudent">
        <div>Номер группы:</div>
        <div>
            <select name="groupp">
                <#list groupps as groupp>
                <option value="${groupp.id}">${groupp.name}</option>
                </#list>
            </select>
        </div>

        <div>Студент:</div>
        <div><input type="text" name="student" placeholder="имя студента"/></div>

        <div><input type="submit" value="Сохранить"/></div>
    </form>
</div>


</body>
</html>