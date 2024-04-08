package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.Order;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void getOrders() {
        for (Order order : orders) {
            System.out.println(order.toString());
            System.out.println("---------");
        }
    }
}
