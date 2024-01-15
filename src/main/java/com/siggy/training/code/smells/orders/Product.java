package com.siggy.training.code.smells.orders;

public class Product {
    private final String id;
    private final String name;
    private final Color color;
    private final float price;
    private final ProductSize size;

    public Product(String id, String name, Color color, float price) {
        this(id, name, color, price, ProductSize.NOT_APPLICABLE);
    }

    public Product(String id, String name, Color color, float price, ProductSize size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.size = size;
    }

    public String getID() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    public ProductSize getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

}
