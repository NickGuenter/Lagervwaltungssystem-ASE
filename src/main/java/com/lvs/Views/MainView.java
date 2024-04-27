package com.lvs.Views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// public class MainView {

//     InventoryView inventoryView;
//     ReportView reportView;
//     SupplierView supplierView;
//     OrderView orderView;
//     CustomerView customerView;

//     public MainView(OrderView orderView, InventoryView inventoryView, ReportView reportView,
//             SupplierView supplierView) {
//         this.orderView = orderView;
//         this.inventoryView = inventoryView;
//         this.reportView = reportView;
//         this.supplierView = supplierView;
//     }

//     public void show() {
//         Scanner scanner = new Scanner(System.in);

//         while (true) {
//             System.out.println("Willkommen im LVS!");
//             System.out.println("1: Bestellungen.");
//             System.out.println("2: Lagerbestand.");
//             System.out.println("3: Reports.");
//             System.out.println("4: Lieferanten.");
//             System.out.println("5: Kunden.");
//             System.out.println("6: Programm beenden.");

//             String eingabe = scanner.nextLine();

//             if (eingabe.equals("1")) {
//                 orderView.show();
//             } else if (eingabe.equals("2")) {
//                 inventoryView.show();
//             } else if (eingabe.equals("3")) {
//                 reportView.show();
//             } else if (eingabe.equals("4")) {
//                 supplierView.show();
//             } else if (eingabe.equals("5")) {
//                 customerView.show();
//             } else if (eingabe.equals("6")) {
//                 break;
//             } else {
//                 System.out.println("Ungültige Eingabe!");
//             }
//         }
//         scanner.close();
//     }
// }

public class MainView {
    private Map<String, View> views;

    public MainView(OrderView orderView, InventoryView inventoryView, ReportView reportView, SupplierView supplierView, CustomerView customerView) {
        views = new HashMap<>();
        views.put("1", orderView);
        views.put("2", inventoryView);
        views.put("3", reportView);
        views.put("4", supplierView);
        views.put("5", customerView);
        // add other views
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Willkommen im LVS!");
            System.out.println("1: Bestellungen.");
            System.out.println("2: Lagerbestand.");
            System.out.println("3: Reports.");
            System.out.println("4: Lieferanten.");
            System.out.println("5: Kunden.");
            System.out.println("6: Programm beenden.");

            String eingabe = scanner.nextLine();

            View view = views.get(eingabe);
            if (view != null) {
                view.show();
            } else if (eingabe.equals("6")) {
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
        scanner.close();
    }
}