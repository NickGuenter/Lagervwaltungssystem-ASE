package com.lvs;

import java.time.LocalDateTime;

import com.lvs.Manager.OrderManager;
import com.lvs.Manager.ProductManager;

public class Report {
    ProductManager productManager;
    OrderManager buyOrders;
    OrderManager sellOrders;

    public Report(ProductManager productManager, OrderManager buyOrders, OrderManager sellOrders) {
        this.productManager = productManager;
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;
    }

    public void printOverallReport() {
        System.out.println("Report");
        printDate();
        System.out.println();
        productManager.printInventory();
        System.out.println("Einkauf:");
        buyOrders.printOrders();
        System.out.println("Verkauf:");
        sellOrders.printOrders();
    }

    public void printProductReport(String productName) {
        System.out.println("Report zu " + productName);
        printDate();
        System.out.println();
        productManager.printProductsByName(productName);
        System.out.println("Einkauf:");
        buyOrders.getOrdersByProduct(productName);
        System.out.println("Verkauf:");
        sellOrders.getOrdersByProduct(productName);
        System.out.println();
    }

    public void printRevenueReport() {
        System.out.println("Umsatzreport");
        printDate();
        System.out.println();
        System.out.println("Einkauf:");
        buyOrders.getOrders().forEach(order -> {
            System.out.println("+" + order.getOrderValue());
        });
        System.out.println("Verkauf:");
        sellOrders.getOrders().forEach(order -> {
            System.out.println("-" + order.getOrderValue());
        });
        System.out.println("Gesamtumsatz: " + (sellOrders.getTotalValue()-buyOrders.getTotalValue()) + "$");
        System.out.println();
    }

    public void printDate() {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear());
    }

}
