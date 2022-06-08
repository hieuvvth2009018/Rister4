package com.example.t2009m1java.controller.product;

import com.example.t2009m1java.entity.Product;
import com.example.t2009m1java.model.MySqlProductModel;
import com.example.t2009m1java.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailProductServlet extends HttpServlet {
    private ProductModel productModel;

    public DetailProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = productModel.findById(id);
            if (product == null) {
                req.setAttribute("message", "Product is not found!");
                req.getRequestDispatcher("/admin/error/404.jsp");
                return;
            }
            req.setAttribute("product", product);
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/admin/error/500.jsp");
        }
    }
}
