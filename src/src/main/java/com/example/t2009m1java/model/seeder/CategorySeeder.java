package com.example.t2009m1java.model.seeder;

import com.example.t2009m1java.entity.Category;
import com.example.t2009m1java.model.CategoryModel;
import com.example.t2009m1java.model.MySqlCategoryModel;

public class CategorySeeder {
    private CategoryModel categoryModel;

    public CategorySeeder() {
        this.categoryModel = new MySqlCategoryModel();
    }

    public void seedData() {
//        categoryModel.save(Category.CategoryBuilder.aCategory())
//                .name("Bánh").build();
    }
}
