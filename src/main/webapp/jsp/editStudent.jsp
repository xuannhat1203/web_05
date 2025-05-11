<%--
  Created by IntelliJ IDEA.
  User: xuann
  Date: 5/9/2025
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa thông tin sinh viên</title>
    <style>
        form {
            width: 400px;
            margin: 40px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            margin-top: 15px;
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Sửa thông tin sinh viên</h2>
<form action="StudentServlet" method="post">
    <label for="id">ID (Không thể sửa):</label>
    <input type="text" id="id" name="id" value="${idStudent}" readonly>
    <label for="name">Họ tên:</label>
    <input type="text" id="name" name="name" value="${nameStudent}" required>
    <label for="age">Tuổi:</label>
    <input type="number" id="age" name="age" value="${ageStudent}" required>
    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address" value="${addressStudent}" required>
    <input type="hidden" name="page" value="${currentPage}">
    <input type="submit" value="Cập nhật">
</form>

</body>
</html>

