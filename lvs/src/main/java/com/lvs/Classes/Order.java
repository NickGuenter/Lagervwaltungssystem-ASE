package com.lvs.Classes;

import java.util.ArrayList;
import java.util.UUID;

public class Order {

    private UUID orderId;
    private boolean value;
    private Supplier supplier;
    private ArrayList<Product> products;

    public Order(boolean value, Supplier supplier, ArrayList<Product> products) {
        orderId = java.util.UUID.randomUUID();
        this.value = value;
        this.supplier = supplier;
        this.products = products;
    }

    public UUID getOrderId() {
        return this.orderId;
    }

    public boolean getValue() {
        return this.value;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

}
