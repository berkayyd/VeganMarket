package com.veganmarket.decorator;

import com.veganmarket.product.Product;

public class NewProductDecorator extends ProductDecorator {
    public NewProductDecorator(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", New product";
    }
}
