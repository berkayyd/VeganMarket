// com/veganmarket/product/Subject.java
package com.veganmarket.subject;

import com.veganmarket.observer.ProductObserver;
import com.veganmarket.observer.ProductUpdate;

public interface Subject {
    void addObserver(ProductObserver observer);
    void removeObserver(ProductObserver observer);
    void notifyObservers(ProductUpdate update);
}