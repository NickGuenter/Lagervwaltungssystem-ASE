package com.lvs.Views;

import java.util.ArrayList;
import java.util.Scanner;

import com.lvs.Inventory;
import com.lvs.Classes.Order;
import com.lvs.Classes.Party;
import com.lvs.Classes.PrivateCustomer;
import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;
import com.lvs.Manager.CustomerManager;
import com.lvs.Manager.OrderManager;
import com.lvs.Manager.SupplierManager;

public class OrderView implements View{

    OrderManager buyOrders;
    OrderManager sellOrders;
    Inventory inventory;
    CustomerManager customerManager;
    SupplierManager supplierManager;

    public OrderView(OrderManager buyOrders, OrderManager sellOrders, Inventory inventory, CustomerManager customerManager, SupplierManager supplierManager) {
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;
        this.inventory = inventory;
        this.customerManager = customerManager;
        this.supplierManager = supplierManager;

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Wasser", 2, 20));
        buyOrders.addOrder(new Order(new Supplier("ChinaSup", "Hamburg", "Bern Tuni"), products));
        sellOrders.addOrder(new Order(new PrivateCustomer("Hans Hensl", "Hamburg"), products));
    }

    private static final String INVALID_INPUT = "Ungültige Eingabe!";

    public void show() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bestellungen");
            System.out.println("1: Bestellung Anlegen");
            System.out.println("2: Bestellverlauf Anzeigen");
            System.out.println("3: Bestellung suchen");
            System.out.println("4: Zurück");

            String eingabe = scanner.nextLine();

            if (eingabe.equals("1")) {
                createOrder(scanner);
            } else if (eingabe.equals("2")) {
                System.out.println("Kaufbestellungen:");
                buyOrders.getOrders();
                System.out.println("Verkaufbestellungen:");
                sellOrders.getOrders();
            } else if (eingabe.equals("3")) {
                findOrder(scanner);
            } else if (eingabe.equals("4")) {
                break;
            } else {
                System.out.println(INVALID_INPUT);
            }
        }
    }

    private void findOrder(Scanner scanner) {
        System.out.println("Bestellung suchen nach:");
        System.out.println("1: Kunden oder Lieferanten");
        System.out.println("2: Produkt");
        System.out.println("3: Zurück");

        String eingabe = scanner.nextLine();

        switch (eingabe) {
            case "1":
                System.out.println("Kunden- oder Lieferantennamen eingeben:");
                String partyName = scanner.nextLine();
                System.out.println("Bestellsuche nach " + partyName + ":");
                System.out.println("--------------------");
                buyOrders.getOrdersByParty(partyName);
                sellOrders.getOrdersByParty(partyName);
                break;
            case "2":
                System.out.println("Produktname eingeben:");
                String productName = scanner.nextLine();
                System.out.println("Bestellsuche nach " + productName + ":");
                System.out.println("--------------------");
                buyOrders.getOrdersByProduct(productName);
                sellOrders.getOrdersByProduct(productName);
                break;
            case "3":
                break;
            default:
                System.out.println(INVALID_INPUT);
                break;
        }
        System.out.println();
    }

    private void createOrder(Scanner scanner) {
        Party party = null;
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Kauf oder Verkauf? (k/v)");
        String kauf = scanner.nextLine();

        party = inputParty(scanner, kauf);
        if (party == null) {
            System.out.println(INVALID_INPUT);
            return;
        }

        products = addProduct(scanner);
        if (products.isEmpty()) {
            System.out.println("Es muss mindestens ein Produkt hinzugefügt werden!");
            return;
        }

        if (kauf.equals("v")) {
            if (inventory.checkStock(products)) {
                sellOrders.addOrder(new Order(party, products));
                inventory.removeProducts(products);
            } else {
                System.out.println("Bestellung konnte nicht angelegt werden.");
            }
        } else if (kauf.equals("k")) {
            buyOrders.addOrder(new Order(party, products));
            inventory.addProducts(products);
        }

    }

    public ArrayList<Product> addProduct(Scanner scanner) {
        ArrayList<Product> products = new ArrayList<>();
        while (true) {
            System.out.println("Produkt hinzufügen? (j/n)");
            String eingabe = scanner.nextLine();

            if (eingabe.equals("n")) {
                break;
            } else if (eingabe.equals("j")) {
                System.out.println("Produktname eingeben:");
                String productName = scanner.nextLine();
                System.out.println("Produktwert eingeben:");
                double productValue = Double.valueOf(scanner.nextLine());
                System.out.println("Produktmenge eingeben:");
                int productQuantity = Integer.valueOf(scanner.nextLine());

                Product product = new Product(productName, productValue, productQuantity);
                products.add(product);
            } else {
                System.out.println(INVALID_INPUT);
            }
        }
        return products;
    }

    // TODO: Refactor this method
    public Party inputParty(Scanner scanner, String kauf) {
        Party party = null;

        if (kauf.equals("k")) {
            party = chooseSupplier(scanner);
        } else if (kauf.equals("v")) {
            party = chooseCustomer(scanner);
        } 
        return party;
    }

    public Party chooseCustomer(Scanner scanner) {
        customerManager.getCustomers();
        System.out.println("Kundenname, Filial Nummer oder Unternehmen eingeben:");

        String eingabe = scanner.nextLine();
        Party party = customerManager.findCustomer(eingabe);

        if (party != null) {
            return party;
        } else {
            System.out.println(INVALID_INPUT + " oder Kunde nicht gefunden!");
        }
        return party;
    }

    public Party chooseSupplier(Scanner scanner) {
        supplierManager.getSuppliers();
        System.out.println("Lieferanten Name eingeben:");

        String eingabe = scanner.nextLine();
        Party party = supplierManager.findSupplier(eingabe);

        if (party != null) {
            return party;
        } else {
            System.out.println(INVALID_INPUT + " oder Lieferant nicht gefunden!");
        }
        return party;
    }
}