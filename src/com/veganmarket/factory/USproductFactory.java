package com.veganmarket.factory;

import com.veganmarket.product.Product;
import com.veganmarket.product.usstyles.USStyleBeautyProduct;
import com.veganmarket.product.usstyles.USStyleFoodProduct;

//usPizzaStore
public class USproductFactory extends ProductFactory{
    @Override
    public Product createProduct(String type, String name, double price, int stock) {
        if (type.equals("food"))
            return new USStyleFoodProduct(name, price, stock);
        if (type.equals("clothing"))
            return new USStyleFoodProduct(name, price, stock);
        if (type.equals("beauty"))
            return new USStyleBeautyProduct(name, price, stock);
        return null;
    }
}
