package com.lvs.Views;

import java.util.Scanner;

import com.lvs.Manager.ProductManager;
import com.lvs.Printer;
import com.lvs.Classes.Product;
import com.lvs.Language.LanguageControl;

public class InventoryView implements View {
    ProductManager productManager;
    Scanner scanner;

    public InventoryView(ProductManager productManager) {
        this.productManager = productManager;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {

            Printer.printInventoryMenu();
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    // productManager.printInventory();
                    Printer.printInventory(productManager);
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    editProduct();
                    break;
                case 5:
                    return;
                default:
                    System.out.println(LanguageControl.getTranslation("invalidInput"));
                    break;
            }
        }
    }

    public void addProduct() {
        System.out.println(LanguageControl.getTranslation("addProduct"));
        try {
            System.out.println(LanguageControl.getTranslation("productName"));
            String name = scanner.next();
            System.out.println(LanguageControl.getTranslation("productPrice"));
            String price = scanner.next();
            System.out.println(LanguageControl.getTranslation("productQuantity"));
            String quantity = scanner.next();

            productManager.addProduct(new Product(name, Double.valueOf(price), Integer.valueOf(quantity)));
        } catch (Exception e) {
            System.out.println(LanguageControl.getTranslation("invalidInput"));
        }
    }

    public void removeProduct() {
        System.out.println(LanguageControl.getTranslation("removeProduct"));
        try {
            System.out.println(LanguageControl.getTranslation("productName"));
            String name = scanner.next();
            System.out.println(LanguageControl.getTranslation("removeAmount"));
            String quantity = scanner.next();

            Product oldProduct = productManager.getProductByName(name);

            double tmpPrice = oldProduct.getProductValue();

            if (quantity.equals("x")) {
                productManager.removeProduct(oldProduct);
            } else {
                Product product = new Product(name, tmpPrice, Integer.valueOf(quantity));
                productManager.removeProduct(product);
            }
        } catch (Exception e) {
            System.out.println(LanguageControl.getTranslation("invalidInput"));
        }
    }

    public void editProduct() {
        System.out.println(LanguageControl.getTranslation("editProduct"));
        try {
            System.out.println(LanguageControl.getTranslation("productName"));
            String name = scanner.next();
            Product product = productManager.getProductByName(name);

            System.out.println("1: " + LanguageControl.getTranslation("productPrice"));
            System.out.println("2: " + LanguageControl.getTranslation("productQuantity"));
            System.out.println("3: " + LanguageControl.getTranslation("productName"));

            int editInput = scanner.nextInt();

            switch (editInput) {
                case 1:
                    System.out.println(LanguageControl.getTranslation("newPrice"));
                    String price = scanner.next();
                    product.setProductValue(Double.valueOf(price));
                    break;
                case 2:
                    System.out.println(LanguageControl.getTranslation("newQuantity"));
                    String quantity = scanner.next();
                    product.setProductQuantity(Integer.valueOf(quantity));
                    break;
                case 3:
                    System.out.println(LanguageControl.getTranslation("newProductName"));
                    name = scanner.next();
                    product.setProductName(name);
                    break;
                default:
                    System.out.println(LanguageControl.getTranslation("invalidInput"));
                    break;
            }
        } catch (Exception e) {
            System.out.println(LanguageControl.getTranslation("invalidInput"));
        }
    }

}
