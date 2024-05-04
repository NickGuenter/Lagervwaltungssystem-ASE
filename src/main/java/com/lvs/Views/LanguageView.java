package com.lvs.Views;

import java.util.Scanner;

import com.lvs.Printer;
import com.lvs.Language.LanguageControl;
import com.lvs.Language.LanguageEnglish;
import com.lvs.Language.LanguageGerman;
import com.lvs.Language.LanguageSpanish;

public class LanguageView implements IView {
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
                case "3":
                    LanguageControl.setLanguageSpanish(LanguageSpanish.getLanguage());
                    return;
                default:
                    System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
    }
}
