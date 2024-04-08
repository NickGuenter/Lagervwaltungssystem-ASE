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
            result += product.getValue() * product.getQuantity();
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

    // Method to print out the order 
    public void printOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Value: " + orderValue);
        System.out.println("Supplier: " + supplier.getSupllierName());
        System.out.println("Products: ");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Value: " + product.getValue());
            System.out.println("Product Quantity: " + product.getQuantity());
        }
        System.out.println("Order Quantity: " + orderQuantity);
        System.out.println("Date: " + date);
    }

}
