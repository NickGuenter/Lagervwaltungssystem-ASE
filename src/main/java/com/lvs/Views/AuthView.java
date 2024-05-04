package com.lvs.Views;

import java.util.Scanner;

import com.lvs.Authentication;
import com.lvs.Classes.User;
import com.lvs.Language.LanguageControl;

public class AuthView {
    private Authentication auth;

    public AuthView(Authentication auth) {
        this.auth = auth;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. " + LanguageControl.getTranslation("login"));
            System.out.println("2. " + LanguageControl.getTranslation("register"));
            System.out.println("3. " + LanguageControl.getTranslation("exit"));
            System.out.println();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    User user = auth.login();
                    if (user != null) {
                        return;
                    }
                    break;
                case "2":
                    auth.register();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
    }
}