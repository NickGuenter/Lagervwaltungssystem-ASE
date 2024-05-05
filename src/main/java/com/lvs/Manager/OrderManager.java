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
            totalValue += order.calculateOrderValue();
        }
        return totalValue;
    }

    public ArrayList<Order> getOrdersByProduct(String productName) {
        ArrayList<Order> ordersByProduct = new ArrayList<>();

        for (Order order : orders) {
            order.getProducts().forEach(product -> {
                if (product.getProductName().equals(productName)) {
                    ordersByProduct.add(order);
                }
            });
        }

        return ordersByProduct;
    }

    public ArrayList<Order> getOrdersByParty(String partyName) {
        ArrayList<Order> ordersByParty = new ArrayList<>();

        for (Order order : orders) {
            if (order.getParty().getName().equals(partyName)) {
                ordersByParty.add(order);
            }
        }

        return ordersByParty;
    }

    public ArrayList<Order> getOrdersByDate(int day, int month, int year) {
        ArrayList<Order> ordersByDate = new ArrayList<>();

        for (Order order : orders) {
            if (order.getDate().getDayOfMonth() == day && order.getDate().getMonthValue() == month
                    && order.getDate().getYear() == year) {
                ordersByDate.add(order);
            }
        }

        return ordersByDate;
    }

    public void getOrdersByMinimumValue(double value) {
        ArrayList<Order> ordersByValue = new ArrayList<>();

        for (Order order : orders) {
            if (order.calculateOrderValue() >= value) {
                ordersByValue.add(order);
            }
        }

        ordersByValue.forEach(order -> order.printOrder());
    }

}
