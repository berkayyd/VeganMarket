package com.veganmarket.product;

import com.veganmarket.observer.ProductUpdate;
import com.veganmarket.subject.Subject;
import com.veganmarket.observer.ProductObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Product implements Subject {
    private String name;

    public String description = "unknown product";
    private double oldPrice;
    private double price;
    private int stock;
    private final List<ProductObserver> observers;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.oldPrice = price; // Set the initial old price
        this.price = price;
        this.stock = stock;
        this.observers = new ArrayList<>();
    }

    public String getDescription(){
        return description;
    };

    public void addObserver(ProductObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ProductObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(ProductUpdate update) {
        for (ProductObserver observer : observers) {
            observer.update(update);
        }
    }

    public String getName() {
        return name;
    }

    public double getOldPrice(){
        return oldPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.oldPrice = this.price;
        this.price = price;
        notifyObservers(new ProductUpdate("price", this));
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyObservers(new ProductUpdate("stock", this));
    }

}