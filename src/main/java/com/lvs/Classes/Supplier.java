package com.lvs.Classes;

public class Supplier extends Party{

    private String supllierName;
    private Address location;
    private String contactPerson;
    
    public Supplier(String supllierName, Address location, String contactPerson) {
        super(supllierName, location); 
        this.supllierName = supllierName;
        this.location = location;
        this.contactPerson = contactPerson;
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
