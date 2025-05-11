<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Form Thông Tin Cá Nhân</title>
</head>
<body>
<h2>Form Nhập Thông Tin Cá Nhân</h2>
<form action="${pageContext.request.contextPath}/SubmitForm" method="post">
    <label for="name">Tên:</label><br>
    <input type="text" id="name" name="name" required><br><br>
    <label for="age">Tuổi:</label><br>
    <input type="number" id="age" name="age" min="0" required><br><br>
    <label for="address">Địa chỉ:</label><br>
    <textarea id="address" name="address" rows="4" cols="30" required></textarea><br><br>
    <button type="submit">Gửi</button>
</form>
<c:if test="${message!= null}" >
    <h5>${message}</h5>
</c:if>
</body>
</html>

