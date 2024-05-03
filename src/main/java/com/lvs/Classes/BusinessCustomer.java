package com.lvs.Classes;

import com.lvs.Language.LanguageControl;

public class BusinessCustomer extends Customer{

    private String contactPerson;

    public BusinessCustomer(String businessName, Address location) {
        super(businessName, location);
    }

    public BusinessCustomer(String businessName, Address location, String contactPerson) {
        super(businessName, location);
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
        System.out.println(LanguageControl.getTranslation("businessCustomer") + ": " + name);
        System.out.println(LanguageControl.getTranslation("address") + ": " + getAddress());
        System.out.println(LanguageControl.getTranslation("contactPerson") + ": " + contactPerson);
    }

}
