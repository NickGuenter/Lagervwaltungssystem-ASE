package com.lvs.Classes;

import java.util.UUID;

public class Supplier extends Party{

    private UUID supplierId;
    private String supllierName;
    private String location;
    private String contact;
    
    public Supplier(String supllierName, String location, String contact) {
        super(supllierName); // Add this line to invoke the superclass constructor
        supplierId = java.util.UUID.randomUUID();
        this.supllierName = supllierName;
        this.location = location;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

}
