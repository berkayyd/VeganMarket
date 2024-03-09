package com.veganmarket.decorator;

import com.veganmarket.product.Product;

public class BestSellerDecorator extends ProductDecorator {
    public BestSellerDecorator(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Best Seller";
    }
}
