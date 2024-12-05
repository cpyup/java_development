package com.pluralsight.NothwindTradersSpringBoot.dao;

import com.pluralsight.NothwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDAO {
    void add(Product product);
    List<Product> getAll();
}
