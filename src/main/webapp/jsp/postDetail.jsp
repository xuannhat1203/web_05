<%@ page import="com.baitap.session05.Modal.Post" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Chi tiết bài viết</title>
</head>
<body>
<%
  Post post = (Post) request.getAttribute("post");
  if (post != null) {
%>
<h2><%= post.getTitle() %></h2>
<p><strong>Tác giả:</strong> <%= post.getAuthor() %></p>
<p><strong>Ngày đăng:</strong> <%= post.getPublishDate() %></p>
<hr>
<p><%= post.getContent() %></p>
<br>
<a href="listPosts.jsp">← Quay lại danh sách</a>
<%
} else {
%>
<p>Bài viết không tồn tại.</p>
<a href="listPosts.jsp">← Quay lại danh sách</a>
<%
  }
%>
</body>
</html>

