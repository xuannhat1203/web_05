<%@ page import="com.baitap.session05.Modal.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa liên hệ</title>
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
<%
    Contact contact = (Contact) request.getAttribute("contact");
    if (contact == null) {
%>
<p style="text-align: center;">Không tìm thấy liên hệ cần sửa.</p>
<%
} else {
%>
<h2 style="text-align:center;">Chỉnh sửa liên hệ</h2>
<form action="ContactController" method="post">
    <input type="hidden" name="id" value="<%= contact.getId() %>">

    <label for="firstName">Họ:</label>
    <input type="text" name="firstName" id="firstName" value="<%= contact.getFirstName() %>" required>

    <label for="lastName">Tên:</label>
    <input type="text" name="lastName" id="lastName" value="<%= contact.getLastName() %>" required>

    <label for="email">Email:</label>
    <input type="email" name="email" id="email" value="<%= contact.getEmail() %>" required>

    <label for="phone">Số điện thoại:</label>
    <input type="text" name="phone" id="phone" value="<%= contact.getPhone() %>" required>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${idContact}">
    <input type="submit" value="Cập nhật liên hệ">
</form>
<%
    }
%>
</body>
</html>
