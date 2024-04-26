package com.lvs;

import com.lvs.Classes.Product;
import com.lvs.Manager.OrderManager;
import com.lvs.Views.InventoryView;
import com.lvs.Views.MainView;
import com.lvs.Views.OrderView;
import com.lvs.Views.ReportView;
import com.lvs.Views.SupplierView;

public class WarehouseManagementSystem {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        OrderManager buyOrders = new OrderManager();
        OrderManager sellOrders = new OrderManager();
        SupplierView supplierView = new SupplierView();
        ReportView reportView = new ReportView();
        InventoryView inventoryView = new InventoryView(inventory);
        OrderView orderView = new OrderView(buyOrders, sellOrders, inventory);
        MainView mainView = new MainView(orderView, inventoryView, reportView, supplierView);

        inventory.addProduct(new Product("Bier", 2, 100));
        inventory.addProduct(new Product("Wein", 5, 50));

        mainView.show();
    }
}