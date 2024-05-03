package com.lvs;

import java.util.ArrayList;
import java.util.Map;

import com.lvs.Classes.Customer;
import com.lvs.Classes.Order;
import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;
import com.lvs.Language.LanguageControl;
import com.lvs.Manager.CustomerManager;
import com.lvs.Manager.OrderManager;
import com.lvs.Manager.ProductManager;
import com.lvs.Manager.SupplierManager;
import com.lvs.Views.View;

public class Printer {
    public static void printInventory(ProductManager productManager) {
        ArrayList<Product> products = productManager.getProducts();
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("inventory").toUpperCase());
        System.out.println("====================\n");
        for (Product product : products) {
            product.print();
            System.out.println();
        }
        System.out.println();
    }

    public static void printProductsByName(ProductManager productManager, String productName) {
        ArrayList<Product> products = productManager.getProductsByName(productName);
        System.out.println("--------------------");
        System.out.println();
        for (Product product : products) {
            product.print();
            System.out.println();
        }
        System.out.println("--------------------");
        System.out.println();
    }

    public static void printMainMenu(Map<String, View> views, Map<View, String> viewsText) {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("mainMenu").toUpperCase());
        System.out.println("====================\n");

        views.forEach((key, value) -> System.out.println(key + ": " + viewsText.get(value)));

        System.out.println("x: " + LanguageControl.getTranslation("exit") + "\n");
    }

    public static void printOrderMenu() {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("orders").toUpperCase());
        System.out.println("====================\n");
        System.out.println("1: " + LanguageControl.getTranslation("addOrder"));
        System.out.println("2: " + LanguageControl.getTranslation("showOrders"));
        System.out.println("3: " + LanguageControl.getTranslation("findOrder"));
        System.out.println("4: " + LanguageControl.getTranslation("back") + "\n");
    }

    public static void printSupplierMenu() {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("suppliers").toUpperCase());
        System.out.println("====================\n");
        System.out.println("1: " + LanguageControl.getTranslation("addSupplier"));
        System.out.println("2: " + LanguageControl.getTranslation("showSuppliers"));
        System.out.println("3: " + LanguageControl.getTranslation("removeSupplier"));
        System.out.println("4: " + LanguageControl.getTranslation("back") + "\n");
    }

    public static void printCustomerMenu() {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("customers").toUpperCase());
        System.out.println("====================\n");
        System.out.println("1: " + LanguageControl.getTranslation("addCustomer"));
        System.out.println("2: " + LanguageControl.getTranslation("showCustomers"));
        System.out.println("3: " + LanguageControl.getTranslation("removeCustomer"));
        System.out.println("4: " + LanguageControl.getTranslation("back") + "\n");
    }

    public static void printReportMenu() {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("reports").toUpperCase());
        System.out.println("====================\n");
        System.out.println("1: " + LanguageControl.getTranslation("overallReport"));
        System.out.println("2: " + LanguageControl.getTranslation("productReport"));
        System.out.println("3: " + LanguageControl.getTranslation("revenueReport"));
        System.out.println("4: " + LanguageControl.getTranslation("back") + "\n");
    }

    public static void printInventoryMenu() {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("inventory").toUpperCase());
        System.out.println("====================\n");
        System.out.println("1: " + LanguageControl.getTranslation("showInventory"));
        System.out.println("2: " + LanguageControl.getTranslation("addProduct"));
        System.out.println("3: " + LanguageControl.getTranslation("removeProduct"));
        System.out.println("4: " + LanguageControl.getTranslation("editProduct"));
        System.out.println("5: " + LanguageControl.getTranslation("back") + "\n");
    }

    public static void printLanguageMenu() {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("language").toUpperCase());
        System.out.println("====================\n");
        System.out.println("1: " + LanguageControl.getTranslation("english"));
        System.out.println("2: " + LanguageControl.getTranslation("german"));
        System.out.println("3: " + LanguageControl.getTranslation("spanish") + "\n");
    }

    public static void printOrders(OrderManager buyOrders, OrderManager sellOrders) {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("orders").toUpperCase());
        System.out.println("====================\n");
        System.out.println("   " + LanguageControl.getTranslation("buyOrders").toUpperCase());
        System.out.println();
        for (Order order : buyOrders.getOrders()) {
            order.printOrder();
            System.out.println("");
        }
        System.out.println("   " + LanguageControl.getTranslation("sellOrders").toUpperCase());
        System.out.println();
        for (Order order : sellOrders.getOrders()) {
            order.printOrder();
            System.out.println("");
        }
        System.out.println();
    }

    public static void printCustomers(CustomerManager customerManager) {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("customers").toUpperCase());
        System.out.println("====================\n");

        System.out.println("   " + LanguageControl.getTranslation("branchCustomer").toUpperCase());
        for (Customer customer : customerManager.getCustomers()) {
            if (customer.getClass().getSimpleName().equals("FilialCustomer")) {
                customer.print();
                System.out.println();
            }
        }
        System.out.println("   " + LanguageControl.getTranslation("businessCustomer").toUpperCase());
        for (Customer customer : customerManager.getCustomers()) {
            if (customer.getClass().getSimpleName().equals("BusinessCustomer")) {
                customer.print();
                System.out.println();
            }
        }
        System.out.println("   " + LanguageControl.getTranslation("privateCustomer").toUpperCase());
        for (Customer customer : customerManager.getCustomers()) {
            if (customer.getClass().getSimpleName().equals("PrivateCustomer")) {
                customer.print();
                System.out.println();
            }
        }
    }

    public static void printSearchParty(OrderManager buyOrders, OrderManager sellOrders, String partyName) {
        System.out.println("\n====================");
        System.out.println("   " + partyName.toUpperCase());
        System.out.println("====================\n");

        System.out.println("   " + LanguageControl.getTranslation("buyOrders").toUpperCase());
        System.out.println();

        ArrayList<Order> ordersByParty = buyOrders.getOrdersByParty(partyName);

        for (Order order : ordersByParty) {
                order.printOrder();
                System.out.println("");
        }
        System.out.println("   " + LanguageControl.getTranslation("sellOrders").toUpperCase());
        for (Order order : ordersByParty) {
                order.printOrder();
                System.out.println("");
        }
        System.out.println();
    }

    public static void printSearchProduct(OrderManager buyOrders, OrderManager sellOrders, String productName) {
        System.out.println("\n====================");
        System.out.println("   " + productName.toUpperCase());
        System.out.println("====================\n");

        System.out.println("   " + LanguageControl.getTranslation("buyOrders").toUpperCase());
        System.out.println();

        ArrayList<Order> ordersByProduct = buyOrders.getOrdersByProduct(productName);

        for ( Order order : ordersByProduct ) {
            order.printOrder();
            System.out.println("");
        }
        System.out.println("   " + LanguageControl.getTranslation("sellOrders").toUpperCase());
        for ( Order order : ordersByProduct ) {
            order.printOrder();
            System.out.println("");
        }
        System.out.println();
        }

        public static void printSuppliers(SupplierManager supplierManager) {
            System.out.println("\n====================");
            System.out.println("   " + LanguageControl.getTranslation("suppliers").toUpperCase());
            System.out.println("====================\n");
            for (Supplier supplier : supplierManager.getSuppliers()) {
                supplier.print();
                System.out.println();
            }
        }

}
