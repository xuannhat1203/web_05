package com.baitap.session05.Controller;

import com.baitap.session05.Modal.Post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BlogController", value = "/BlogController")
public class BlogController extends HttpServlet {
    private String message;
    public static List<Post> postList = new ArrayList<Post>();
    public void init() {
        postList.add(new Post(1, "Java Basics", "Introduction to Java programming.", "Alice", "2025-05-10"));
        postList.add(new Post(2, "OOP in Java", "Understanding Object-Oriented Programming.", "Bob", "2025-05-11"));
        postList.add(new Post(3, "Collections Framework", "Working with List, Set, and Map.", "Charlie", "2025-05-12"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("showDetail")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Optional<Post> post = postList.stream().filter(p -> p.getId() == id).findFirst();
                if (post.isPresent()) {
                    request.setAttribute("post", post.get());
                    request.getRequestDispatcher("jsp/postDetail.jsp").forward(request, response);
                }
            }
        }
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("jsp/listPosts.jsp").forward(request,response);
    }

    public void destroy() {
    }
}