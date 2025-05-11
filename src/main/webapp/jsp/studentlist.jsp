<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuann
  Date: 5/9/2025
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sinh viên</title>
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
        a.button {
            padding: 4px 8px;
            margin: 2px;
            text-decoration: none;
            color: white;
            border-radius: 4px;
        }
        a.edit {
            background-color: #4CAF50;
        }
        a.delete {
            background-color: #f44336;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Danh sách sinh viên</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
    <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
            <td>
                <form action="StudentServlet" method="get">
                    <input type="hidden" name="action" value="edit"/>
                    <input type="hidden" name="id" value="${student.id}"/>
                    <button class="button edit" type="submit">Sửa</button>
                </form>
                <form action="StudentServlet">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${student.id}"/>
                    <button class="button delete" type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <c:if test="${currentPage > 1}">
        <a href="StudentServlet?page=${currentPage - 1}">Previous</a>
    </c:if>

    <c:if test="${currentPage < totalPages}">
        <a href="StudentServlet?page=${currentPage + 1}">Next</a>
    </c:if>

</table>

</body>
</html>

