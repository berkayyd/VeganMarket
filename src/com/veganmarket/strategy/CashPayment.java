package com.veganmarket.strategy;

//FLYWITH..
public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing payment using cash...");
    }
}
