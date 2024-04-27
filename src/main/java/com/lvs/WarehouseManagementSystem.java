package com.lvs;

import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;
import com.lvs.Manager.CustomerManager;
import com.lvs.Manager.OrderManager;
import com.lvs.Manager.SupplierManager;
import com.lvs.Views.CustomerView;
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
        CustomerManager customerManager = new CustomerManager();
        SupplierManager supplierManager = new SupplierManager();
        SupplierView supplierView = new SupplierView(supplierManager);
        ReportView reportView = new ReportView();
        InventoryView inventoryView = new InventoryView(inventory);
        CustomerView customerView = new CustomerView(customerManager);
        OrderView orderView = new OrderView(buyOrders, sellOrders, inventory);
        MainView mainView = new MainView(orderView, inventoryView, reportView, supplierView, customerView);

        inventory.addProduct(new Product("Bier", 2, 100));
        inventory.addProduct(new Product("Wein", 5, 50));

        mainView.show();
    }
}