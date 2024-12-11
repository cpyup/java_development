package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.IProductDao;
import com.pluralsight.NorthwindTradersAPI.model.Category;
import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private final IProductDao productDao;

   @Autowired
    public ProductsController(IProductDao productDao){
        this.productDao = productDao;
        /*products.add(new Product(1,"Test Prod 1",1,5));
        products.add(new Product(5,"Test Prod 2",17,5));
        products.add(new Product(30,"Test Prod 3",20,5));*/

    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productDao.getAll();
    }

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId){
        return productDao.getById(productId);
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productDao.insert(product);
    }

}
