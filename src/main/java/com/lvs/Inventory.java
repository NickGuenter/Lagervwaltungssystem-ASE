package com.lvs;

import java.util.ArrayList;

import com.lvs.Classes.Product;

public class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    public Inventory() {
        addProduct(new Product("Bier", 2, 100));
        addProduct(new Product("Wein", 5, 50));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProducts(ArrayList<Product> products) {
        for (Product product : products) {
            Product p = getProduct(product);
            if (p == null) {
                addProduct(product);
            }
            else {
                p.setProductQuantity(p.getProductQuantity() + product.getProductQuantity());
            }
        }
    }

    public void removeProduct(Product product) {
        Product p = getProduct(product);
        int diff = p.getProductQuantity() - product.getProductQuantity();

        if (diff == 0) {
            products.remove(p);
        }
        else {
            p.setProductQuantity(diff);
        }
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

    public void printProducts() {
        System.out.println("Inventar:");
        System.out.println("--------------------");
        System.out.println();
        for (Product product : products) {
            product.print();
            System.out.println();
        }
        System.out.println("--------------------");
        System.out.println();
    }

    public void printProductsByName(String productName) {
        System.out.println("Inventar:");
        System.out.println("--------------------");
        System.out.println();
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                product.print();
                System.out.println();
            }
        }
        System.out.println("--------------------");
        System.out.println();
    }
}
