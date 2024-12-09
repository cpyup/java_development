package com.pluralsight.NothwindTradersSpringBoot4.dao.impl;

import com.pluralsight.NothwindTradersSpringBoot4.dao.interfaces.IProductDAO;
import com.pluralsight.NothwindTradersSpringBoot4.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class SimpleIProductDAO implements IProductDAO {
    private final List<Product> products;

    public SimpleIProductDAO() {
        this.products = new ArrayList<>();
        products.add(new Product(123,"Test1", 1,3.5));
        products.add(new Product(456,"Test2", 1,6));
        products.add(new Product(789,"Test3", 1,12.85));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
