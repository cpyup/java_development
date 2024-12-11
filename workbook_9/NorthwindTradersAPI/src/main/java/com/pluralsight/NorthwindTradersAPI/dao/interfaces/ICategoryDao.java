package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.model.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> getAll();

    Category getById(int categoryId);
    Category insert(Category category);
}
