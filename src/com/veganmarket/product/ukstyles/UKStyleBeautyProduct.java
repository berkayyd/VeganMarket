package com.veganmarket.product.ukstyles;

import com.veganmarket.product.BeautyProduct;

public class UKStyleBeautyProduct extends BeautyProduct {

    public UKStyleBeautyProduct(String name, double price, int stock) {
        super(name, price, stock);
        description =  name + " - $" + price;    }
}