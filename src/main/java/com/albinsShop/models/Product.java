package com.albinsShop.models;

/**
 * Created by albinblent on 21/10/16.
 */
public class Product {

    private final long id;
    private final String name;
    private final int price;
    private final String description;

    public Product(long id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }



}
