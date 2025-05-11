<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách sản phẩm</title>
  <style>
    table {
      border-collapse: collapse;
      width: 80%;
      margin: 20px auto;
    }
    th, td {
      padding: 10px;
      border: 1px solid #ccc;
    }
    th {
      background-color: #eee;
    }
    h2 {
      text-align: center;
    }
  </style>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên sản phẩm</th>
    <th>Giá</th>
    <th>Mô tả</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="product" items="${productList}">
    <tr>
      <td>${product.id}</td>
      <td>${product.productName}</td>
      <td>${product.price}</td>
      <td>${product.description}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
