package com.veganmarket.product.ukstyles;

import com.veganmarket.product.FoodProduct;

public class UKStyleFoodProduct extends FoodProduct {

    public UKStyleFoodProduct(String name, double price, int stock) {
        super(name, price, stock);
        description =  name + " - $" + price;    }
}