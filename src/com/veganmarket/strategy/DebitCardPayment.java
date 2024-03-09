package com.veganmarket.strategy;

//FLYWITH..
public class DebitCardPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing payment using debit card...");
    }
}
