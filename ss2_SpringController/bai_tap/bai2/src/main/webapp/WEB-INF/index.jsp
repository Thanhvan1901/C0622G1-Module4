<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/12/2022
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="caculator" method="get">
<h1>Caculator</h1>
    <input type="number" name="num1" value="${num1}" placeholder="Number Enter">
    <input type="number" name="num2" value="${num2}" placeholder="Number Enter">
  </br>
    <input type="submit" name="operator" value="Addition" placeholder="Addition +">
    <input type="submit" name="operator" value="Subtraction" placeholder="Subtraction -">
    <input type="submit" name="operator" value="Multiplication" placeholder="Multiplication x">
    <input type="submit" name="operator" value="Division" placeholder="Division /">
    <p>Kết Quả : ${result}</p>
  </form>
  </body>
</html>
