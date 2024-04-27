package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.BusinessCustomer;
import com.lvs.Classes.Customer;
import com.lvs.Classes.FilialCustomer;
import com.lvs.Classes.PrivateCustomer;

public class CustomerManager {

    ArrayList<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<Customer>();
        customers.add(new FilialCustomer("F01", "Hamburg", "William Doe"));
    }

    public void getCustomers() {
        System.out.println("Kunden:");
        System.out.println("-------------");
        System.out.println();
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

    public void addFilialCustomer(String name, String address, String filialNr) {
        FilialCustomer customer = new FilialCustomer(name, address, filialNr);
        customers.add(customer);
    }

    public void addBusinessCustomer(String name, String address, String contact) {
        BusinessCustomer customer = new BusinessCustomer(name, address, contact);
        customers.add(customer);
    }

    public void addPrivateCustomer(String name, String address) {
        PrivateCustomer customer = new PrivateCustomer(name, address);
        customers.add(customer);
    }

}