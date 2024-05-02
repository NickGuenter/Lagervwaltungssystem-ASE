package com.lvs;

import java.util.ArrayList;
import java.util.Map;

import com.lvs.Classes.Customer;
import com.lvs.Classes.Order;
import com.lvs.Classes.Product;
import com.lvs.Manager.CustomerManager;
import com.lvs.Manager.OrderManager;
import com.lvs.Manager.ProductManager;
import com.lvs.Views.View;

public class Printer {
    public static void printInventory(ProductManager productManager) {
        ArrayList<Product> products = productManager.getProducts();
        System.out.println("\n====================");
        System.out.println("   INVENTAR");
        System.out.println("====================\n");
        System.out.println(productManager.getProducts().size() + " Produkte im Inventar\n");
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
        System.out.println("   BESTELLUNGEN");
        System.out.println("====================\n");
        System.out.println("1: Bestellung hinzufügen");
        System.out.println("2: Bestellung entfernen");
        System.out.println("3: Bestellungen anzeigen");
        System.out.println("4: Zurück\n");
    }

    public static void printSupplierMenu() {
        System.out.println("\n====================");
        System.out.println("   LIEFERANTEN");
        System.out.println("====================\n");
        System.out.println("1: Lieferant hinzufügen");
        System.out.println("2: Lieferant entfernen");
        System.out.println("3: Lieferanten anzeigen");
        System.out.println("4: Zurück\n");
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
        System.out.println("   REPORTS");
        System.out.println("====================\n");
        System.out.println("1: Gesamtreport anzeigen");
        System.out.println("2: Report für ein Produkt anzeigen");
        System.out.println("3: Umsatzreport");
        System.out.println("4: Zurück\n");
    }

    public static void printInventoryMenu() {
        System.out.println("\n====================");
        System.out.println("   INVENTAR");
        System.out.println("====================\n");
        System.out.println("1: Inventar anzeigen");
        System.out.println("2: Produkt hinzufügen");
        System.out.println("3: Produkt entfernen");
        System.out.println("4: Produkt bearbeiten");
        System.out.println("5: Zurück\n");
    }

    public static void printLanguageMenu() {
        System.out.println("\n====================");
        System.out.println("   " + LanguageControl.getTranslation("language").toUpperCase());
        System.out.println("====================\n");
        System.out.println("1: " + LanguageControl.getTranslation("english"));
        System.out.println("2: " + LanguageControl.getTranslation("german") + "\n");
    }


    public static void printOrders(OrderManager buyOrders, OrderManager sellOrders) {
        System.out.println("\n====================");
        System.out.println("   BESTELLÜBERSICHT");
        System.out.println("====================\n");
        System.out.println("   KAUFBESTELLUNGEN:");
        System.out.println();
        for ( Order order : buyOrders.getOrders() ) {
            order.printOrder();
            System.out.println("");
        }
        System.out.println("   VERKAUFSBESTELLUNGEN:");
        System.out.println();
        for ( Order order : sellOrders.getOrders() ) {
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
}
