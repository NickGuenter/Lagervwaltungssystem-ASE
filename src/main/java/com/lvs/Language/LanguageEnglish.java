package com.lvs.Language;

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
        english.put("spanish", "Spanish");
        english.put("chooseLanguage", "Choose language");

        // Main Menu
        english.put("mainMenu", "Main Menu");
        english.put("exit", "Exit");
        english.put("back", "Back");

        // Supplier
        english.put("suppliers", "Suppliers");
        english.put("supplier", "Supplier");
        english.put("addSupplier", "Add Supplier");
        english.put("removeSupplier", "Remove Supplier");
        english.put("showSuppliers", "Show Suppliers");

        // Customer
        english.put("customers", "Customers");
        english.put("customer", "Customer");
        english.put("addCustomer", "Add Customer");
        english.put("removeCustomer", "Remove Customer");
        english.put("showCustomers", "Show Customers");
        english.put("customerType", "Select customer type");
        english.put("branchCustomer", "Branch Customer");
        english.put("businessCustomer", "Business Customer");
        english.put("privateCustomer", "Private Customer");
        english.put("contactPerson", "Contact Person");
        english.put("customerName", "Name");
        english.put("customerAddress", "Addresse");
        english.put("businessName", "Business Name");
        english.put("filialNr", "Branch Number");

        // Orders
        english.put("orders", "Orders");
        english.put("buyOrders", "Buy Orders");
        english.put("sellOrders", "Sell Orders");
        english.put("addOrder", "Add Order");
        english.put("showOrders", "Show Orders");
        english.put("findOrder", "Find Order");
        english.put("findOrderText", "Search for order by:");
        english.put("searchParty", "Enter name of customer or supplier:");
        english.put("searchProduct", "Enter product name:");
        english.put("buyOrSell", "Buy or Sell? (k/v)");
        english.put("noProductAdded", "You must add at least one product to the order!");
        english.put("orderError", "Order could not be created!");
        english.put("addProductToOrder", "Add product? (j/n)");
        english.put("chooseCustomer", "Enter customer name, business name or branch number:");
        english.put("chooseSupplier", "Enter supplier name:");
        english.put("customerError", "Customer could not be found!");
        english.put("supplierError", "Supplier could not be found!");        

        // Reports
        english.put("reports", "Reports");
        english.put("showReports", "Show Reports");
        english.put("overallReport", "Overall Report");
        english.put("productReport", "Product Report");
        english.put("revenueReport", "Revenue Report");

        // Products & Inventory
        english.put("inventory", "Inventory");
        english.put("showInventory", "Show Inventory");
        english.put("stock", "Stock");
        english.put("products", "Products");
        english.put("product", "Product");
        english.put("productName", "Name");
        english.put("productPrice", "Price");
        english.put("productQuantity", "Quantity");
        english.put("addProduct", "Add Product");
        english.put("removeProduct", "Remove Product");
        english.put("editProduct", "Edit Product");
        english.put("removeAmount", "Enter amount or 'x' for all:");
        english.put("showProducts", "Show Products");
        english.put("newProductName", "Enter new product name:");
        english.put("newProductPrice", "Enter new product price:");
        english.put("newProductQuantity", "Enter new product quantity:");
    }

    public static Map<String, String> getLanguage() {
        return english;
    }
}
