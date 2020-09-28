
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator" method="post">
    <fieldset style="color: blue">
      <legend>Calculator</legend>
      <input type="text"name="nums1" placeholder="The first number">
      <br><br>
     <label> Operator</label> <select name="operator">
        <option value="+">Add</option>
        <option value="-">subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
      </select>
      <br><br>
        <input type="text"name="nums2" placeholder="The second number">
      <br><br>
        <input type="submit"value="calculator">

    </fieldset>
  </form>
  </body>
</html>
