package com.pluralsight.NothwindTradersSpringBoot.services;

import com.pluralsight.NothwindTradersSpringBoot.dao.ProductDAO;
import com.pluralsight.NothwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public void addProduct(Product product){
        productDAO.add(product);
    }

    public List<Product> getAll(){
        return productDAO.getAll();
    }
}
