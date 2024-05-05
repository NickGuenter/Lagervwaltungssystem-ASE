package com.lvs.Language;

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
        german.put("spanish", "Spanisch");
        german.put("chooseLanguage", "Sprache wählen");

        // Main Menu
        german.put("mainMenu", "Hauptmenü");
        german.put("exit", "Beenden");
        german.put("back", "Zurück");

        // Supplier
        german.put("suppliers", "Lieferanten");
        german.put("supplier", "Lieferant");
        german.put("addSupplier", "Lieferant hinzufügen");
        german.put("removeSupplier", "Lieferant entfernen");
        german.put("showSuppliers", "Lieferanten anzeigen");

        // Customer
        german.put("customers", "Kunden");
        german.put("customer", "Kunde");
        german.put("addCustomer", "Kunde hinzufügen");
        german.put("removeCustomer", "Kunde entfernen");
        german.put("showCustomers", "Kunden anzeigen");
        german.put("customerType", "Kundentyp auswählen");
        german.put("branchCustomer", "Filialkunde");
        german.put("businessCustomer", "Geschäftskunde");
        german.put("privateCustomer", "Privatkunde");
        german.put("contactPerson", "Ansprechpartner");
        german.put("customerName", "Name");
        german.put("customerAddress", "Adresse");
        german.put("businessName", "Geschäftsname");
        german.put("filialNr", "Filialnummer");

        // Orders
        german.put("orders", "Bestellungen");
        german.put("buyOrders", "Einkaufsbestellungen");
        german.put("sellOrders", "Verkaufsbestellungen");
        german.put("addOrder", "Bestellung hinzufügen");
        german.put("showOrders", "Bestellungen anzeigen");
        german.put("findOrder", "Bestellung finden");
        german.put("findOrderText", "Suche nach Bestellung durch:");
        german.put("searchParty", "Geben Sie den Namen des Kunden oder Lieferanten ein:");
        german.put("searchProduct", "Geben Sie den Produktnamen ein:");
        german.put("buyOrSell", "Kaufen oder Verkaufen? (k/v)");
        german.put("noProductAdded", "Sie müssen mindestens ein Produkt zur Bestellung hinzufügen!");
        german.put("orderError", "Bestellung konnte nicht erstellt werden!");
        german.put("addProductToOrder", "Produkt hinzufügen? (j/n)");
        german.put("chooseCustomer", "Geben Sie den Kundennamen, Geschäftsname oder Filialnummer ein:");
        german.put("chooseSupplier", "Geben Sie den Lieferantennamen ein:");
        german.put("customerError", "Kunde konnte nicht gefunden werden!");
        german.put("supplierError", "Lieferant konnte nicht gefunden werden!");

        // Reports
        german.put("reports", "Berichte");
        german.put("report", "Bericht");
        german.put("showReports", "Berichte anzeigen");
        german.put("overallReport", "Gesamtbericht");
        german.put("productReport", "Produktbericht");
        german.put("revenueReport", "Umsatzbericht");
        german.put("buy", "Einkauf");
        german.put("sell", "Verkauf");
        german.put("totalRevenue", "Gesamtumsatz");

        // Products & Inventory
        german.put("inventory", "Inventar");
        german.put("showInventory", "Inventar anzeigen");
        german.put("stock", "Lager");
        german.put("products", "Produkte");
        german.put("product", "Produkt");
        german.put("productName", "Name");
        german.put("productPrice", "Preis");
        german.put("productQuantity", "Menge");
        german.put("addProduct", "Produkt hinzufügen");
        german.put("removeProduct", "Produkt entfernen");
        german.put("editProduct", "Produkt bearbeiten");
        german.put("removeAmount", "Menge eingeben oder 'x' für alle:");
        german.put("showProducts", "Produkte anzeigen");
        german.put("newProductName", "Neuen Produktnamen eingeben:");
        german.put("newProductPrice", "Neuen Produktpreis eingeben:");
        german.put("newProductQuantity", "Neue Produktmenge eingeben:");

        // Authentication
        german.put("authentication", "Authentifizierung");
        german.put("login", "Anmelden");
        german.put("register", "Registrieren");
        german.put("username", "Benutzername");
        german.put("password", "Passwort");
        german.put("loginSuccessful", "Anmeldung erfolgreich!");
        german.put("loginFailed", "Anmeldung fehlgeschlagen!");
        german.put("registerSuccessful", "Registrierung erfolgreich!");
        german.put("usernameExists", "Benutzername existiert bereits. Bitte wählen Sie einen anderen.");
        german.put("invalidPassword", "Ungültiges Passwort. Es muss mindestens 8 Zeichen lang sein und mindestens eine Ziffer, einen Kleinbuchstaben und einen Großbuchstaben enthalten.");
    }

    public static Map<String, String> getLanguage() {
        return german;
    }
}