package com.example.t2009m1java.controller.category;

import com.example.t2009m1java.model.CategoryModel;
import com.example.t2009m1java.model.MySqlCategoryModel;
import com.example.t2009m1java.model.MySqlProductModel;
import com.example.t2009m1java.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    public ListCategoryServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryModel.findAll());
        req.getRequestDispatcher("/admin/categories/list.jsp").forward(req, resp);
    }
}
