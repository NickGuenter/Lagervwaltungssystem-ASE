package com.lvs.Views;

import java.util.Scanner;

public class MainView {

    OrderView orderView = new OrderView();

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Willkommen im LVS!");
            System.out.println("1: Bestellungen.");
            System.out.println("2: Lagerbestand.");
            System.out.println("x: Programm beenden.");

            String eingabe = scanner.nextLine();
            if (eingabe.equals("1")) {
                orderView.show();
            } else if (eingabe.equals("x")) {
                break;
            }
        }
        scanner.close();
    }
}
