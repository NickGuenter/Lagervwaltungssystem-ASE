package com.lvs.Classes;

import com.lvs.Language.LanguageControl;

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
        System.out.println(LanguageControl.getTranslation("filialNr") + ": " + name);
        System.out.println(LanguageControl.getTranslation("customerAddress") + ": " + getAddress());
        System.out.println(LanguageControl.getTranslation("contactPerson") + ": " + contactPerson);
    }
}
