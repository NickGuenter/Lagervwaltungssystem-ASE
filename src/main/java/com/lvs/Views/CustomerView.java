package com.lvs.Views;

import com.lvs.Printer;
import com.lvs.Classes.Address;
import com.lvs.Language.LanguageControl;
import com.lvs.Manager.CustomerManager;

public class CustomerView implements View {

    CustomerManager customerManager;

    public CustomerView(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public void show() {
        while (true) {
            Printer.printCustomerMenu();

            String eingabe = System.console().readLine();

            if (eingabe.equals("1")) {
                addCustomer(eingabe);
            } else if (eingabe.equals("2")) {
                Printer.printCustomers(customerManager);
            } else if (eingabe.equals("3")) {
                removeCustomer();
            } else if (eingabe.equals("4")) {
                break;
            } else {
                System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
    }

    private void removeCustomer() {
        System.out.println(LanguageControl.getTranslation("removeCustomer"));
        System.out.println(LanguageControl.getTranslation("customerName"));
        String name = System.console().readLine();

        customerManager.removeCustomer(name);
    }

    private void addCustomer(String eingabe) {
        System.out.println(LanguageControl.getTranslation("customerType"));
        System.out.println("1: " + LanguageControl.getTranslation("branchCustomer"));
        System.out.println("2: " + LanguageControl.getTranslation("businessCustomer"));
        System.out.println("3: " + LanguageControl.getTranslation("privateCustomer"));

        eingabe = System.console().readLine();

        if (eingabe.equals("1")) {
            addFilialCustomer();
        } else if (eingabe.equals("2")) {
            addBusinessCustomer();
        } else if (eingabe.equals("3")) {
            addPrivateCustomer();
        } else {
            System.out.println(LanguageControl.getTranslation("invalidInput"));
        }
    }

    private void addFilialCustomer() {
        System.out.println(LanguageControl.getTranslation("branchCustomer"));
        System.out.println(LanguageControl.getTranslation("filialNr"));
        String filialNr = System.console().readLine();
        System.out.println(LanguageControl.getTranslation("customerAddress"));
        String address = System.console().readLine();
        System.out.println(LanguageControl.getTranslation("contactPerson"));
        String contact = System.console().readLine();

        customerManager.addCustomer("Filial", filialNr, new Address(address), java.util.Optional.of(contact));
    }

    private void addBusinessCustomer() {
        System.out.println(LanguageControl.getTranslation("businessCustomer"));
        System.out.println(LanguageControl.getTranslation("businessName"));
        String name = System.console().readLine();
        System.out.println(LanguageControl.getTranslation("customerAddress"));
        String address = System.console().readLine();
        System.out.println(LanguageControl.getTranslation("contactPerson"));
        String contact = System.console().readLine();

        customerManager.addCustomer("Business", name, new Address(address), java.util.Optional.of(contact));
    }

    private void addPrivateCustomer() {
        System.out.println(LanguageControl.getTranslation("privateCustomer"));
        System.out.println(LanguageControl.getTranslation("customerName"));
        String name = System.console().readLine();
        System.out.println(LanguageControl.getTranslation("customerAddress"));
        String address = System.console().readLine();

        customerManager.addCustomer("Private", name, new Address(address), java.util.Optional.empty());
    }
}
