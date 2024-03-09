package com.veganmarket.checkout;

import com.veganmarket.product.Product;
import com.veganmarket.strategy.PaymentStrategy;

//DUCK
public class CheckoutProcess {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void initiatePayment(Product[] products) {
        System.out.println("Starting payment process ...");

        // Process payment using the selected strategy
        paymentStrategy.processPayment();

//         Update stock for each product in the array
        for (Product product : products) {
            product.setStock(product.getStock());
        }

        System.out.println("Payment successful!");
    }
}
