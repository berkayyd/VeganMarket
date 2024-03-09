package com.veganmarket.factory;

import com.veganmarket.product.Product;
import com.veganmarket.product.trstyles.TRStyleFoodProduct;
import com.veganmarket.product.ukstyles.UKStyleBeautyProduct;
import com.veganmarket.product.ukstyles.UKStyleClothingProduct;

// ukPizzaStore
public class UKproductFactory extends ProductFactory {
    @Override
    public Product createProduct(String type, String name, double price, int stock) {
        if (type.equals("food"))
            return new TRStyleFoodProduct(name, price, stock);
        if (type.equals("clothing"))
            return new UKStyleClothingProduct(name, price, stock);
        if (type.equals("beauty"))
            return new UKStyleBeautyProduct(name, price, stock);

        return null;

    }
}
