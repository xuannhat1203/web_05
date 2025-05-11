<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuann
  Date: 5/10/2025
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        form {
            width: 300px;
            margin: 100px auto;
            padding: 20px;
            background-color: white;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        h2 {
            text-align: center;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            margin-top: 15px;
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<form action="/LoginForm" method="post">
    <h2>Đăng nhập</h2>
    <label for="username">Tên đăng nhập:</label>
    <input type="text" id="username" name="username" required>
    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" required>
    <input type="submit" value="Đăng nhập">
</form>
<c:if test="${error != null}">
    <h4>${error}</h4>
</c:if>
</body>
</html>
