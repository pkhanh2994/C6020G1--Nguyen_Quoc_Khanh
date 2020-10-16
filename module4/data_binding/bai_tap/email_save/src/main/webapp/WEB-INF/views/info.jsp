<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Infor</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Language :</td>
        <td>${email.language}</td>
    </tr>
    <tr>
        <td>Page Size :</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>Spam filter :</td>
        <td>${email.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature :</td>
        <td>${email.signature}</td>
    </tr>
</table>
</body>
</html>