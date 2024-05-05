package com.lvs;

import com.lvs.Language.LanguageControl;
import com.lvs.Language.LanguageEnglish;
import com.lvs.Manager.*;
import com.lvs.Views.*;

public class WarehouseManagementSystem {

    public static void main(String[] args) {
        LanguageControl languageControl = LanguageControl.getInstance();
        LanguageControl.setLanguageEnglish(LanguageEnglish.getLanguage());
        AuthView authView = new AuthView(new Authentification());
        ProductManager productManager = new ProductManager();
        OrderManager buyOrders = new OrderManager();
        OrderManager sellOrders = new OrderManager();
        CustomerManager customerManager = new CustomerManager();
        SupplierManager supplierManager = new SupplierManager();
        ReportGenerator report = new ReportGenerator(productManager, buyOrders, sellOrders);
        LanguageView languageView = new LanguageView();
        SupplierView supplierView = new SupplierView(supplierManager);
        ReportView reportView = new ReportView(report);
        InventoryView inventoryView = new InventoryView(productManager);
        CustomerView customerView = new CustomerView(customerManager);
        OrderView orderView = new OrderView(buyOrders, sellOrders, productManager, customerManager, supplierManager);
        MainView mainView = new MainView(orderView, inventoryView, reportView, supplierView, customerView , languageView);

        authView.show();
        mainView.show();
    }
}