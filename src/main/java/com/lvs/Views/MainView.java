package com.lvs.Views;

import java.util.Scanner;

public class MainView {

    InventoryView inventoryView;
    ReportView reportView;
    SupplierView supplierView;
    OrderView orderView;

    public MainView(OrderView orderView, InventoryView inventoryView, ReportView reportView,
            SupplierView supplierView) {
        this.orderView = orderView;
        this.inventoryView = inventoryView;
        this.reportView = reportView;
        this.supplierView = supplierView;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Willkommen im LVS!");
            System.out.println("1: Bestellungen.");
            System.out.println("2: Lagerbestand.");
            System.out.println("3: Reports.");
            System.out.println("4: Lieferanten.");
            System.out.println("5: Programm beenden.");

            String eingabe = scanner.nextLine();

            if (eingabe.equals("1")) {
                orderView.show();
            } else if (eingabe.equals("2")) {
                inventoryView.show();
            } else if (eingabe.equals("3")) {
                reportView.show();
            } else if (eingabe.equals("4")) {
                supplierView.show();
            } else if (eingabe.equals("5")) {
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        scanner.close();
    }
}
