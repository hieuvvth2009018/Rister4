package com.example.t2009m1java.controller.product;

import com.example.t2009m1java.entity.Product;
import com.example.t2009m1java.entity.myenum.ProductStatus;
import com.example.t2009m1java.model.CategoryModel;
import com.example.t2009m1java.model.MySqlCategoryModel;
import com.example.t2009m1java.model.MySqlProductModel;
import com.example.t2009m1java.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProductServlet extends HttpServlet {
    private CategoryModel categoryModel;
    private ProductModel productModel;

    public UpdateProductServlet() {
        this.categoryModel = new MySqlCategoryModel();
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
            req.setAttribute("action", 2);
            req.setAttribute("categories", categoryModel.findAll());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/admin/error/500.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            // lấy giá trị từ form gửi lên.
            String name = req.getParameter("name");
            int id = Integer.parseInt(req.getParameter("id"));
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            String description = req.getParameter("description");
            String detail = req.getParameter("detail");
            String thumbnail = req.getParameter("thumbnail");
            double price = Double.parseDouble(req.getParameter("price"));
            int status = Integer.parseInt(req.getParameter("status"));
            Product product = productModel.findById(id);
            // Khởi tạo đối tượng account từ thông tin truyền lên.
            product = Product.ProductBuilder.aProduct()
                    .withName(name)
                    .withCategoryId(categoryId)
                    .withDescription(description)
                    .withDetail(detail)
                    .withThumbnail(thumbnail)
                    .withPrice(price)
                    .withStatus(ProductStatus.of(status))
                    .build();
            if (product.isValid()) {
                boolean result = productModel.update(id, product);
                if (result) {
                    resp.sendRedirect("/admin/products/list");
                } else {
                    throw new Exception("Can't update product");
                }
            } else {
                req.setAttribute("action", 2);
                req.setAttribute("errors", product.getErrors());
                req.setAttribute("categories", categoryModel.findAll());
                req.setAttribute("product", product);
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
        }
    }
}
