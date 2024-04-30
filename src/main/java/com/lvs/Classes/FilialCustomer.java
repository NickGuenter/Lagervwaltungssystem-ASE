package com.lvs.Classes;

public class FilialCustomer extends Customer{

    private String contactPerson;

    public FilialCustomer(String filialNr, Address location) {
        super(filialNr, location);
    }

    public FilialCustomer(String filialNr, Address location, String contactPerson) {
        super(filialNr, location);
        this.contactPerson = contactPerson;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public void print() {
        System.out.println("Filial Nummer: " + name);
        System.out.println("Adresse: " + getAddress());
        System.out.println("Ansprechpartner: " + contactPerson);
    }
}
