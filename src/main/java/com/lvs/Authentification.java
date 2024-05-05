package com.lvs;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.lvs.Classes.User;

public class Authentification {
    private Map<String, User> users;

    public Authentification() {
        users = new HashMap<>();

        register("Nick", "Nick2001");
    }


    public User getUser(String username) {
        return users.get(username);
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

    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }

        if (!isValidPassword(password)) {
            return false;
        }

        User user = new User(username, hashPassword(password));
        users.put(username, user);
        return true;
    }
    
    public boolean login(String username, String password) {
        User user = users.get(username);

        if (user != null && user.checkPassword(hashPassword(password))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8
                && password.matches(".*\\d.*") // contains at least one digit
                && password.matches(".*[a-z].*") // contains at least one lowercase letter
                && password.matches(".*[A-Z].*"); // contains at least one uppercase letter
    }
}