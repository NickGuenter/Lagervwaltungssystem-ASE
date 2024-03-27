package com.lvs.Views;

import java.util.ArrayList;
import java.util.Scanner;

import com.lvs.Classes.Order;
import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;
import com.lvs.Manager.OrderManager;

public class OrderView {

    OrderManager orderManager = new OrderManager();

    public void show() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bestellungen");
            System.out.println("1: Order Anlegen");
            System.out.println("2: Order Anzeigen");
            System.out.println("3: Zurück");
            String eingabe = scanner.nextLine();

            if (eingabe.equals("1")) {

                // Produkt anlegen
                System.out.println("Produkt anlegen");
                System.out.println("Produktname eingeben:");
                String productName = scanner.nextLine();
                System.out.println("Produktwert eingeben:");
                double productValue = Double.valueOf(scanner.nextLine());
                System.out.println("Produktmenge eingeben:");
                int productQuantity = Integer.valueOf(scanner.nextLine());

                Product product = new Product(productName, productValue, productQuantity);
                ArrayList<Product> products = new ArrayList<>();
                products.add(product);

                System.out.println();

                // Testweise Supplier vorgegeben
                Supplier supplier = new Supplier("AT Logistics", "Österreich", "Stefan Kinzl");
                System.out.println("Supplier bereits ausgewählt.");

                // Order anlegen
                orderManager.addOrder(new Order(supplier, products));
                // break;
            } else if (eingabe.equals("2")) {
                orderManager.getOrders();
                // break;
            } else if (eingabe.equals("3")) {
                break;
            }
        }
    }
}
