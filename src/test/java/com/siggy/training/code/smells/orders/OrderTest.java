package com.siggy.training.code.smells.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
	private Product product;
	private Order order;

	@BeforeEach
	public void createProduct() {
		product = new Product("productID", "firstProduct", Color.WHITE, 9.99F);
		order = new Order("0");
	}

	@Test
    void addProductIncrementsCount() {
		assertEquals(0, order.getProductCount());
		order.addProduct(product);
		assertEquals(1, order.getProductCount());
	}

	@Test
    void addProductsRetainsProducts() {
		order.addProduct(product);
        Product secondProduct = new Product("productID", "secondProduct", Color.WHITE, 9.99F);
		order.addProduct(secondProduct);
		assertEquals("firstProduct", order.getProduct(0).getName());
		assertEquals("secondProduct", order.getProduct(1).getName());
	}
}
