package com.lvs.Classes;

import java.util.UUID;

public class Product {
    
    private UUID productId;
    private String name;
    private boolean value;
    private int quantity;

    public Product(String name, boolean value, int quantity) {
        productId = java.util.UUID.randomUUID();
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public UUID getProductId() {
        return this.productId;
    }

    public String getName() {
        return this.name;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
