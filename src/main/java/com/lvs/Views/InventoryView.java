package com.lvs.Views;

import com.lvs.Inventory;

public class InventoryView {
    Inventory inventory;

    public InventoryView(Inventory inventory) {
        this.inventory = inventory;
    }

    public void show() {
        inventory.getProducts();
    }
}
