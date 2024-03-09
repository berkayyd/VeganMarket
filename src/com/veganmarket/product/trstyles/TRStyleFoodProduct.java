package com.veganmarket.product.trstyles;

import com.veganmarket.product.FoodProduct;

public class TRStyleFoodProduct extends FoodProduct {

    public TRStyleFoodProduct(String name, double price, int stock) {
        super(name, price, stock);
        description =  name + " - $" + price;
    }
}