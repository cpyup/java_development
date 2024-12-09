package com.pluralsight.NothwindTradersSpringBoot4.services;

import com.pluralsight.NothwindTradersSpringBoot4.dao.interfaces.IProductDAO;
import com.pluralsight.NothwindTradersSpringBoot4.model.Product;
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