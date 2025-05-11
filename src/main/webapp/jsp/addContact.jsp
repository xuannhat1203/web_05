<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Thêm liên hệ mới</title>
    <style>
        form {
            width: 400px;
            margin: 30px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
        }
        input[type="submit"] {
            margin-top: 15px;
            padding: 10px 20px;
        }
    </style>
</head>
<body>
<h2 style="text-align:center;">Thêm liên hệ mới</h2>
<form action="ContactController" method="post">
    <label for="firstName">Họ:</label>
    <input type="text" name="firstName" id="firstName" required>
    <label for="lastName">Tên:</label>
    <input type="text" name="lastName" id="lastName" required>

    <label for="email">Email:</label>
    <input type="email" name="email" id="email" required>

    <label for="phone">Số điện thoại:</label>
    <input type="text" name="phone" id="phone" required>
    <input type="hidden" name="action" value="create">
    <input type="submit" value="Thêm liên hệ">
</form>
</body>
</html>
