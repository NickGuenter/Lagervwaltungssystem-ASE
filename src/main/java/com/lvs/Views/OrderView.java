package com.lvs.Views;

import java.util.ArrayList;
import java.util.Scanner;

import com.lvs.Classes.Order;
import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;
import com.lvs.Manager.OrderManager;

public class OrderView {

    OrderManager orderManager;

    public OrderView() {
        this.orderManager = new OrderManager();
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
                orderManager.getOrders();
            } 
            else if (eingabe.equals("3")) {
                findOrder(scanner);
            } else if (eingabe.equals("4")) {
                break;
            } else {
                System.out.println("Ungültige Eingabe!");
            }
        }
        // scanner.close();
    }

    private void findOrder(Scanner scanner) {
        
    }

    private void createOrder(Scanner scanner) {
        Supplier supplier;
        ArrayList<Product> products = new ArrayList<>();
        // Testweise Supplier vorgegeben
        supplier = new Supplier("AT Logistics", "Österreich", "Stefan Kinzl");
        System.out.println("Supplier bereits ausgewählt.");

        while (true) {
            // Produkt anlegen
            System.out.println("Neues Produkt hinzufügen? (j/n)");

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

        if (!products.isEmpty() && supplier != null) {
            orderManager.addOrder(new Order(supplier, products));
        }
    }
}