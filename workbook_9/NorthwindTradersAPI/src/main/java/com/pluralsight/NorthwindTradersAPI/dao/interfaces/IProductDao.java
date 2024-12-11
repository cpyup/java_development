package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.model.Product;

import java.util.List;

public interface IProductDao {

    List<Product> getAll();

    Product getById(int productId);
    Product insert(Product product);
}
