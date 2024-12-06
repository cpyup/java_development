package com.pluralsight.NothwindTradersSpringBoot.dao;

import com.pluralsight.NothwindTradersSpringBoot.model.Product;

import java.util.List;

public interface IProductDAO {
    void add(Product product);
    List<Product> getAll();
}
