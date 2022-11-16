<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test AJAX</title>
</head>
<body>

<div id="d_elem">

</div>

<button onclick="c()">Press me</button>

<script type="text/javascript">
        async function c() {
            let response = await fetch('${pageContext.request.contextPath}/value');

            let text = await response.text(); // прочитать тело ответа как текст

            let divid = document.getElementById("d_elem");

            divid.innerHTML = text;
        }
</script>

</body>
</html>