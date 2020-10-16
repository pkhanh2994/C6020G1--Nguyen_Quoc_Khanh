<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new email details</title>
</head>
<body>
<h3>Welcome, Enter The Email Details</h3>
<form:form method="POST" action="saveEmail" modelAttribute="email">
    <table>
        <tr>
            <td > <form:label path="language">Language</form:label></td>
            <td>
                <form:select path="language" itemValue="${email.language}">
                    <form:option value="english">English</form:option>
                    <form:option value="japanese">Japanese</form:option>
                    <form:option value="vietNamese">VietNamese</form:option>
                    <form:option value="quocKhanhese">QuocKhanhese</form:option>
                 </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize"> Page Size</form:label></td>
            <td><form:select path="pageSize">
                <form:option value="25">25</form:option>
                <form:option value="30">30</form:option>
                <form:option value="35">35</form:option>
                <form:option value="40">40</form:option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter</form:label></td>
            <td><form:checkbox path="spamsFilter" value="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td>  <form:label path="signature">Signature</form:label></td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
        <tr>
            <td>
                <button type="button" name="Back" id="bh" onclick="backhome()">Back</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
<script>
    function backhome() {
        document.getElementById("bh").innerHTML="home-page.jsp"

    }
</script>
</html>