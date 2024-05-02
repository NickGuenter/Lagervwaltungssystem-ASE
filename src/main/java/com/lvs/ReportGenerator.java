package com.lvs;

import java.time.LocalDateTime;

import com.lvs.Manager.OrderManager;
import com.lvs.Manager.ProductManager;

public class ReportGenerator {
    ProductManager productManager;
    OrderManager buyOrders;
    OrderManager sellOrders;

    public ReportGenerator(ProductManager productManager, OrderManager buyOrders, OrderManager sellOrders) {
        this.productManager = productManager;
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;
    }

    public void printOverallReport() {
        System.out.println("\n====================");
        System.out.println("   REPORT vom " + getDate());
        System.out.println("====================");
        System.out.println();
        Printer.printInventory(productManager);
        Printer.printOrders(buyOrders, sellOrders);
    }

    public void printProductReport(String productName) {
        System.out.println("\n====================");
        System.out.println("   REPORT zu " + productName + " vom " + getDate());
        System.out.println("====================");
        System.out.println();
        Printer.printProductsByName(productManager, productName);
        System.out.println("Einkauf:");
        buyOrders.getOrdersByProduct(productName);
        System.out.println("Verkauf:");
        sellOrders.getOrdersByProduct(productName);
        System.out.println();
    }

    public void printRevenueReport() {
        System.out.println("\n====================");
        System.out.println("   UMSATZREPORT vom " + getDate());
        System.out.println("====================");
        System.out.println();
        System.out.println("   EINKAUF:");
        buyOrders.getOrders().forEach(order -> {
            System.out.println("+" + order.calculateOrderValue());
        });
        System.out.println("   VERKAUF:");
        sellOrders.getOrders().forEach(order -> {
            System.out.println("-" + order.calculateOrderValue());
        });
        System.out.println("Gesamtumsatz: " + (sellOrders.getTotalValue()-buyOrders.getTotalValue()) + "$");
        System.out.println();
    }

    public String getDate() {
        LocalDateTime date = LocalDateTime.now();
        return date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear();
    }

}
