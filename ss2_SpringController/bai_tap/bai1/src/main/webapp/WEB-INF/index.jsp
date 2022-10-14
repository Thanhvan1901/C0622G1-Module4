<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/12/2022
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <br>
  <h1>Sandwich Condiments</h1>
<form action="condiments" method="get">
  <input type="checkbox" name="condiments" id="lettuce" value="Lettuce">
  <label for="lettuce">Lettuce</label>
  <input type="checkbox" name="condiments" id="tomato" value="Tomato">
  <label for="tomato">Tomato</label>
  <input type="checkbox" name="condiments" id="mustard" value="Mustard">
  <label for="Mustard">Lettuce</label>
  <input type="checkbox" name="condiments" id="sprouts" value="Sprouts">
  <label for="sprouts">Lettuce</label></br>
  <input type="submit" placeholder="Submit">
</form>
</br>
  <c:forEach items="${condiments}" var="condiments">
    <p>${condiments}</p>
  </c:forEach>
  </body>
</html>
