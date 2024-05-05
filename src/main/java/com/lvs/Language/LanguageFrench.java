package com.lvs.Language;

import java.util.HashMap;
import java.util.Map;

public class LanguageFrench {
    private static Map<String, String> french = new HashMap<>();

    static {
        // Other
        french.put("invalidInput", "Entrée invalide!");
        french.put("date", "Date");

        // Language
        french.put("language", "Langue");
        french.put("english", "Anglais");
        french.put("german", "Allemand");
        french.put("spanish", "Espagnol");
        french.put("french", "Français");
        french.put("italian", "Italien");
        french.put("chooseLanguage", "Choisir la langue");

        // Main Menu
        french.put("mainMenu", "Menu principal");
        french.put("exit", "Quitter");
        french.put("back", "Retour");

        // Supplier
        french.put("suppliers", "Fournisseurs");
        french.put("supplier", "Fournisseur");
        french.put("addSupplier", "Ajouter un fournisseur");
        french.put("removeSupplier", "Supprimer le fournisseur");
        french.put("showSuppliers", "Afficher les fournisseurs");

        // Customer
        french.put("customers", "Clients");
        french.put("customer", "Client");
        french.put("addCustomer", "Ajouter un client");
        french.put("removeCustomer", "Supprimer le client");
        french.put("showCustomers", "Afficher les clients");
        french.put("customerType", "Choisir le type de client");
        french.put("branchCustomer", "Client filial");
        french.put("businessCustomer", "Client professionnel");
        french.put("privateCustomer", "Client privé");
        french.put("contactPerson", "Personne de contact");
        french.put("customerName", "Nom");
        french.put("customerAddress", "Adresse");
        french.put("businessName", "Nom de l'entreprise");
        french.put("filialNr", "Numéro de filial");

        // Orders
        french.put("orders", "Commandes");
        french.put("buyOrders", "Commandes d'achat");
        french.put("sellOrders", "Commandes de vente");
        french.put("addOrder", "Ajouter une commande");
        french.put("showOrders", "Afficher les commandes");
        french.put("findOrder", "Trouver une commande");
        french.put("findOrderText", "Rechercher une commande par:");
        french.put("searchParty", "Entrez le nom du client ou du fournisseur:");
        french.put("searchProduct", "Entrez le nom du produit:");
        french.put("buyOrSell", "Acheter ou vendre? (a/v)");
        french.put("noProductAdded", "Vous devez ajouter au moins un produit à la commande!");
        french.put("orderError", "Impossible de créer la commande!");
        french.put("addProductToOrder", "Ajouter un produit? (o/n)");
        french.put("chooseCustomer", "Entrez le nom du client, le nom de l'entreprise ou le numéro de filial:");
        french.put("chooseSupplier", "Entrez le nom du fournisseur:");
        french.put("customerError", "Client introuvable!");
        french.put("supplierError", "Fournisseur introuvable!");

        // Reports
        french.put("reports", "Rapports");
        french.put("report", "Rapport");
        french.put("showReports", "Afficher les rapports");
        french.put("overallReport", "Rapport global");
        french.put("productReport", "Rapport produit");
        french.put("revenueReport", "Rapport de revenus");
        french.put("buy", "Achat");
        french.put("sell", "Vente");
        french.put("totalRevenue", "Revenu total");

        // Products & Inventory
        french.put("inventory", "Inventaire");
        french.put("showInventory", "Afficher l'inventaire");
        french.put("stock", "Stock");
        french.put("products", "Produits");
        french.put("product", "Produit");
        french.put("productName", "Nom");
        french.put("productPrice", "Prix");
        french.put("productQuantity", "Quantité");
        french.put("addProduct", "Ajouter un produit");
        french.put("removeProduct", "Supprimer un produit");
        french.put("editProduct", "Modifier un produit");
        french.put("removeAmount", "Entrez la quantité ou 'x' pour tout supprimer:");
        french.put("showProducts", "Afficher les produits");
        french.put("newProductName", "Entrez le nouveau nom du produit:");
        french.put("newProductPrice", "Entrez le nouveau prix du produit:");
        french.put("newProductQuantity", "Entrez la nouvelle quantité du produit:");

        // Authentication
        french.put("authentication", "Authentification");
        french.put("login", "Se connecter");
        french.put("register", "S'inscrire");
        french.put("username", "Nom d'utilisateur");
        french.put("password", "Mot de passe");
        french.put("loginSuccessful", "Connexion réussie!");
        french.put("loginFailed", "Échec de la connexion!");
        french.put("registerSuccessful", "Inscription réussie!");
        french.put("usernameExists", "Le nom d'utilisateur existe déjà. Veuillez en choisir un autre.");
        french.put("invalidPassword", "Mot de passe invalide. Il doit contenir au moins 8 caractères et au moins un chiffre, une lettre minuscule et une lettre majuscule.");
    }

    public static Map<String, String> getLanguage() {
        return french;
    }
}
