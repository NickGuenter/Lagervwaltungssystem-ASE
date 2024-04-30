package com.lvs.Classes;

import java.util.UUID;

public class Supplier extends Party{

    private UUID supplierId;
    private String supllierName;
    private Address location;
    private String contactPerson;
    
    public Supplier(String supllierName, Address location, String contactPerson) {
        super(supllierName, location); 
        supplierId = java.util.UUID.randomUUID();
        this.supllierName = supllierName;
        this.location = location;
        this.contactPerson = contactPerson;
    }

    public UUID getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supllierName;
    }

    public Address getLocation() {
        return location;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void print() {
        System.out.println("Lieferant: " + supllierName);
        System.out.println("Adresse: " + location.getCity());
        System.out.println("Kontaktperson: " + contactPerson);
    }

}
