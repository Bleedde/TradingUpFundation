package com.trading.TradingUpFundationBackend.utils.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SecretEncryption {
    public static String encrypt(String secret, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(secret.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedSecret, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedSecret);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        String secret = "ThisIsASecret";
        SecretKey key = new SecretKeySpec("YourSecretKey".getBytes(), "AES");

        // Encrypt the secret
        String encryptedSecret = encrypt(secret, key);
        System.out.println("Encrypted: " + encryptedSecret);

        // Decrypt the secret
        String decryptedSecret = decrypt(encryptedSecret, key);
        System.out.println("Decrypted: " + decryptedSecret);
    }
}