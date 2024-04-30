package com.lvs.Manager;

import java.util.ArrayList;
import java.util.Optional;

import com.lvs.Classes.Address;
import com.lvs.Classes.BusinessCustomer;
import com.lvs.Classes.Customer;
import com.lvs.Classes.FilialCustomer;
import com.lvs.Classes.PrivateCustomer;

public class CustomerManager {

    ArrayList<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<Customer>();
        customers.add(new FilialCustomer("F01", new Address("Hamburg"), "William Doe"));
        customers.add(new BusinessCustomer("Media Markt", new Address("Berlin"), "John Doe"));
        customers.add(new PrivateCustomer("Max Mustermann", new Address("Dresden")));
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void printCustomers() {
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

    public Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    // OCP könnte weiter durch Verwendung einer Factory Klasse/Methode verbessert werden
    public void addCustomer(String type, String name, Address address, Optional<String> contact) {
        Customer customer;
        switch (type) {
            case "Filial":
            case "Business":
                if (contact.isPresent()) {
                    customer = type.equals("Filial") ? new FilialCustomer(name, address, contact.get())
                            : new BusinessCustomer(name, address, contact.get());
                } else {
                    throw new IllegalArgumentException("Contact is required for Filial and Business customers");
                }
                break;
            case "Private":
                customer = new PrivateCustomer(name, address);
                break;
            default:
                throw new IllegalArgumentException("Invalid customer type: " + type);
        }
        customers.add(customer);
    }

}
