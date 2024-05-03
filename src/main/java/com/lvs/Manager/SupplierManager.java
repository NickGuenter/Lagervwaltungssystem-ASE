package com.lvs.Manager;

import java.util.ArrayList;

import com.lvs.Classes.Address;
import com.lvs.Classes.Supplier;

public class SupplierManager {

    ArrayList<Supplier> suppliers;
    
    public SupplierManager() {
        suppliers = new ArrayList<Supplier>();
        suppliers.add(new Supplier("DE Logistics", new Address("Hamburg"), "Hans Meier"));
        suppliers.add(new Supplier("NL Transport", new Address("Amsterdam"), "Jan Jansen"));
        suppliers.add(new Supplier("FR Express", new Address("Paris"), "Pierre Dupont"));
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public void addSupplier(String name, Address address, String contact) {
        Supplier supplier = new Supplier(name, address, contact);
        suppliers.add(supplier);
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

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
}
