package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.Order;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();

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
}
