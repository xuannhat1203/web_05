package com.baitap.session05.Controller;

import com.baitap.session05.Modal.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TaskController", value = "/TaskController")
public class TaskController extends HttpServlet {
    public static List<Task> taskList = new ArrayList<Task>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            request.getRequestDispatcher("jsp/addForm.jsp").forward(request, response);
            return;
        }else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Task task : taskList) {
                if (task.getId() == id) {
                    request.setAttribute("task", task);
                    request.getRequestDispatcher("jsp/taskForm.jsp").forward(request, response);
                    return;
                }
            }
        }

        request.setAttribute("taskList", taskList);
        request.getRequestDispatcher("jsp/taskList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String description = request.getParameter("description");
            String dueDate = request.getParameter("dueDate");
            boolean completed = request.getParameter("completed") != null;
            int newId = taskList.size() + 1;
            Task newTask = new Task(newId, description, dueDate, completed);
            taskList.add(newTask);
            response.sendRedirect("TaskController");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String description = request.getParameter("description");
            String dueDate = request.getParameter("dueDate");
            boolean completed = request.getParameter("completed") != null;

            for (Task task : taskList) {
                if (task.getId() == id) {
                    task.setDescription(description);
                    task.setDueDate(dueDate);
                    task.setCompleted(completed);
                    break;
                }
            }
            response.sendRedirect("TaskController");
        }

        else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            taskList.removeIf(task -> task.getId() == id);
            response.sendRedirect("TaskController");
        }
    }


}