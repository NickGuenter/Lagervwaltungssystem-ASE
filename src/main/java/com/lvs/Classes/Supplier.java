package com.lvs.Classes;

import com.lvs.Language.LanguageControl;

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
        System.out.println(LanguageControl.getTranslation("supplier") + ": " + name);
        System.out.println(LanguageControl.getTranslation("address") + ": " + getAddress());
        System.out.println(LanguageControl.getTranslation("contactPerson") + ": " + contactPerson);
    }

}
