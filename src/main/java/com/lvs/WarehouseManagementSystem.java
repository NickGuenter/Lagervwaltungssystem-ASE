package com.lvs;

import com.lvs.Manager.*;
import com.lvs.Views.*;

public class WarehouseManagementSystem {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        OrderManager buyOrders = new OrderManager();
        OrderManager sellOrders = new OrderManager();
        CustomerManager customerManager = new CustomerManager();
        SupplierManager supplierManager = new SupplierManager();
        Report report = new Report(inventory, buyOrders, sellOrders);
        SupplierView supplierView = new SupplierView(supplierManager);
        ReportView reportView = new ReportView(report);
        InventoryView inventoryView = new InventoryView(inventory);
        CustomerView customerView = new CustomerView(customerManager);
        OrderView orderView = new OrderView(buyOrders, sellOrders, inventory, customerManager, supplierManager);
        MainView mainView = new MainView(orderView, inventoryView, reportView, supplierView, customerView);

        mainView.show();
    }
}