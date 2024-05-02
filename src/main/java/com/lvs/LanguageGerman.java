package com.lvs;

import java.util.HashMap;
import java.util.Map;

public class LanguageGerman {
    private static Map<String, String> german = new HashMap<>();

    static {
        // Other
        german.put("invalidInput", "Ungültige Eingabe!");

        // Language
        german.put("language", "Sprache");
        german.put("english", "Englisch");
        german.put("german", "Deutsch");
        german.put("chooseLanguage", "Sprache wählen");

        // Main Menu
        german.put("mainMenu", "Hauptmenü");
        german.put("exit", "Beenden");
        german.put("back", "Zurück");

        // Supplier
        german.put("suppliers", "Lieferanten");
        german.put("addSupplier", "Lieferant hinzufügen");
        german.put("removeSupplier", "Lieferant entfernen");
        german.put("showSuppliers", "Lieferanten anzeigen");

        // Customer
        german.put("customers", "Kunden");
        german.put("addCustomer", "Kunde hinzufügen");
        german.put("removeCustomer", "Kunde entfernen");
        german.put("showCustomers", "Kunden anzeigen");
        german.put("customerType", "Kundenart auswählen");
        german.put("branchCustomer", "Filialkunde");
        german.put("businessCustomer", "Geschäftskunde");
        german.put("privateCustomer", "Privatkunde");
        german.put("contactPerson", "Ansprechpartner");
        german.put("customerName", "Name");
        german.put("customerAddress", "Adresse");
        german.put("businessName", "Firmenname");
        german.put("filialNr", "Filialnummer");

        // Orders
        german.put("orders", "Bestellungen");
        german.put("addOrder", "Bestellung hinzufügen");
        german.put("showOrders", "Bestellungen anzeigen");

        // Inventory
        german.put("inventory", "Inventar");
        german.put("showInventory", "Inventar anzeigen");
        german.put("stock", "Lagerbestand");

        // Reports
        german.put("reports", "Reports");
        german.put("showReports", "Reports anzeigen");
        german.put("overallReport", "Gesamtbericht");
        german.put("productReport", "Produktbericht");
        german.put("revenueReport", "Umsatzbericht");

        // Products
        german.put("products", "Produkte");
        german.put("addProduct", "Produkt hinzufügen");
        german.put("removeProduct", "Produkt entfernen");
        german.put("showProducts", "Produkte anzeigen");
        german.put("searchProduct", "Produkt suchen");
        german.put("product", "Produkt");
        german.put("productName", "Name");
        german.put("productPrice", "Preis");
        german.put("productQuantity", "Menge");
    }

    public static Map<String, String> getLanguage() {
        return german;
    }
}
