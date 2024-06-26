package com.lvs.Views;

import java.util.ArrayList;
import java.util.Scanner;

import com.lvs.Printer;
import com.lvs.Classes.Address;
import com.lvs.Classes.Order;
import com.lvs.Classes.Party;
import com.lvs.Classes.PrivateCustomer;
import com.lvs.Classes.Product;
import com.lvs.Classes.Report;
import com.lvs.Classes.Supplier;
import com.lvs.Language.LanguageControl;
import com.lvs.Manager.CustomerManager;
import com.lvs.Manager.OrderManager;
import com.lvs.Manager.ProductManager;
import com.lvs.Manager.SupplierManager;

public class OrderView implements IView {

    OrderManager buyOrders;
    OrderManager sellOrders;
    ProductManager productManager;
    CustomerManager customerManager;
    SupplierManager supplierManager;
    Scanner scanner;

    public OrderView(OrderManager buyOrders, OrderManager sellOrders, ProductManager productManager,
            CustomerManager customerManager, SupplierManager supplierManager) {
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;
        this.productManager = productManager;
        this.customerManager = customerManager;
        this.supplierManager = supplierManager;
        this.scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Wasser", 2, 20));
        buyOrders.addOrder(new Order(new Supplier("ChinaSup", new Address("Hamburg"), "Bern Tuni"), products));
        sellOrders.addOrder(new Order(new PrivateCustomer("Hans Hensl", new Address("Hamburg")), products));
    }

    public void show() {
        while (true) {
            Printer.printOrderMenu();

            String eingabe = scanner.nextLine();

            if (eingabe.equals("1")) {
                createOrder();
            } else if (eingabe.equals("2")) {
                Report report = new Report.Builder().reportName("Orders").buyOrders(buyOrders).sellOrders(sellOrders).build();
                report.printReport();
            } else if (eingabe.equals("3")) {
                findOrder();
            } else if (eingabe.equals("4")) {
                break;
            } else {
                System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
    }

    private void findOrder() {
        System.out.println(LanguageControl.getTranslation("findOrderText"));
        System.out.println("1: " + LanguageControl.getTranslation("customer") + "/" + LanguageControl.getTranslation("supplier"));
        System.out.println("2: " + LanguageControl.getTranslation("product"));
        System.out.println("3: " + LanguageControl.getTranslation("date"));
        System.out.println("4: " + LanguageControl.getTranslation("back") + "\n");

        String eingabe = scanner.nextLine();

        switch (eingabe) {
            case "1":
                searchForParty();
                break;
            case "2":
                searchForProduct();
                break;
            case "3":
                searchForDate();
                break;
            case "4":
                searchForMinimumValue();
                break;
            case "5":
                return;
            default:
                System.out.println(LanguageControl.getTranslation("invalidInput"));
                break;
        }
        System.out.println();
    }

    public void searchForParty() {
        System.out.println(LanguageControl.getTranslation("searchParty")); 
        String partyName = scanner.nextLine();

        Printer.printSearchParty(buyOrders, sellOrders, partyName);
    }

    public void searchForProduct() {
        System.out.println(LanguageControl.getTranslation("searchProduct"));
        String productName = scanner.nextLine();
        
        Printer.printSearchProduct(buyOrders, sellOrders, productName);
    }

    public void searchForDate() {
        System.out.println(LanguageControl.getTranslation("date"));
        System.out.println("Day:");
        int day = Integer.valueOf(scanner.nextLine());
        System.out.println("Month:");
        int month = Integer.valueOf(scanner.nextLine());
        System.out.println("Year:");
        int year = Integer.valueOf(scanner.nextLine());

        Printer.printSearchDate(buyOrders, sellOrders, day, month, year);
    }

    public void searchForMinimumValue() {
        System.out.println(LanguageControl.getTranslation("orders"));
        double value = Double.valueOf(scanner.nextLine());

        Printer.printSearchByMinimumValue(buyOrders, sellOrders, value);
    }

    private void createOrder() {
        Party party = null;
        ArrayList<Product> products = new ArrayList<>();

        System.out.println(LanguageControl.getTranslation("buyOrSell"));
        String kauf = scanner.nextLine();

        party = inputParty(kauf);
        if (party == null) {
            return;
        }

        products = addProduct();
        if (products.isEmpty()) {
            System.out.println(LanguageControl.getTranslation("noProductAdded"));
            return;
        }

        if (kauf.equals("v")) {
            if (productManager.checkStock(products)) {
                sellOrders.addOrder(new Order(party, products));
                productManager.removeProducts(products);
            } else {
                System.out.println(LanguageControl.getTranslation("orderError"));
            }
        } else if (kauf.equals("k")) {
            buyOrders.addOrder(new Order(party, products));
            productManager.addProducts(products);
        }
        else {
            System.out.println(LanguageControl.getTranslation("invalidInput"));
        }

    }

    public ArrayList<Product> addProduct() {
        ArrayList<Product> products = new ArrayList<>();
        while (true) {
            System.out.println(LanguageControl.getTranslation("addProductToOrder"));
            String eingabe = scanner.nextLine();

            switch (eingabe) {
                case "n":
                    return products;
                case "j":
                    Product product = createProduct();
                    if (product != null) {
                        products.add(product);
                    }
                    break;
                default:
                    System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
    }

    public Product createProduct() {
        System.out.println(LanguageControl.getTranslation("productName"));
        String productName = scanner.nextLine();
        System.out.println(LanguageControl.getTranslation("productPrice"));
        double productValue;
        try {
            productValue = Double.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(LanguageControl.getTranslation("invalidInput"));
            return null;
        }
        System.out.println(LanguageControl.getTranslation("productQuantity"));
        int productQuantity;
        try {
            productQuantity = Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(LanguageControl.getTranslation("invalidInput"));
            return null;
        }

        return new Product(productName, productValue, productQuantity);
    }

    public Party inputParty(String kauf) {
        Party party = null;

        if (kauf.equals("k")) {
            party = chooseSupplier();
        } else if (kauf.equals("v")) {
            party = chooseCustomer();
        }
        return party;
    }

    public Party chooseCustomer() {
        Printer.printCustomers(customerManager);
        System.out.println(LanguageControl.getTranslation("chooseCustomer"));

        String eingabe = scanner.nextLine();
        Party party = customerManager.findCustomer(eingabe);

        if (party != null) {
            return party;
        } else {
            System.out.println(LanguageControl.getTranslation("customerError"));
        }
        return party;
    }

    public Party chooseSupplier() {
        Printer.printSuppliers(supplierManager);
        System.out.println(LanguageControl.getTranslation("chooseSupplier"));

        String eingabe = scanner.nextLine();
        Party party = supplierManager.findSupplier(eingabe);

        if (party != null) {
            return party;
        } else {
            System.out.println(LanguageControl.getTranslation("supplierError"));
        }
        return party;
    }
}