package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.Supplier;

public class SupplierManager {

    ArrayList<Supplier> suppliers;
    
    public SupplierManager() {
        suppliers = new ArrayList<Supplier>();
        suppliers.add(new Supplier("DE Logistics", "Hamburg", "Hans Meier"));
        suppliers.add(new Supplier("NL Transport", "Amsterdam", "Jan Jansen"));
        suppliers.add(new Supplier("FR Express", "Paris", "Pierre Dupont"));
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public void addSupplier(String name, String address, String contact) {
        Supplier supplier = new Supplier(name, address, contact);
        suppliers.add(supplier);
    }

    public void getSuppliers() {
        System.out.println("Lieferanten:");
        System.out.println("-------------");
        System.out.println();
        for (Supplier supplier : suppliers) {
            supplier.print();      
            System.out.println();
        }
        System.out.println("-------------");
        System.out.println();
    }

    public Supplier findSupplier(String name) {
        for (Supplier supplier : suppliers) {
            if (supplier.getName().equals(name)) {
                return supplier;
            }
        }
        return null;
    }

    public void removeSupplier(String name) {
        Supplier supplier = findSupplier(name);
        if (supplier != null) {
            suppliers.remove(supplier);
        }
    }
}
