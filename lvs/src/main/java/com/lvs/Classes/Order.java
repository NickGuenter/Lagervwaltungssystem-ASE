package com.lvs.Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Order {

    private UUID orderId;
    private double orderValue;
    private Supplier supplier;
    private ArrayList<Product> products;
    private int orderQuantity;
    private LocalDateTime date;

    public Order(Supplier supplier, ArrayList<Product> products) {
        orderId = java.util.UUID.randomUUID();
        this.supplier = supplier;
        this.products = products;
        orderValue = getOrderValue();
        orderQuantity = getOrderQuantity();
        date = LocalDateTime.now();
    }

    public int getOrderQuantity() {
        int result = 0;
        for (Product product : products) {
            result += product.getQuantity();
        }
        return result;
    }

    public double getOrderValue() {
        double result = 0;
        for (Product product : products) {
            result += product.getValue();
        }
        return result;
    }

    public UUID getOrderId() {
        return this.orderId;
    }

    public double getorderValue() {
        return this.orderValue;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    @Override
    public String toString() {
        return "Order " + orderId + ", orderValue=" + orderValue + ", supplier=" + supplier.getSupllierName() + ", products="
                + products.size() + ", orderQuantity=" + orderQuantity + ", date=" + date;
    }

}
