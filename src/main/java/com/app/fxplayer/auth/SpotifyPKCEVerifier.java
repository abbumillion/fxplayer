package com.app.fxplayer.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SpotifyPKCEVerifier {
        private static final String CODE_VERIFIER_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._~";
        private static final int CODE_VERIFIER_LENGTH = 128;
//        public static void main(String[] args) {
//            String codeVerifier = generateCodeVerifier();
//            System.out.println("Code Verifier: " + codeVerifier);
//            String codeChallenge = generateCodeChallenge(codeVerifier);
//            System.out.println("Code Challenge: " + codeChallenge);
//        }
        private static String generateCodeVerifier() {
            SecureRandom secureRandom = new SecureRandom();
            StringBuilder stringBuilder = new StringBuilder(CODE_VERIFIER_LENGTH);
            for (int i = 0; i < CODE_VERIFIER_LENGTH; i++) {
                int randomIndex = secureRandom.nextInt(CODE_VERIFIER_CHARS.length());
                stringBuilder.append(CODE_VERIFIER_CHARS.charAt(randomIndex));
            }
            return stringBuilder.toString();
        }
        private static String generateCodeChallenge(String codeVerifier) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(codeVerifier.getBytes());
                byte[] digestBytes = messageDigest.digest();
                return Base64.getUrlEncoder().withoutPadding().encodeToString(digestBytes);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
}
