package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.Order;

public class OrderManager {
    private ArrayList<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double getTotalValue() {
        double totalValue = 0;
        for (Order order : orders) {
            totalValue += order.getOrderValue();
        }
        return totalValue;
    }

    public void printOrders() {
        System.out.println("Bestellverlauf:");
        System.out.println("--------------------");
        for (Order order : orders) {
            order.printOrder();
            System.out.println("--------------------");
        }
        System.out.println();
    }

    public void getOrdersByProduct(String productName) {
        for (Order order : orders) {
            order.getProducts().forEach(product -> {
                if (product.getProductName().equals(productName)) {
                    order.printOrder();
                    System.out.println("--------------------");
                }
            });
        }
    }

    public void getOrdersByParty(String partyName) {
        for (Order order : orders) {
            if (order.getParty().getName().equals(partyName)) {
                order.printOrder();
                System.out.println("--------------------");
            }
        }
    }

}
