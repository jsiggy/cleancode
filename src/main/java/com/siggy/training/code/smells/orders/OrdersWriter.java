package com.siggy.training.code.smells.orders;

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

    public static void main(String[] args) {
        Product p1005 = new Product("p1005", "Blah 1", Color.WHITE, 10.15F);
        Product t8934 = new Product("t8934", "Blah 2", Color.YELLOW, 12.50F, ProductSize.SMALL);
        Product r9075 = new Product("r9075", "My product 1", Color.RED, 15.99F, ProductSize.MEDIUM);
        Product t0666 = new Product("t0666", "My product 2", Color.PINK, 200.93F, ProductSize.LARGE);
        Product s1231 = new Product("s1231", "My product 3", Color.RED, 1.50F);
        Order id1 = new Order("id1");
        id1.addProduct(p1005);
        id1.addProduct(t8934);
        Order id2 = new Order("id2");
        id2.addProduct(r9075);
        id2.addProduct(t0666);
        id2.addProduct(s1231);
        Orders orders = new Orders();
        orders.addOrder(id1);
        orders.addOrder(id2);
        System.out.println(new OrdersWriter(orders).getContents());
    }
}