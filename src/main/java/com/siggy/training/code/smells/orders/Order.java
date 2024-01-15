package com.siggy.training.code.smells.orders;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private List<Product> products = new ArrayList<>();

    public Order(String orderId) {
        id = orderId;
    }

    public void addProduct(Product productToAdd) {
        products.add(productToAdd);
    }

    public Object getOrderId() {
        return id;
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public List<Product> getProducts() {
        return products;
    }
}
