package com.albinsShop.repository;

import com.albinsShop.models.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by albinblent on 21/10/16.
 */
@Component
public class ProductRepository {

    private List<Product> products;
    private final AtomicLong counter = new AtomicLong();

    @PostConstruct
    public void initData(){
        products = new ArrayList<>();
        products.add(new Product(counter.incrementAndGet(), "Sylt", 20, "Sylt med smak av hallon"));
    }

    public List<Product> getProducts(){
        return products;
    }
}
