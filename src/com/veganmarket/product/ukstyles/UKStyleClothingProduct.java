package com.veganmarket.product.ukstyles;

import com.veganmarket.product.ClothingProduct;

public class UKStyleClothingProduct extends ClothingProduct {

    public UKStyleClothingProduct(String name, double price, int stock) {
        super(name, price, stock);
        description =  name + " - $" + price;    }
}