package com.lvs.Classes;

import java.util.UUID;

public class Product {
    
    private UUID productId;
    private String productName;
    private double productValue;
    private int productQuantity;

    public Product(String productName, double productValue, int productQuantity) {
        productId = java.util.UUID.randomUUID();
        this.productName = productName;
        this.productValue = productValue;
        this.productQuantity = productQuantity;
    }

    public UUID getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getProductValue() {
        return this.productValue;
    }

    public void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    public int getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void print() {
        System.out.println("Produkt: " + productName);
        System.out.println("Preis: " + productValue);
        System.out.println("Menge: " + productQuantity);
    }

    public void setProductName(String newName) {
        this.productName = newName;
    }

}
