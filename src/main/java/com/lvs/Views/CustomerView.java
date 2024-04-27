package com.lvs.Views;

import com.lvs.Manager.CustomerManager;

public class CustomerView implements View {

    CustomerManager customerManager;

    public CustomerView(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    private static final String INVALID_INPUT = "Ungültige Eingabe!";

    public void show() {
        while (true) {
            System.out.println("Kundenmenu");
            System.out.println("1: Kunde anlegen");
            System.out.println("2: Kunden anzeigen");
            System.out.println("3: Kunde löschen");
            System.out.println("4: Zurück");
            System.out.println();

            String eingabe = System.console().readLine();

            if (eingabe.equals("1")) {
                addCustomer(eingabe);
            } else if (eingabe.equals("2")) {
                customerManager.getCustomers();
            } else if (eingabe.equals("3")) {
                removeCustomer();
            } else if (eingabe.equals("4")) {
                break;
            } else {
                System.out.println(INVALID_INPUT);
            }
        }
    }

    private void removeCustomer() {
        System.out.println("Kunde löschen");
        System.out.println("Name:");
        String name = System.console().readLine();

        customerManager.removeCustomer(name);
    }

    private void addCustomer(String eingabe) {
        System.out.println("Kundenart auswählen:");
        System.out.println("1: Filialkunde");
        System.out.println("2: Geschäftskunde");
        System.out.println("3: Privatkunde");

        eingabe = System.console().readLine();

        if (eingabe.equals("1")) {
            addFilialCustomer();
        } else if (eingabe.equals("2")) {
            addBusinessCustomer();
        } else if (eingabe.equals("3")) {
            addPrivateCustomer();
        } else {
            System.out.println(INVALID_INPUT);
        }
    }

    private void addFilialCustomer() {
        System.out.println("Filialkunde anlegen");
        System.out.println("Name:");
        String name = System.console().readLine();
        System.out.println("Adresse:");
        String address = System.console().readLine();
        System.out.println("Filiale:");
        String filial = System.console().readLine();

        customerManager.addFilialCustomer(name, address, filial);
    }

    private void addBusinessCustomer() {
        System.out.println("Geschäftskunde anlegen");
        System.out.println("Name:");
        String name = System.console().readLine();
        System.out.println("Adresse:");
        String address = System.console().readLine();
        System.out.println("Ansprechpartner:");
        String contact = System.console().readLine();

        customerManager.addBusinessCustomer(name, address, contact);
    }

    private void addPrivateCustomer() {
        System.out.println("Privatkunde anlegen");
        System.out.println("Name:");
        String name = System.console().readLine();
        System.out.println("Adresse:");
        String address = System.console().readLine();

        customerManager.addPrivateCustomer(name, address);
    }
}
