<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload files</title>
</head>
<body>

<h1>Пример загрузки файлов на сервер</h1>

<div>
    <form action="${pageContext.request.contextPath}/upimg" method="post" enctype="multipart/form-data">
        <div>Выберите фотографии для загрузки</div>
        <input type="file" name="imgfile" accept="image/*" multiple>
        <button type="submit">Отправить на сервер</button>
    </form>
</div>


<div>
    <code style="color: #909090">
        <p>Обработка сервлетом:
        <p>
        <p>package ru.itis.lab12;
        <p>...
        <p>@WebServlet("/upimg")
        <p>@MultipartConfig
        <p>public class UploadImageServlet extends HttpServlet {
        <p>...
        <p>}
    </code>
</div>


</body>
</html>