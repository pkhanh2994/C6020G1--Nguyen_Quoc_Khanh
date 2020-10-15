<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<form action="/calculator" method="post">
    <fieldset style="color: blue">
        <legend>Calculator</legend>
        <label>The first number</label> <input type="text" name="nums1" placeholder="The first number" value="${nums1}">
        <label>The second number</label> <input type="text" name="nums2" placeholder="The second number" value="${nums2}">
        <br><br>
        <button value="+" id="add" name="operator" onclick="operatorr()"> Add(+)</button>
        <button value="-" id="sub" name="operator" onclick="operatorr()"> Sub(-)</button>
        <button value="*" id="mul" name="operator" onclick="operatorr()"> Multiplication(*)</button>
        <button value="/" id="di" name="operator" onclick="operatorr()"> Division(/)</button>

    </fieldset>
</form>
<div>
    <h2 style="color: blue">Result: ${result}</h2>
</div>
</body>
<script>
    function operatorr(){
        document.getElementById("add").innerHTML="+";
        document.getElementById("sub").innerHTML="-";
        document.getElementById("mul").innerHTML="*";
        document.getElementById("di").innerHTML="/";
    }

</script>
</html>
