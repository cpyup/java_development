package com.pluralsight.NothwindTradersSpringBoot.services;

import com.pluralsight.NothwindTradersSpringBoot.dao.IProductDAO;
import com.pluralsight.NothwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private final IProductDAO IProductDAO;

    @Autowired
    public ProductService(IProductDAO IProductDAO){
        this.IProductDAO = IProductDAO;
    }

    public void addProduct(Product product){
        IProductDAO.add(product);
    }

    public List<Product> getAll(){
        return IProductDAO.getAll();
    }
}
