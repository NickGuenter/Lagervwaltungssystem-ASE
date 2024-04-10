package com.lvs.Classes;

public class Customer extends Party{

    private String customerName;
    public Customer(String customerName) {
        super(customerName);
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }
    
}
