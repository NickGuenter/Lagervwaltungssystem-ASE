package com.lvs;

import com.lvs.Manager.*;
import com.lvs.Views.*;

public class WarehouseManagementSystem {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        OrderManager buyOrders = new OrderManager();
        OrderManager sellOrders = new OrderManager();
        CustomerManager customerManager = new CustomerManager();
        SupplierManager supplierManager = new SupplierManager();
        Report report = new Report(productManager, buyOrders, sellOrders);
        SupplierView supplierView = new SupplierView(supplierManager);
        ReportView reportView = new ReportView(report);
        InventoryView inventoryView = new InventoryView(productManager);
        CustomerView customerView = new CustomerView(customerManager);
        OrderView orderView = new OrderView(buyOrders, sellOrders, productManager, customerManager, supplierManager);
        MainView mainView = new MainView(orderView, inventoryView, reportView, supplierView, customerView);

        mainView.show();
    }
}