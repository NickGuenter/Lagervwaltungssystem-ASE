package com.lvs.Views;

import java.util.Scanner;

public class View {

    OrderView orderView = new OrderView();

    public void show() {

        while (true) {
            System.out.println("Willkommen im LVS!");
            System.out.println("1: Bestellungen.");
            System.out.println("2: Programm beenden.");

            Scanner scanner = new Scanner(System.in);

            String eingabe = scanner.nextLine();
            if (eingabe.equals("1")) {
                orderView.show();
            } else if (eingabe.equals("2")) {
                break;
            }
        }
    }
}
