package com.siggy.training.code.smells.orders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Orders implements Iterable<Order> {
    private final List<Order> lineItems = new ArrayList<>();

    public void addOrder(Order order) {
        lineItems.add(order);
    }

    public int getOrderCount() {
        return lineItems.size();
    }

    public Order getOrder(int index) {
        return lineItems.get(index);
    }

    @Override
    public Iterator<Order> iterator() {
        return lineItems.iterator();
    }
}
