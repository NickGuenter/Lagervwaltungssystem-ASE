package com.lvs.Classes;

public class BusinessCustomer extends Customer{

    private String contactPerson;

    public BusinessCustomer(String businessName, String location) {
        super(businessName, location);
    }

    public BusinessCustomer(String businessName, String location, String contactPerson) {
        super(businessName, location);
        this.contactPerson = contactPerson;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

}
