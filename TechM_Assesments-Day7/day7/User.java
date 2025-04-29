package day7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
    private String name;
    private String email;
    private String password;  // Encrypted password

    // Constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = encryptPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public String getUserData() {
        return name + "," + email + "," + password;
    }

    // ✅ Fix: Correctly define encryptPassword() method
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("⚠ Error encrypting password!", e);
        }
    }
}