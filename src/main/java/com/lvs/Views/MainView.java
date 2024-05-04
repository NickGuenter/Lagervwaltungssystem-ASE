package com.lvs.Views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.lvs.Printer;
import com.lvs.Language.LanguageControl;

public class MainView implements IView {
    private Map<String, IView> views;
    private Map<IView, String> viewsText;

    public MainView(OrderView orderView, InventoryView inventoryView, ReportView reportView, SupplierView supplierView,
            CustomerView customerView, LanguageView languageView) {

        initializeViews(orderView, inventoryView, reportView, supplierView, customerView, languageView);

    }

    public void show() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            reloadViews();

            Printer.printMainMenu(views, viewsText);

            String eingabe = scanner.nextLine();

            IView view = views.get(eingabe);
            if (view != null) {
                view.show();
            } else if (eingabe.equals("x")) {
                break;
            } else {
                System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
        scanner.close();
    }

    private void initializeViews(OrderView orderView, InventoryView inventoryView, ReportView reportView,
            SupplierView supplierView, CustomerView customerView, LanguageView languageView) {
        viewsText = new HashMap<>();
        viewsText.put(orderView, LanguageControl.getTranslation("orders"));
        viewsText.put(inventoryView, LanguageControl.getTranslation("inventory"));
        viewsText.put(reportView, LanguageControl.getTranslation("reports"));
        viewsText.put(supplierView, LanguageControl.getTranslation("suppliers"));
        viewsText.put(customerView, LanguageControl.getTranslation("customers"));
        viewsText.put(languageView, LanguageControl.getTranslation("language"));

        views = new HashMap<>();
        views.put("1", orderView);
        views.put("2", inventoryView);
        views.put("3", reportView);
        views.put("4", supplierView);
        views.put("5", customerView);
        views.put("6", languageView);
    }

    public void reloadViews() {
        viewsText.clear();
        viewsText.put(views.get("1"), LanguageControl.getTranslation("orders"));
        viewsText.put(views.get("2"), LanguageControl.getTranslation("inventory"));
        viewsText.put(views.get("3"), LanguageControl.getTranslation("reports"));
        viewsText.put(views.get("4"), LanguageControl.getTranslation("suppliers"));
        viewsText.put(views.get("5"), LanguageControl.getTranslation("customers"));
        viewsText.put(views.get("6"), LanguageControl.getTranslation("language"));
    }
}