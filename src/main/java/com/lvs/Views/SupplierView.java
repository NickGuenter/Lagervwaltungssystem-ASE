package com.lvs.Views;

import com.lvs.Printer;
import com.lvs.Classes.Address;
import com.lvs.Language.LanguageControl;
import com.lvs.Manager.SupplierManager;

public class SupplierView implements View {
    SupplierManager supplierManager;

    public SupplierView(SupplierManager supplierManager) {
        this.supplierManager = supplierManager;
    }

    public void show() {

        while (true) {
            Printer.printSupplierMenu();

            String eingabe = System.console().readLine();

            if (eingabe.equals("1")) {
                System.out.println(LanguageControl.getTranslation("addSupplier"));
                System.out.println(LanguageControl.getTranslation("customerName"));
                String name = System.console().readLine();
                System.out.println(LanguageControl.getTranslation("customerAddress"));
                String address = System.console().readLine();
                System.out.println(LanguageControl.getTranslation("contactPerson"));
                String contact = System.console().readLine();

                supplierManager.addSupplier(name, new Address(address), contact);
            } else if (eingabe.equals("2")) {
                Printer.printSuppliers(supplierManager);
            } else if (eingabe.equals("3")) {
                System.out.println(LanguageControl.getTranslation("removeSupplier"));
                System.out.println(LanguageControl.getTranslation("customerName"));
                String name = System.console().readLine();

                supplierManager.removeSupplier(name);
            } else if (eingabe.equals("4")) {
                break;
            } else {
                System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
    }
}
