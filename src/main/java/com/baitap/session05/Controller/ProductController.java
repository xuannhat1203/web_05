package com.baitap.session05.Controller;

import com.baitap.session05.Modal.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    private String message;
    public static List<Product> productList = new ArrayList<>();
    public void init() {
        productList.add(new Product(1, "Laptop Dell", 15000000, "Laptop văn phòng hiệu năng ổn định"));
        productList.add(new Product(2, "Điện thoại iPhone 14", 21000000, "Smartphone cao cấp của Apple"));
        productList.add(new Product(3, "Tai nghe Bluetooth", 500000, "Tai nghe không dây tiện lợi"));
        productList.add(new Product(4, "Chuột Logitech", 300000, "Chuột không dây độ nhạy cao"));
    }

       public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("jsp/productList.jsp").forward(request,response);
    }

    public void destroy() {
    }
}