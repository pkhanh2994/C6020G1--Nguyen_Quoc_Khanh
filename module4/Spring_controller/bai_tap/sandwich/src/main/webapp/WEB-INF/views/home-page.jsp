<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<h2>Please choose your menu</h2>

<form action="home">
   <label>lettuce</label> <input type="checkbox" value="lettuce" name="condiment">
  <label>tomato </label>  <input type="checkbox" value="tomato"  name="condiment">
   <label>mustard</label> <input type="checkbox" value="mustard" name="condiment">
   <label>sprouts</label> <input type="checkbox" value="sprouts" name="condiment">
    <input type="submit" value="save">
</form>
        result:
        <c:forEach var="result" items="${message}">
            <c:out value="${result}"></c:out>
        </c:forEach>


</body>
</html>