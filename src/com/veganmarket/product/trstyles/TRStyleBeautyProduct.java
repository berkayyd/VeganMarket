package com.veganmarket.product.trstyles;

import com.veganmarket.product.BeautyProduct;

public class TRStyleBeautyProduct extends BeautyProduct {

    public TRStyleBeautyProduct(String name, double price, int stock) {
        super(name, price, stock);
        description = name + " - $" + price;
    }

}