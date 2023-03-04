<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>



</head>
<body>

<h1>Добро пожаловать!</h1>

<div>
    <form action="${pageContext.request.contextPath}/usercheck" enctype="application/x-www-form-urlencoded" method="post">
        <table>
            <tr>
                <td>Логин</td><td> <input type="text" name="username"> </td>
            </tr>
            <tr>
                <td>Пароль</td><td> <input type="password" name="password"> </td>
            </tr>
            <tr>
                <td colspan="2"> <button type="submit">Вход</button> </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>