package com.veganmarket.product.trstyles;

import com.veganmarket.product.ClothingProduct;

public class TRStyleClothingProduct extends ClothingProduct {

    public TRStyleClothingProduct(String name, double price, int stock) {
        super(name, price, stock);
        description =  name + " - $" + price;
    }
}