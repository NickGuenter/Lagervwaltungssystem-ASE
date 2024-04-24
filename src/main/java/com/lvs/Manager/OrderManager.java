package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Inventory;
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
    }

    public void findOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().toString().equals(orderId)) {
                order.printOrder();
            }
        }
    }

    public void findOrderByParty(String name) {
        for (Order order : orders) {
            if (order.getParty().getName().equals(name)) {
                order.printOrder();
            }
        }
    }

    public void findOrderByProduct(String productName) {
        for (Order order : orders) {
            order.getProducts().forEach(product -> {
                if (product.getProductName().equals(productName)) {
                    order.printOrder();
                }
            });
        }
    }
}
