package com.veganmarket.strategy;

//FLYWITH..
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing payment using credit card...");
    }
}
