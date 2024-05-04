package com.lvs;

import java.io.Console;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.lvs.Classes.User;
import com.lvs.Language.LanguageControl;

public class Authentication {
    private Map<String, User> users;

    public Authentication() {
        users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("resource")
    public User login() {
        Console console = System.console();
        String username, password;

        System.out.println("\n" + LanguageControl.getTranslation("username"));
        if (console != null) {
            username = new String(console.readLine());
        } else {
            username = new Scanner(System.in).nextLine();
        }

        System.out.println("\n" + LanguageControl.getTranslation("password"));
        if (console != null) {
            password = hashPassword(new String(console.readPassword()));
        } else {
            password = hashPassword(new Scanner(System.in).nextLine());
        }

        User user = users.get(username);

        if (user != null && user.checkPassword(password)) {
            System.out.println(LanguageControl.getTranslation("loginSuccessful"));
            return user;
        } else {
            System.out.println(LanguageControl.getTranslation("loginFailed"));
            return null;
        }
    }

    public User register() {
        Console console = System.console();
        String username, password;

        do {
            System.out.println("\n" + LanguageControl.getTranslation("username"));
            if (console != null) {
                username = new String(console.readLine());
            } else {
                username = new Scanner(System.in).nextLine();
            }

            if (users.containsKey(username)) {
                System.out.println(LanguageControl.getTranslation("usernameExists"));
                username = null;
            }
        } while (username == null);
        
        do {
            System.out.println("\n" + LanguageControl.getTranslation("password"));
            String inputPassword;
            if (console != null) {
                inputPassword = new String(console.readPassword());
            } else {
                inputPassword = new Scanner(System.in).nextLine();
            }

            if (!isValidPassword(inputPassword)) {
                password = null;
                System.out.println(LanguageControl.getTranslation("invalidPassword"));
            } else {
                password = hashPassword(inputPassword);
            }
        } while (password == null);

        User user = new User(username, password);
        users.put(username, user);
        System.out.println(LanguageControl.getTranslation("registerSuccessful"));
        System.out.println();
        return user;
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8
                && password.matches(".*\\d.*") // contains at least one digit
                && password.matches(".*[a-z].*") // contains at least one lowercase letter
                && password.matches(".*[A-Z].*"); // contains at least one uppercase letter
    }
}