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

    public void findOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().toString().equals(orderId)) {
                order.printOrder();
            }
        }
    }

    public void findOrderBySupplier(String supplierName) {
        for (Order order : orders) {
            if (order.getSupplier().getSupplierName().equals(supplierName)) {
                order.printOrder();
            }
        }
    }

    public void findOrderByCustomer(String customerName) {
        for (Order order : orders) {
            if (order.getCustomer().getCustomerName().equals(customerName)) {
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
