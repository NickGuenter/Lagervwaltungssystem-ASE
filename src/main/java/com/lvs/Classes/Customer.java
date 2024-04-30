package com.lvs.Classes;

public class Customer extends Party{

    public Customer(String name, Address address) {
        super(name, address);
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Adresse: " + getAddress());
    }

}
