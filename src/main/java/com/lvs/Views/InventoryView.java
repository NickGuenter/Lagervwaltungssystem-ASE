package com.lvs.Views;

import com.lvs.Inventory;
import com.lvs.Classes.Product;

public class InventoryView implements View {
    Inventory inventory;

    public InventoryView(Inventory inventory) {
        this.inventory = inventory;
    }

    public void show() {
        inventory.printProducts();
        calculateTotal();
    }

    public void calculateTotal() {
        double total = 0;

        for (Product product : inventory.getProducts()) {
            total += product.getProductValue() * product.getProductQuantity();
        }

        System.out.println("Gesamtpreis: " + total);
    }
}
