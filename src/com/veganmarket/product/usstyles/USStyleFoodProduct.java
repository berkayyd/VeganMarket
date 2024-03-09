package com.veganmarket.product.usstyles;

import com.veganmarket.product.FoodProduct;

public class USStyleFoodProduct extends FoodProduct {

    public USStyleFoodProduct(String name, double price, int stock) {
        super(name, price, stock);
        description = name + " - $" + price;
    }
}
