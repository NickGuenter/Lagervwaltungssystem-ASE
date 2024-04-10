package com.lvs.Classes;

public class FilialCustomer extends Customer{

    private String contactPerson;

    public FilialCustomer(String filialName, String location) {
        super(filialName, location);
    }

    public FilialCustomer(String filialName, String location, String contactPerson) {
        super(filialName, location);
        this.contactPerson = contactPerson;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

}
