package com.siggy.training.code.smells.orders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdersWriterTest {

    private Product fireTruck = new Product("f1234", "Fire Truck", Color.RED, 8.95f, ProductSize.MEDIUM);

    private Product toyConvertible = new Product("p1112", "Toy Porsche Convertible", Color.PINK, 230.00f);

    @Test
    void noOrders() {
        var writer = new OrdersWriter(new Orders());

        var expectedResult =
                "<orders>" +
                        "</orders>";

        assertEquals(expectedResult, writer.getContents());
    }

    @Test
    void oneOrderNoProduct() {
        var orders = new Orders();
        var orderId = "321";
        var order = new Order(orderId);
        orders.addOrder(order);

        var writer = new OrdersWriter(orders);

        var expectedResult =
                "<orders>" +
                        "<order id='321'>" +
                        "</order>" +
                        "</orders>";

        assertEquals(expectedResult, writer.getContents());
    }

    @Test
    void oneOrderOneProduct() {
        var orders = new Orders();
        var orderId = "321";
        var order = new Order(orderId);
        order.addProduct(fireTruck);
        orders.addOrder(order);

        assertEquals(1, orders.getOrderCount());
        assertEquals(1, order.getProductCount());

        var writer = new OrdersWriter(orders);

        var expectedResult =
                "<orders>" +
                        "<order id='321'>" +
                        "<product id='f1234' color='red' size='medium'>" +
                        "<price currency='USD'>" +
                        "8.95" +
                        "</price>" +
                        "Fire Truck" +
                        "</product>" +
                        "</order>" +
                        "</orders>";

        assertEquals(expectedResult, writer.getContents());
    }

    @Test
    void oneOrderTwoProducts() {
        var orders = new Orders();
        var orderId = "321";
        var order = new Order(orderId);
        order.addProduct(fireTruck);
        order.addProduct(toyConvertible);
        orders.addOrder(order);

        assertEquals(1, orders.getOrderCount());
        assertEquals(2, order.getProductCount());

        var writer = new OrdersWriter(orders);

        var expectedResult =
                "<orders>" +
                        "<order id='321'>" +
                        "<product id='f1234' color='red' size='medium'>" +
                        "<price currency='USD'>" +
                        "8.95" +
                        "</price>" +
                        "Fire Truck" +
                        "</product>" +
                        "<product id='p1112' color='pink'>" +
                        "<price currency='USD'>" +
                        "230.0" +
                        "</price>" +
                        "Toy Porsche Convertible" +
                        "</product>" +
                        "</order>" +
                        "</orders>";

        assertEquals(expectedResult, writer.getContents());
    }
}
