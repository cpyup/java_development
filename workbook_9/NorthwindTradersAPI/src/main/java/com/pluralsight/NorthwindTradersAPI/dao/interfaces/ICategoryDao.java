package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.model.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> getAll();

    Category getById(int categoryId);
    Category addCategory(Category category);
    void update(int id, Category category);
}
