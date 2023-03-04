<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>Welcome</h1>

<div>

<table>
    <#list tblData as lst>
        <tr>
            <td>${lst.field1}</td><td>${lst.field2}</td><td>${lst.field3}</td>
        </tr>
    </#list>
</table>
</div>
<p>
</body>
</html>