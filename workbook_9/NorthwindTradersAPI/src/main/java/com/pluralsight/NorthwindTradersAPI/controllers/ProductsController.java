package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private List<Product> products;

    public ProductsController(){
        products = new ArrayList<>();
        products.add(new Product(1,"Test Prod 1",1,5));
        products.add(new Product(5,"Test Prod 2",17,5));
        products.add(new Product(30,"Test Prod 3",20,5));
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return products;
    }

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId){
        for(Product product : products){
            if(product.getProductId() == productId){
                return product;
            }
        }
        return null;
    }

}
