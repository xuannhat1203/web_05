<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm công việc</title>
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
        input[type="date"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        input[type="checkbox"] {
            margin-top: 10px;
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

<h2 style="text-align: center;">Thêm công việc mới</h2>

<form action="TaskController" method="post">
    <input type="hidden" name="action" value="add"/>
    <label for="description">Mô tả công việc:</label>
    <input type="text" id="description" name="description" required>
    <label for="dueDate">Hạn chót:</label>
    <input type="text" id="dueDate" name="dueDate" placeholder="yyyy-MM-dd" required>
    <label>
        <input type="checkbox" name="completed"> Đã hoàn thành
    </label>
    <input type="submit" value="Thêm công việc">
</form>

</body>
</html>

