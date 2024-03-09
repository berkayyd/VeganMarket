package com.veganmarket.observer;

public class DiscountObserver implements ProductObserver {
    @Override
    public void update(ProductUpdate update) {
        if (update.getProperty().equals("price") && update.getProduct().getPrice() < update.getProduct().getOldPrice()) {
            System.out.println("Discount applied for " + update.getProduct().getName());
        }
    }
}