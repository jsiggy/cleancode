package com.siggy.training.code.smells.orders;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuilder contents = new StringBuilder();
        contents.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            contents.append("<order");
            contents.append(" id='");
            contents.append(order.getOrderId());
            contents.append("'>");
            for (int j = 0; j < order.getProductCount(); j++) {
                Product product = order.getProduct(j);
                contents.append("<product");
                contents.append(" id='");
                contents.append(product.getID());
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
            contents.append("</order>");
        }
        contents.append("</orders>");
        return contents.toString();
    }

    private String getCurrencyFor(Product product) {
        return "USD";
    }

    private String getColorFor(Product product) {
        return product.getColor().toString().toLowerCase();
    }

    private String getSizeFor(Product product) {
        var sizeString = product.getSize().toString().toLowerCase();
        return product.getSize() == ProductSize.NOT_APPLICABLE ? "" : sizeString;
    }
}
