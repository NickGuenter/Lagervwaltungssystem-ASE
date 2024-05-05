package com.lvs.Views;

import java.io.Console;
import java.util.Scanner;

import com.lvs.Authenticfiation;
import com.lvs.Printer;
import com.lvs.Language.LanguageControl;

public class AuthView {
    private Authenticfiation auth;

    public AuthView(Authenticfiation auth) {
        this.auth = auth;
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Printer.printAuthMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (login()) {
                        System.out.println(LanguageControl.getTranslation("loginSuccessful"));
                        return;
                    }
                    System.out.println(LanguageControl.getTranslation("loginFailed"));
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println(LanguageControl.getTranslation("invalidInput"));
            }
        }
    }

    public void register() {
        Console console = System.console();
        String username, password;

        System.out.println(LanguageControl.getTranslation("username"));
        username = new String(console.readLine());
        System.out.println(LanguageControl.getTranslation("password"));
        password = new String(console.readPassword());
        if(auth.register(username, password)) {
            System.out.println(LanguageControl.getTranslation("registerSuccessful"));
        } else {
            System.out.println(LanguageControl.getTranslation("usernameExists") + " OR " + LanguageControl.getTranslation("invalidPassword"));
        }
    }

    public boolean login() {
        Console console = System.console();
        String username, password;

        System.out.println(LanguageControl.getTranslation("username"));
        username = new String(console.readLine());
        System.out.println(LanguageControl.getTranslation("password"));
        password = new String(console.readPassword());

        return auth.login(username, password);
    }
}