package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.Customer;

public class CustomerManager {

    ArrayList<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(String name, String address, String filial) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCustomer'");
    }

    public void getCustomers() {
        System.out.println("Kunden:");
        System.out.println("-------------");
        for (Customer customer : customers) {
            customer.print();
            System.out.println();
        }
        System.out.println("-------------");
        System.out.println();
    }

    public void removeCustomer(String name) {
        Customer customer = findCustomer(name);
        if (customer != null) {
            customers.remove(customer);
        }
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public void addFilialCustomer(String name, String address, String filial) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFilialCustomer'");
    }

    public void addBusinessCustomer(String name, String address, String contact) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBusinessCustomer'");
    }

    public void addPrivateCustomer(String name, String address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPrivateCustomer'");
    }

}
