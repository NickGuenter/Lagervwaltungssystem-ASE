package com.lvs.Views;

import java.util.Scanner;

import com.lvs.LanguageControl;
import com.lvs.LanguageEnglish;
import com.lvs.LanguageGerman;
import com.lvs.Printer;

public class LanguageView implements View {
    Scanner scanner;
    
    public LanguageView() {
        scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {
            Printer.printLanguageMenu();
            String eingabe = scanner.nextLine();

            switch (eingabe) {
                case "1":
                    LanguageControl.setLanguageEnglish(LanguageEnglish.getLanguage());
                    return;
                case "2":
                    LanguageControl.setLanguageGerman(LanguageGerman.getLanguage());
                    return;
                default:
                    System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
    }
}
