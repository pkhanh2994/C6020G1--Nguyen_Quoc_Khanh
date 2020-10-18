<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST" action="saveEmail" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="id">Employee ID: </form:label></td>
            <td><form:select path="language">
                <form:option value="english">Enlish</form:option>
                <form:option value="japanese">Japanese</form:option>
                <form:option value="vietNamese">VietNamese</form:option>
                <form:option value="quocKhanhese">QuocKhanhese</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td><form:select path="pageSize">
                <form:option value="25">25</form:option>
                <form:option value="30">30</form:option>
                <form:option value="35">35</form:option>
                <form:option value="40">40</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td><form:checkbox path="spamsFilter">Enable spams filter</form:checkbox></td>
        </tr>
        <tr>
            <form:label path="signature">Signature</form:label>
            <form:textarea path="signature"></form:textarea>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>