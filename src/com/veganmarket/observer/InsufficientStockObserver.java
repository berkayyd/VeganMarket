// com/veganmarket/product/InsufficientStockObserver.java
package com.veganmarket.observer;

public class InsufficientStockObserver implements ProductObserver {
    @Override
    public void update(ProductUpdate update) {
        if (update.getProperty().equals("stock") && update.getProduct().getStock() <= 5) {
            System.out.println("Low stock alert for " + update.getProduct().getName());
        }
    }
}
