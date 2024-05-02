package com.lvs.Views;

import java.util.Scanner;

import com.lvs.Printer;
import com.lvs.ReportGenerator;

public class ReportView implements View {
    ReportGenerator report;
    Scanner scanner;

    public ReportView(ReportGenerator report) {
        this.report = report;
        scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {
            Printer.printReportMenu();

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
