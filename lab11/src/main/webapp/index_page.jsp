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

<div>
    <button onclick="c_get()">Press me (GET Request)</button>
</div>

<div>
    <label for="data">Write data:</label>
    <input id="data" name="data" placeholder="data for send">
<div>
<div>
    <button onclick="d_post()">Press me (POST Request)</button>
</div>

<script type="text/javascript">
        async function c_get() {
            let response = await fetch('${pageContext.request.contextPath}/value');

            let text = await response.text(); // прочитать тело ответа как текст

            let divid = document.getElementById("d_elem");

            divid.innerHTML = text;
        }

        async function d_post() {
            let indata = document.getElementById("data");

            let json_data = {
                msg : 'hello',
                data: indata.value
            }

            let response = await fetch('${pageContext.request.contextPath}/value',
            {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json;charset=utf-8'
              },
              body: JSON.stringify(json_data)
            });

            let json_response = await response.json(); // прочитать тело ответа как json

            let divid = document.getElementById("d_elem");

            divid.innerHTML = json_response.data;
        }
</script>

</body>
</html>