package com.lvs;

import java.util.HashMap;
import java.util.Map;

public class LanguageEnglish {
    private static Map<String, String> english = new HashMap<>();

    static {
        // Other
        english.put("invalidInput", "Invalid input!");

        // Language
        english.put("language", "Language");
        english.put("english", "English");
        english.put("german", "German");
        english.put("chooseLanguage", "Choose language");

        // Main Menu
        english.put("mainMenu", "Main Menu");
        english.put("exit", "Exit");
        english.put("back", "Back");

        // Supplier
        english.put("suppliers", "Suppliers");
        english.put("addSupplier", "Add Supplier");
        english.put("removeSupplier", "Remove Supplier");
        english.put("showSuppliers", "Show Suppliers");

        // Customer
        english.put("customers", "Customers");
        english.put("addCustomer", "Add Customer");
        english.put("removeCustomer", "Remove Customer");
        english.put("showCustomers", "Show Customers");
        english.put("customerType", "Select customer type");
        english.put("branchCustomer", "Branch Customer");
        english.put("businessCustomer", "Business Customer");
        english.put("privateCustomer", "Private Customer");
        english.put("contactPerson", "Contact Person");
        english.put("customerName", "Name");
        english.put("customerAddress", "Address");
        english.put("businessName", "Business Name");
        english.put("filialNr", "Branch Number");

        // Orders
        english.put("orders", "Orders");
        english.put("addOrder", "Add Order");
        english.put("showOrders", "Show Orders");

        // Inventory
        english.put("inventory", "Inventory");
        english.put("showInventory", "Show Inventory");
        english.put("stock", "Stock");

        // Reports
        english.put("reports", "Reports");
        english.put("showReports", "Show Reports");
        english.put("overallReport", "Overall Report");
        english.put("productReport", "Product Report");
        english.put("revenueReport", "Revenue Report");

        // Products
        english.put("products", "Products");
        english.put("addProduct", "Add Product");
        english.put("removeProduct", "Remove Product");
        english.put("showProducts", "Show Products");
    }

    public static Map<String, String> getLanguage() {
        return english;
    }
}
