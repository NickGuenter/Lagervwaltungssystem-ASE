package com.lvs.Language;

import java.util.HashMap;
import java.util.Map;

public class LanguageItalian {
    private static Map<String, String> italian = new HashMap<>();

    static {
        // Other
        italian.put("invalidInput", "Input non valido!");
        italian.put("date", "Data");

        // Language
        italian.put("language", "Lingua");
        italian.put("english", "Inglese");
        italian.put("german", "Tedesco");
        italian.put("spanish", "Spagnolo");
        italian.put("italian", "Italiano");
        italian.put("french", "Francese");
        italian.put("chooseLanguage", "Scegliere la lingua");

        // Main Menu
        italian.put("mainMenu", "Menu principale");
        italian.put("exit", "Uscita");
        italian.put("back", "Indietro");

        // Supplier
        italian.put("suppliers", "Fornitori");
        italian.put("supplier", "Fornitore");
        italian.put("addSupplier", "Aggiungi fornitore");
        italian.put("removeSupplier", "Rimuovi fornitore");
        italian.put("showSuppliers", "Mostra fornitori");

        // Customer
        italian.put("customers", "Clienti");
        italian.put("customer", "Cliente");
        italian.put("addCustomer", "Aggiungi cliente");
        italian.put("removeCustomer", "Rimuovi cliente");
        italian.put("showCustomers", "Mostra clienti");
        italian.put("customerType", "Seleziona tipo cliente");
        italian.put("branchCustomer", "Cliente filiale");
        italian.put("businessCustomer", "Cliente business");
        italian.put("privateCustomer", "Cliente privato");
        italian.put("contactPerson", "Persona di contatto");
        italian.put("customerName", "Nome");
        italian.put("customerAddress", "Indirizzo");
        italian.put("businessName", "Nome azienda");
        italian.put("filialNr", "Numero filiale");

        // Orders
        italian.put("orders", "Ordini");
        italian.put("buyOrders", "Ordini di acquisto");
        italian.put("sellOrders", "Ordini di vendita");
        italian.put("addOrder", "Aggiungi ordine");
        italian.put("showOrders", "Mostra ordini");
        italian.put("findOrder", "Trova ordine");
        italian.put("findOrderText", "Cerca ordine per:");
        italian.put("searchParty", "Inserisci nome cliente o fornitore:");
        italian.put("searchProduct", "Inserisci nome prodotto:");
        italian.put("buyOrSell", "Acquistare o vendere? (a/v)");
        italian.put("noProductAdded", "Devi aggiungere almeno un prodotto all'ordine!");
        italian.put("orderError", "Impossibile creare l'ordine!");
        italian.put("addProductToOrder", "Aggiungere un prodotto? (s/n)");
        italian.put("chooseCustomer", "Inserisci nome cliente, nome azienda o numero filiale:");
        italian.put("chooseSupplier", "Inserisci nome fornitore:");
        italian.put("customerError", "Cliente non trovato!");
        italian.put("supplierError", "Fornitore non trovato!");

        // Reports
        italian.put("reports", "Rapporti");
        italian.put("report", "Rapporto");
        italian.put("showReports", "Mostra rapporti");
        italian.put("overallReport", "Rapporto generale");
        italian.put("productReport", "Rapporto prodotto");
        italian.put("revenueReport", "Rapporto ricavi");
        italian.put("buy", "Acquisto");
        italian.put("sell", "Vendita");
        italian.put("totalRevenue", "Ricavo totale");

        // Products & Inventory
        italian.put("inventory", "Inventario");
        italian.put("showInventory", "Mostra inventario");
        italian.put("stock", "Scorta");
        italian.put("products", "Prodotti");
        italian.put("product", "Prodotto");
        italian.put("productName", "Nome");
        italian.put("productPrice", "Prezzo");
        italian.put("productQuantity", "Quantità");
        italian.put("addProduct", "Aggiungi prodotto");
        italian.put("removeProduct", "Rimuovi prodotto");
        italian.put("editProduct", "Modifica prodotto");
        italian.put("removeAmount", "Inserisci quantità o 'x' per rimuovere tutto:");
        italian.put("showProducts", "Mostra prodotti");
        italian.put("newProductName", "Inserisci il nuovo nome del prodotto:");
        italian.put("newProductPrice", "Inserisci il nuovo prezzo del prodotto:");
        italian.put("newProductQuantity", "Inserisci la nuova quantità del prodotto:");

        // Authentication
        italian.put("authentication", "Autenticazione");
        italian.put("login", "Accedi");
        italian.put("register", "Registrati");
        italian.put("username", "Nome utente");
        italian.put("password", "Password");
        italian.put("loginSuccessful", "Accesso riuscito!");
        italian.put("loginFailed", "Accesso fallito!");
        italian.put("registerSuccessful", "Registrazione riuscita!");
        italian.put("usernameExists", "Il nome utente esiste già. Scegline un altro.");
        italian.put("invalidPassword", "Password non valida. Deve contenere almeno 8 caratteri e almeno un numero, una lettera minuscola e una maiuscola.");
    }

    public static Map<String, String> getLanguage() {
        return italian;
    }
}
