package com.siggy.training.code.smells.orders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TagNodeTest {

    @Test
    void oneElementTree() {
        var expected = "<orders></orders>";
        var orders = new TagNode("orders");
        assertEquals(expected, orders.toString(), "orders xml");
    }

    @Test
    void treeWithAttributes() {
        var expected =
                "<orders>" +
                        "<order number='123'>" +
                        "</order>" +
                "</orders>";
        var orders = new TagNode("orders");
        var order = new TagNode("order");
        order.addAttribute("number", "123");
        orders.add(order);
        assertEquals(expected, orders.toString(), "orders xml");
    }

    @Test
    void treeWithValues() {
        var expected =
                "<orders>" +
                    "<order number='123'>" +
                    "carDoor" +
                    "</order>" +
                "</orders>";
        var orders = new TagNode("orders");
        var order = new TagNode("order");
        order.addAttribute("number", "123");
        order.addValue("carDoor");
        orders.add(order);
        assertEquals(expected, orders.toString(), "orders xml");
    }

    @Test
    void obtainValue() {
        var root = new TagNode("root");
        var expectedValue = "a value";
        root.addValue(expectedValue);
        assertEquals(expectedValue, root.getValue());
    }
}
