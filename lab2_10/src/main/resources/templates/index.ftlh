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

<h2>${rc.getContextPath()}</h2>

<h2>Группы</h2>
<table>
    <th>id</th><th>Номер</th>
    <#list groupps as groupp>
    <tr>
        <td>${groupp.id}</td>
        <td>${groupp.name}</td>
    </tr>
</#list>
</table>

<a href="/groupp">Добавление группы</a>

<h2>Предметы</h2>
<table>
    <th>id</th><th>Название</th>
    <#list subjects as subject>
    <tr>
        <td>${subject.id}</td>
        <td>${subject.name}</td>
    </tr>
</#list>
</table>

<h2>Студенты</h2>
<table>
    <th>Имя</th><th>Группа</th>
    <#list students as student>
    <tr>
        <td>${student.name}</td>
        <td>${student.groupp.name}</td>
    </tr>
</#list>
</table>

<a href="/student">Добавление студента</a>


<h2>Оценки</h2>
<table>
    <th>Имя</th><th>Оценка</th>
    <#list exams as exam>
    <tr>
        <td><a href="/exam?id=${exam.id}">
            ${exam.student.name}</a></td>
        <td>${exam.score}</td>
    </tr>
</#list>
</table>




</body>
</html>