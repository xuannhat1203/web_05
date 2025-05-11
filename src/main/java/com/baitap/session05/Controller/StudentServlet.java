package com.baitap.session05.Controller;

import com.baitap.session05.Modal.Student;
import com.baitap.session05.Service.StudentService;
import com.baitap.session05.Service.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImp();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("jsp/login.jsp");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        int page = 1;
        int size = 5;
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }

        List<Student> students = studentService.getStudentsByPage(page, size);

        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Optional<Student> studentOpt = students.stream().filter(s -> s.getId() == id).findFirst();
            if (studentOpt.isPresent()) {
                Student student = studentOpt.get();
                request.setAttribute("student", student);
                request.setAttribute("idStudent", student.getId());
                request.setAttribute("nameStudent", student.getName());
                request.setAttribute("ageStudent", student.getAge());
                request.setAttribute("addressStudent", student.getAddress());
                request.getRequestDispatcher("jsp/editStudent.jsp").forward(request, response);
                return;
            }
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            studentService.deleteStudent(id);
            students = studentService.getStudentsByPage(page, size);
        }
        if (students.isEmpty()) {
            request.setAttribute("message", "Không có dữ liệu.");
        }
        int totalStudents = studentService.getTotalStudentCount();
        int totalPages = (int) Math.ceil((double) totalStudents / size);
        request.setAttribute("totalPages", totalPages);

        request.setAttribute("students", students);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("jsp/studentlist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        int page = 1;
        int size = 5;
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }
        Student updatedStudent = new Student(id, name, age, address);
        studentService.updateStudent(updatedStudent);
        List<Student> students = studentService.getStudentsByPage(page, size);
        int totalStudents = studentService.getTotalStudentCount();
        int totalPages = (int) Math.ceil((double) totalStudents / size);
        request.setAttribute("students", students);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.getRequestDispatcher("jsp/studentlist.jsp").forward(request, response);
    }

}
