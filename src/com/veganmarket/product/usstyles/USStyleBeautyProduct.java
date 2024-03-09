package com.veganmarket.product.usstyles;

import com.veganmarket.product.BeautyProduct;

public class USStyleBeautyProduct extends BeautyProduct {

    public USStyleBeautyProduct(String name, double price, int stock) {
        super(name, price, stock);
        description = name + " - $" + price;
    }
}