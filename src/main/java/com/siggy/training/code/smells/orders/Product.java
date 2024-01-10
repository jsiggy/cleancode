package com.siggy.training.code.smells.orders;

import java.math.BigDecimal;

public class Product {
    private final int id;
    private final BigDecimal price;
    private final String name;
    private final int size;

    public Product(int id, BigDecimal price, String name, int size) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.size = size;
    }

    public Product(int id, BigDecimal price, String name) {
        this(id, price, name, ProductSize.NOT_APPLICABLE);
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
