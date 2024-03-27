package com.lvs.Classes;

import java.util.UUID;

public class Supplier {

    private UUID supplierId;
    private String supllierName;
    private String location;
    private String contact;
    
    public Supplier(String supllierName, String location, String contact) {
        supplierId = java.util.UUID.randomUUID();
        this.supllierName = supllierName;
        this.location = location;
        this.contact = contact;
    }

    public UUID getSupplierId() {
        return supplierId;
    }

    public String getSupllierName() {
        return supllierName;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

}
