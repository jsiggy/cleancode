package com.siggy.training.code.smells.orders;

import java.util.List;

public class Order {
    static long lastOrderId = 0L;

    private final List<Product> products;
    private final long id;

    public Order(List<Product> products) {
        this.products = products;
        this.id = ++lastOrderId;
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public long getOrderId() {
        return id;
    }
}
