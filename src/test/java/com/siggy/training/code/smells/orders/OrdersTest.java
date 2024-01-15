package com.siggy.training.code.smells.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdersTest {
	private Orders orders;

	@BeforeEach
    void createOrders() {
		orders = new Orders();
	}

	@Test
    void addOrderIncrementsCount() {
		assertEquals(0, orders.getOrderCount());
		orders.addOrder(new Order("0"));
		assertEquals(1, orders.getOrderCount());
	}

	@Test
    void ordersRetainedInOrder() {
		orders.addOrder(new Order("0"));
		orders.addOrder(new Order("1"));
		assertEquals("0", orders.getOrder(0).getOrderId());
		assertEquals("1", orders.getOrder(1).getOrderId());
	}
}
