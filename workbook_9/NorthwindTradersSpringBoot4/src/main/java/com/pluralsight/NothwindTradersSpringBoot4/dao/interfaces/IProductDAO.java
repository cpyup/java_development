package com.pluralsight.NothwindTradersSpringBoot4.dao.interfaces;

import com.pluralsight.NothwindTradersSpringBoot4.model.Product;

import java.util.List;

public interface IProductDAO {
    void add(Product product);
    List<Product> getAll();
}
