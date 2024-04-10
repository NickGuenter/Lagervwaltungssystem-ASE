package com.lvs.Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Order {

    private UUID orderId;
    private double orderValue;
    private ArrayList<Product> products;
    private int orderQuantity;
    private Party party;
    private LocalDateTime date;

    public Order(Party party, ArrayList<Product> products) {
        orderId = java.util.UUID.randomUUID();
        this.party = party;
        this.products = products;
        orderValue = getOrderValue();
        orderQuantity = getOrderQuantity();
        date = LocalDateTime.now();
    }

    public int getOrderQuantity() {
        int result = 0;
        for (Product product : products) {
            result += product.getProductQuantity();
        }
        return result;
    }

    public double getOrderValue() {
        double result = 0;
        for (Product product : products) {
            result += product.getProductValue() * product.getProductQuantity();
        }
        return result;
    }

    public UUID getOrderId() {
        return this.orderId;
    }

    public double getorderValue() {
        return this.orderValue;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    // Method to print out the order 
    public void printOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Value: " + orderValue);
        System.out.println("Order Quantity: " + orderQuantity);
        System.out.println("Date: " + date);
        System.out.println("" + party.getClass().getSimpleName() + ": " + party.getName());
        System.out.println("Products: ");
        for (Product product : products) {
            System.out.println();
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Value: " + product.getProductValue());
            System.out.println("Product Quantity: " + product.getProductQuantity());
        } 
    }

    public Supplier getSupplier() {
        return (Supplier)this.party;
    }

    public Customer getCustomer() {
        return (Customer)this.party;
    }

    public Party getParty() {
        return this.party;
    }

}
