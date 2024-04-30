package com.lvs.Views;

import java.util.Scanner;

import com.lvs.Report;

public class ReportView implements View {
    Report report;
    Scanner scanner;

    public ReportView(Report report) {
        this.report = report;
        scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {
            System.out.println("1: Gesamtreport anzeigen.");
            System.out.println("2: Report für ein Produkt anzeigen.");
            System.out.println("3: Umsatzreport.");
            System.out.println("4: Zurück.");

            String eingabe = scanner.nextLine();
            System.out.println();

            switch (eingabe) {
                case "1":
                    report.printOverallReport();
                    break;
                case "2":
                    System.out.println("Produktname eingeben:");
                    String productName = scanner.nextLine();
                    System.out.println();
                    report.printProductReport(productName);
                    break;
                case "3":
                    report.printRevenueReport();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Ungültige Eingabe!");
            }
        }
    }
}
