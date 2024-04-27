package com.lvs.Classes;

public class Customer extends Party{

    public Customer(String name, String address) {
        super(name, address);
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Adresse: " + address);
    }

}
