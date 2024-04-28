package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.Order;

public class OrderManager {
    private ArrayList<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void getOrders() {
        System.out.println("Bestellverlauf:");
        System.out.println("--------------------");
        for (Order order : orders) {
            order.printOrder();
            System.out.println("--------------------");
        }
        System.out.println();
    }

    // TODO: Is this method relevant?
    public void findOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().toString().equals(orderId)) {
                order.printOrder();
            }
        }
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
