<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
<h2>Edit Task</h2>
<form action="TaskController" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${task.id}">

    <label>Mô tả:</label>
    <input type="text" name="description" value="${task.description}" required><br>

    <label>Hạn chót:</label>
    <input type="date" name="dueDate" value="${task.dueDate}" required><br>

    <label>Hoàn thành:</label>
    <input type="checkbox" name="completed" ${task.completed ? "checked" : ""}><br>

    <input type="submit" value="Cập nhật">
</form>

</body>
</html>

