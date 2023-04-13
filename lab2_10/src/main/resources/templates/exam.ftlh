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

    <h2>Данные экзамена</h2>

<table>
    <tr>
        <td>Студент:</td><td>${exam.student.name}</td>
    </tr>
    <tr>
        <td>Группа:</td><td>${exam.student.groupp.name}</td>
    </tr>
    <tr>
        <td>Предмет:</td><td>${exam.subject.name}</td>
    </tr>
    <tr>
        <td>Оценка:</td><td>${exam.score}</td>
    </tr>
</table>

</body>
</html>