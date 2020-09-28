<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/24/2020
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Convert</title>
</head>
<body>
    <h2 style="text-align: center; color:black">  <%=request.getAttribute("usd")%>USD</h2>
    <h2 style="text-align: center;color: black"> Rate :<%=request.getAttribute("rate")%></h2>
    <h2 style="text-align: center; color: violet"> Result: <%=request.getAttribute("result")%>VND</h2>
</body>
</html>
