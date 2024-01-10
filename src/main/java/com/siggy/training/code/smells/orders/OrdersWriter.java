package com.siggy.training.code.smells.orders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class OrdersWriter {
    private final Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuilder contents = new StringBuilder();
        contents.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            contents.append("\n  <order>");
            contents.append(" id='");
            contents.append(order.getOrderId());
            contents.append("'>");
            for (int j = 0; j < order.getProductCount(); j++) {
                Product product = order.getProduct(j);
                contents.append("\n    <product");
                contents.append(" id='");
                contents.append(product.getId());
                contents.append("'");
                contents.append(" color='");
                contents.append(getColorFor(product));
                contents.append("'");
                if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                    contents.append(" size='");
                    contents.append(getSizeFor(product));
                    contents.append("'");
                }
                contents.append(">");
                contents.append("<price");
                contents.append(" currency='");
                contents.append(getCurrencyFor(product));
                contents.append("'>");
                contents.append(product.getPrice());
                contents.append("</price>");
                contents.append(product.getName());
                contents.append("</product>");
            }
            contents.append("\n  </order>");
        }
        contents.append("\n</orders>");
        return contents.toString();
    }

    private Currency getCurrencyFor(Product product) {
        return Currency.getInstance("USD");
    }

    private int getSizeFor(Product product) {
        return product.getSize();
    }
    private String getColorFor(Product product) {
        return "BLUE";
    }
    public static void main(String[] args) {
        List<Product> products1 = Arrays.asList(
                new Product(1005, new BigDecimal(10), "Blah 1", 3),
                new Product(8934, new BigDecimal(5), "Blah 2"));
        List<Product> products2 = Arrays.asList(
                new Product(75, new BigDecimal(10), "My product 1", 3),
                new Product(666, new BigDecimal(10), "My product 2"),
                new Product(10231, new BigDecimal(200), "My product 3", 9));
        Orders orders1 = new Orders(Arrays.asList(new Order(products1), new Order(products2)));
        System.out.println(new OrdersWriter(orders1).getContents());
    }
}
