package com.pluralsight.NothwindTradersSpringBoot.dao.impl;

import com.pluralsight.NothwindTradersSpringBoot.dao.interfaces.IProductDAO;
import com.pluralsight.NothwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleIProductDAO implements IProductDAO {
    private final List<Product> products;

    public SimpleIProductDAO() {
        this.products = new ArrayList<>();
        products.add(new Product(123,"Test1", "TestCat",3.5));
        products.add(new Product(456,"Test2", "TestCat",6));
        products.add(new Product(789,"Test3", "TestCat",12.85));
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
