package com.veganmarket.decorator;

import com.veganmarket.product.Product;

public class DiscountDecorator extends ProductDecorator{

    public DiscountDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Discounted";
    }
}
