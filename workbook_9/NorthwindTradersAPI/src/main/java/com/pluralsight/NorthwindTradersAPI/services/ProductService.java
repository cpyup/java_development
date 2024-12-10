package com.pluralsight.NorthwindTradersAPI.services;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private final IProductDao productDao;

    @Autowired
    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }


    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public Product getProductById(int productId) {
        return productDao.getById(productId);
    }
}
