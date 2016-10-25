package com.albinsShop.controllers;

import com.albinsShop.models.Product;
import com.albinsShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by albinblent on 21/10/16.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository){
        this.repository = repository;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Product> getProducts(){
        return repository.getProducts();
    }
}
