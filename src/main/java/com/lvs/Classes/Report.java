package com.lvs.Classes;

import com.lvs.Manager.ProductManager;
import com.lvs.Printer;
import com.lvs.Manager.OrderManager;

public class Report {
    private final String reportName;
    private final ProductManager productManager;
    private final OrderManager buyOrders;
    private final OrderManager sellOrders;

    private Report(Builder builder) {
        this.reportName = builder.reportName;
        this.productManager = builder.productManager;
        this.buyOrders = builder.buyOrders;
        this.sellOrders = builder.sellOrders;
    }

    public void printReport() {
        System.out.println("Report: " + reportName);
        if(productManager == null && buyOrders == null && sellOrders == null) {
            System.out.println("No data to display");
            return;
        }
        if (productManager != null) {
            Printer.printInventory(productManager);
        }
        if (buyOrders != null && sellOrders != null) {
            Printer.printOrders(buyOrders, sellOrders);
        }
    }

    public static class Builder {
        private String reportName;
        private ProductManager productManager;
        private OrderManager buyOrders;
        private OrderManager sellOrders;

        public Builder reportName(String reportName) {
            this.reportName = reportName;
            return this;
        }

        public Builder productManager(ProductManager productManager) {
            this.productManager = productManager;
            return this;
        }

        public Builder buyOrders(OrderManager buyOrders) {
            this.buyOrders = buyOrders;
            return this;
        }

        public Builder sellOrders(OrderManager sellOrders) {
            this.sellOrders = sellOrders;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}