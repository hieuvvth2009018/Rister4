package com.example.t2009m1java.model;

import com.example.t2009m1java.entity.Product;

import java.util.List;

public interface ProductModel {
    boolean save(Product obj);
    boolean update(int id, Product updateObj);
    boolean delete(int id);
    List<Product> findAll();
    Product findById(int id);
    Product findByProductName(String productName);
}
