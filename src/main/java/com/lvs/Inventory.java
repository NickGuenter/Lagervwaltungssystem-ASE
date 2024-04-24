package com.lvs;

import java.util.ArrayList;

import com.lvs.Classes.Product;

public class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProducts(ArrayList<Product> products) {
        for (Product product : products) {
            addProduct(product);
        }
    }

    public void removeProduct(Product product) {
        getProduct(product).setProductQuantity(getProduct(product).getProductQuantity() - product.getProductQuantity());
    }

    public void removeProducts(ArrayList<Product> products) {
        for (Product product : products) {
            removeProduct(product);
        }
    }

    public boolean checkStock(ArrayList<Product> products) {
        for (Product product : products) {
            if (getProduct(product) == null) {
                System.out.println("Produkt nicht im Inventar!");
                return false;
            }
            else if (product.getProductQuantity() > getProduct(product).getProductQuantity()) {
                System.out.println("Nicht genug Waren auf Lager!");
                return false;
            }
        }
        return true;
    }

    public int getProductQuantity() {
        int quantity = 0;
        for (Product product : products) {
            quantity += product.getProductQuantity();
        }
        return quantity;
    }

    public Product getProduct(Product product) {
        for (Product p : products) {
            if (p.getProductName().equals(product.getProductName())) {
                return p;
            }
        }
        return null;
    }

    public void getProducts() {
        System.out.println("Inventar:");
        System.out.println("--------------------");
        for (Product product : products) {
            System.out.println("Name: " + product.getProductName()
                    + ", Wert: " + product.getProductValue()
                    + ", Anzahl: " + product.getProductQuantity());
            System.out.println("--------------------");
        }
    }
}
