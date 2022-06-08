package com.example.t2009m1java.model.model;

import com.example.t2009m1java.entity.Product;
import com.example.t2009m1java.entity.myenum.ProductStatus;
import com.example.t2009m1java.model.MySqlProductModel;
import com.example.t2009m1java.model.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {
    ProductModel model;
    @BeforeEach
    void setUp() {
        model = new  MySqlProductModel();
    }

    @Test
    void save() {
        Product product = new Product();
        product.setName("Pepsi");
        product.setThumbnail("a.img");
        product.setPrice(19.99);
        product.setCategoryId(8);
        product.setDescription("Nuoc uong");
        product.setDetail("Day la phan chi tiet");
        product.setStatus(ProductStatus.ACTIVE);
        model.save(product);
    }
}