package com.baitap.session05.Controller;

import com.baitap.session05.Modal.Categories;
import com.baitap.session05.Service.CategoriesService;
import com.baitap.session05.Service.CategoriesServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoriesController", value = "/CategoriesController")
public class CategoriesController extends HttpServlet {
    private final CategoriesService categoriesService;

    public CategoriesController() {
        categoriesService = new CategoriesServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllCategories(request, response);
        }
    }

    public void findAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categories> listCategories = categoriesService.findAll();
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("jsp/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Categories catalog = new Categories();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setDescription(request.getParameter("description"));
            catalog.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = categoriesService.save(catalog);
            if (result) {
                findAllCategories(request, response);
            } else {
                request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
            }
        }
    }
}