package com.example.t2009m1java.model.model;

import com.example.t2009m1java.entity.Category;
import com.example.t2009m1java.entity.myenum.CategoryStatus;
import com.example.t2009m1java.model.CategoryModel;
import com.example.t2009m1java.model.MySqlCategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MySqlCategoryModelTest {
    private CategoryModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlCategoryModel();
    }

    @Test
    void save() {
        Category category = new Category();
        category.setName("Kẹo");
        category.setStatus(CategoryStatus.ACTIVE);
        model.save(category);
    }
}