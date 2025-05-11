<%@ page import="java.util.List" %>
<%@ page import="com.baitap.session05.Modal.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Danh sách liên hệ</title>
    <style>
        table {
            width: 80%;
            margin: 30px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px 12px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #f2f2f2;
        }
        h2 {
            text-align: center;
        }
        .add-button {
            display: block;
            width: 150px;
            margin: 0 auto 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Danh sách liên hệ</h2>
<div class="add-button">
    <a href="ContactController?action=add">➕ Thêm liên hệ mới</a>
</div>
<table>
    <tr>
        <th>ID</th>
        <th>Họ</th>
        <th>Tên</th>
        <th>Email</th>
        <th>SĐT</th>
        <th colspan="2">Hành động</th>
    </tr>
    <%
        List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
        if (contacts != null && !contacts.isEmpty()) {
            for (Contact c : contacts) {
    %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getFirstName() %></td>
        <td><%= c.getLastName() %></td>
        <td><%= c.getEmail() %></td>
        <td><%= c.getPhone() %></td>
        <td>
            <form action="ContactController" method="get">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="<%= c.getId() %>">
                <input type="submit" value="Sửa">
            </form>
            <form action="ContactController" method="post">
                <input type="hidden" name="id" value="<%= c.getId() %>">
                <input type="submit" name="action" value="delete" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="6" style="text-align:center;">Chưa có liên hệ nào.</td>
    </tr>
    <% } %>
</table>
</body>
</html>
