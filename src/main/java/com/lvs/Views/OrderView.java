package com.lvs.Views;

import java.util.ArrayList;
import java.util.Scanner;

import com.lvs.Inventory;
import com.lvs.Classes.FilialCustomer;
import com.lvs.Classes.Order;
import com.lvs.Classes.Party;
import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;
import com.lvs.Manager.OrderManager;

public class OrderView {

    OrderManager buyOrders;
    OrderManager sellOrders;
    Inventory inventory;

    public OrderView(OrderManager buyOrders, OrderManager sellOrders, Inventory inventory) {
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;
        this.inventory = inventory;
    }

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
                System.out.println("Ungültige Eingabe!");
            }
        }
    }

    private void findOrder(Scanner scanner) {
        // TODO
    }

    private void createOrder(Scanner scanner) {
        Party party = null;
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Kauf oder Verkauf? (k/v)");
        String kauf = scanner.nextLine();

        party = inputParty(scanner, kauf);
        if (party == null) {
            System.out.println("Ungültige Eingabe!");
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
                System.out.println("Ungültige Eingabe!");
            }
        }
        return products;
    }

    public Party inputParty(Scanner scanner, String kauf) {
        Party party = null;

        if (kauf.equals("k")) {
            party = new Supplier("AT Logistics", "Österreich", "Stefan Kinzl");
            System.out.println("Supplier bereits ausgewählt.");
        } else if (kauf.equals("v")) {
            party = new FilialCustomer("F01", "Wien");
            System.out.println("Filialkunde bereits ausgewählt.");
        } 
        return party;
    }
}