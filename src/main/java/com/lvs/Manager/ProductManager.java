package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.Product;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void getProducts() {
        System.out.println("Produktliste:");
        System.out.println("--------------------");
        for (Product product : products) {
            System.out.println(product.getProductId() + ": " + product.getProductName());
            System.out.println("--------------------");
        }
    }
}
