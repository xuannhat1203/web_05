<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Danh sách công việc</title>
  <style>
    table {
      border-collapse: collapse;
      width: 80%;
      margin: 20px auto;
    }
    th, td {
      border: 1px solid #999;
      padding: 8px 12px;
      text-align: center;
    }
    th {
      background-color: #f2f2f2;
    }
    .actions form {
      display: inline;
    }
    .add-button {
      display: block;
      width: 200px;
      margin: 20px auto;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      text-align: center;
      text-decoration: none;
      border-radius: 5px;
    }
  </style>
</head>
<body>

<h2 style="text-align: center;">Danh sách công việc</h2>

<a class="add-button" href="TaskController?action=create">➕ Thêm công việc mới</a>

<table>
  <tr>
    <th>ID</th>
    <th>Mô tả</th>
    <th>Hạn chót</th>
    <th>Trạng thái</th>
    <th colspan="2">Hành động</th>
  </tr>
  <c:forEach var="task" items="${taskList}">
    <tr>
      <td>${task.id}</td>
      <td>${task.description}</td>
      <td>${task.dueDate}</td>
      <td>
        <c:choose>
          <c:when test="${task.completed}">✔ Hoàn thành</c:when>
          <c:otherwise>✘ Chưa hoàn thành</c:otherwise>
        </c:choose>
      </td>
      <td class="actions">
        <form action="TaskController" method="get">
          <input type="hidden" name="action" value="edit"/>
          <input type="hidden" name="id" value="${task.id}"/>
          <input type="submit" value="🗑 Sửa"/>
        </form>
      </td>
      <td class="actions">
        <form action="TaskController" method="post">
          <input type="hidden" name="action" value="delete"/>
          <input type="hidden" name="id" value="${task.id}"/>
          <input type="submit" value="🗑 Xóa"/>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
