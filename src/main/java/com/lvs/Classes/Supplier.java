package com.lvs.Classes;

import java.util.UUID;

public class Supplier extends Party{

    private UUID supplierId;
    private String supllierName;
    private String location;
    private String contactPerson;
    
    public Supplier(String supllierName, String location, String contactPerson) {
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

    public String getLocation() {
        return location;
    }

    public String getContactPerson() {
        return contactPerson;
    }

}
