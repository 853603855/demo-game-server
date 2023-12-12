package com.example.game.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHashUtils {

    private static final String PASSWORD_ALGORITHM = "SHA-256";

    // 哈希密码
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = salt + password;
        MessageDigest md = MessageDigest.getInstance(PASSWORD_ALGORITHM);
        byte[] hashedPassword = md.digest(saltedPassword.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    // 验证密码
    public static boolean verifyPassword(String password, String salt, String hashedPassword) throws NoSuchAlgorithmException {
        String hashedInput = hashPassword(password, salt);
        return hashedInput.equals(hashedPassword);
    }
}
