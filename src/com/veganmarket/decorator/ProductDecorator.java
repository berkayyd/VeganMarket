package com.veganmarket.decorator;

import com.veganmarket.product.Product;

//condiment decorator
public abstract class ProductDecorator extends Product {
    public ProductDecorator(Product decoratedProduct) {
        super(decoratedProduct.getName(), decoratedProduct.getPrice(), decoratedProduct.getStock());
        description = decoratedProduct.getDescription();
    }

}
