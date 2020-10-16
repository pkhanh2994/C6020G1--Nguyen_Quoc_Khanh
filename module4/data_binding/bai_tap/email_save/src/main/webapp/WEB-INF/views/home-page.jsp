<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
<h2>Email Information</h2>
<table>
    <c:forEach var="email" items="${emailList}">
    <tr>
        <td>Language</td>
        <td>${email.language}</td>
    </tr>
    <tr>
        <td>Page size</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>Spams filter</td>
        <td>${email.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signal</td>
        <td>${email.signature}</td>
    </tr>
    </c:forEach>
</table>
<form:form action="create" method="get" modelAttribute="email">
    <button value="update" name="update">Update</button>
</form:form>

</body>
</html>