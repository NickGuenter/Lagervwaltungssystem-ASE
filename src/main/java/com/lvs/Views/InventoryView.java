package com.lvs.Views;

import java.util.Scanner;

import com.lvs.Manager.ProductManager;
import com.lvs.Classes.Product;

public class InventoryView implements View {
    ProductManager productManager;
    Scanner scanner;

    public InventoryView(ProductManager productManager) {
        this.productManager = productManager;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {

            System.out.println("Inventar: ");
            System.out.println("1: Inventar anzeigen");
            System.out.println("2: Produkt hinzufügen");
            System.out.println("3: Produkt entfernen");
            System.out.println("4: Produkt bearbeiten");
            System.out.println("5: Zurück");

            String name = "";
            String price = "0";
            String quantity = "0";

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    productManager.printInventory();
                    calculateTotal();
                    break;
                case 2:
                    System.out.println("Produkt hinzufügen");
                    try {
                        System.out.println("Produktname: ");
                        name = scanner.next();
                        System.out.println("Preis: ");
                        price = scanner.next();
                        System.out.println("Menge: ");
                        quantity = scanner.next();

                        productManager.addProduct(new Product(name, Double.valueOf(price), Integer.valueOf(quantity)));
                    } catch (Exception e) {
                        System.out.println("Fehler: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Produkt entfernen");
                    try {
                        System.out.println("Produktname: ");
                        name = scanner.next();
                        System.out.println("Menge oder 'x' für alle:");
                        quantity = scanner.next();

                        Product oldProduct = productManager.getProductByName(name);

                        double tmpPrice = oldProduct.getProductValue();

                        if (quantity.equals("x")) {
                            productManager.removeProduct(oldProduct);
                        } else {
                            Product product = new Product(name, tmpPrice, Integer.valueOf(quantity));
                            productManager.removeProduct(product);
                        }
                    } catch (Exception e) {
                        System.out.println("Fehler: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Produkt bearbeiten");
                    try {
                        System.out.println("Produktname des gesuchten Artikels: ");
                        name = scanner.next();
                        Product product = productManager.getProductByName(name);

                        System.out.println("1: Preis bearbeiten");
                        System.out.println("2: Menge bearbeiten");
                        System.out.println("3: Produktname bearbeiten");

                        int editInput = scanner.nextInt();

                        switch (editInput) {
                            case 1:
                                System.out.println("Neuer Preis: ");
                                price = scanner.next();
                                product.setProductValue(Double.valueOf(price));
                                break;
                            case 2:
                                System.out.println("Neue Menge: ");
                                quantity = scanner.next();
                                product.setProductQuantity(Integer.valueOf(quantity));
                                break;
                            case 3:
                                System.out.println("Neuer Produktname: ");
                                name = scanner.next();
                                product.setProductName(name);
                                break;
                            default:
                                System.out.println("Ungültige Eingabe");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Fehler: " + e.getMessage());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Ungültige Eingabe");
                    break;
            }
        }
    }

    public void calculateTotal() {
        double total = 0;

        for (Product product : productManager.getProducts()) {
            total += product.getProductValue() * product.getProductQuantity();
        }

        System.out.println("Gesamtpreis: " + total);
        System.out.println();
    }
}
