package com.baitap.session05.Controller;import java.io.*;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginForm", value = "/LoginForm")
public class LoginForm extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (Objects.equals(username, "admin") && Objects.equals(password, "123456789")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("/StudentServlet");
        } else {
            request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}