package com.veganmarket.observer;

import com.veganmarket.product.Product;

public class ProductUpdate {
    private String property;
    private Product product;


    public ProductUpdate(String property, Product product) {
        this.property = property;
        this.product = product;
    }

    public String getProperty() {
        return property;
    }

    public Product getProduct() {
        return product;
    }
}