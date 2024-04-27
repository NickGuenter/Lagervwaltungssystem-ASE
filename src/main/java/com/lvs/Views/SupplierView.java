package com.lvs.Views;

import com.lvs.Manager.SupplierManager;

public class SupplierView implements View {
    SupplierManager supplierManager;

    public SupplierView(SupplierManager supplierManager) {
        this.supplierManager = supplierManager;
    }

    public void show() {

        while (true) {
            System.out.println("Lieferantenmenu");
            System.out.println("1: Lieferant anlegen");
            System.out.println("2: Lieferanten anzeigen");
            System.out.println("3: Lieferanten löschen");
            System.out.println("4: Zurück");
            System.out.println();

            String eingabe = System.console().readLine();

            if (eingabe.equals("1")) {
                System.out.println("Lieferant anlegen");
                System.out.println("Name:");
                String name = System.console().readLine();
                System.out.println("Adresse:");
                String address = System.console().readLine();
                System.out.println("Kontakt:");
                String contact = System.console().readLine();

                supplierManager.addSupplier(name, address, contact);
            } else if (eingabe.equals("2")) {
                supplierManager.getSuppliers();
            } else if (eingabe.equals("3")) {
                System.out.println("Lieferant löschen");
                System.out.println("Name:");
                String name = System.console().readLine();

                supplierManager.removeSupplier(name);
            } else if (eingabe.equals("4")) {
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
    }
}
