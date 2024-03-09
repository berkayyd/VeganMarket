package com.veganmarket.factory;

import com.veganmarket.product.Product;

//pizzaStore
public abstract class ProductFactory {
    public abstract Product createProduct(String type, String name , double price, int stock);
}
