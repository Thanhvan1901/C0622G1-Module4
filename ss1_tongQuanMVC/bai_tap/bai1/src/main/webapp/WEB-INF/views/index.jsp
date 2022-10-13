<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/9/2022
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Quy Đổi Tiền Tệ</title>
  </head>
  <body>
  <form action="/result" method="post">
      <label>Nhập USD</label>
      <input type="number" name="usd" placeholder="USD">
      <input type="submit" value="Converter">
  </form>
  <p>Tỉ Lệ : 1 USD = 23.000 VNĐ</p>
  <p> Kết Quả : ${usd} USD = ${result} VNĐ</p>
  </body>
</html>
