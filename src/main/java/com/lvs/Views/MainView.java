package com.lvs.Views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView implements View {
    private Map<String, View> views;
    private Map<View, String> viewsText;

    public MainView(OrderView orderView, InventoryView inventoryView, ReportView reportView, SupplierView supplierView,
            CustomerView customerView) {
                
        viewsText = new HashMap<>();
        viewsText.put(orderView, "Bestellungen");
        viewsText.put(inventoryView, "Lagerbestand");
        viewsText.put(reportView, "Reports");
        viewsText.put(supplierView, "Lieferanten");
        viewsText.put(customerView, "Kunden");

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
            System.out.println("Hauptmenü");
            views.forEach((key, value) -> System.out.println(key + ": " + viewsText.get(value)));
            System.out.println("x: Beenden");

            String eingabe = scanner.nextLine();

            View view = views.get(eingabe);
            if (view != null) {
                view.show();
            } else if (eingabe.equals("x")) {
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        scanner.close();
    }
}