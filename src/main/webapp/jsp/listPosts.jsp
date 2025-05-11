<%@ page import="java.util.List" %>
<%@ page import="com.baitap.session05.Modal.Post" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Danh sách bài viết</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px auto; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2 style="text-align:center;">Danh sách bài viết</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>Ngày đăng</th>
        <th>Chi tiết</th>
    </tr>
    <%
        List<Post> posts = (List<Post>) request.getAttribute("postList");
        if (posts != null) {
            for (Post p : posts) {
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getTitle() %></td>
        <td><%= p.getAuthor() %></td>
        <td><%= p.getPublishDate() %></td>
        <td>
            <form action="BlogController" method="get">
                <input type="hidden" name = "action" value="showDetail">
                <input type="hidden" name="id" value="<%= p.getId()%>">
                <input type="submit"> Xem chi tiet
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="5" style="text-align:center;">Không có bài viết nào.</td></tr>
    <% } %>
</table>
</body>
</html>
