package com.baitap.session05.Controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SubmitForm", value = "/SubmitForm")
public class SubmitForm extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        if (!username.isEmpty() && !address.isEmpty() && age > 0 && age <= 100) {
            request.setAttribute("username", username);
            request.setAttribute("age", age);
            request.setAttribute("address", address);
            request.getRequestDispatcher("jsp/view.jsp").forward(request,response);
        }else {
            message = "Không được để trống thông tin";
            request.setAttribute("message", message);
            request.getRequestDispatcher("jsp/studentForm.jsp").forward(request,response);
        }
    }

    public void destroy() {
    }
}