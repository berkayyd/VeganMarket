package com.veganmarket.product.usstyles;

import com.veganmarket.product.ClothingProduct;

public class USStyleClothingProduct extends ClothingProduct {

    public USStyleClothingProduct(String name, double price, int stock) {
        super(name, price, stock);
        description = name + " - $" + price;
    }
}