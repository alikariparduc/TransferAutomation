package org.example.Methods;

import java.util.Random;

public class RandomIMEI {
    public static String generateRandomIMEI() {
        Random rand = new Random();
        StringBuilder imei = new StringBuilder();

        // IMEI numarası 15 haneli olmalı
        for (int i = 0; i < 15; i++) {
            imei.append(rand.nextInt(10)); // 0 ile 9 arasında rastgele sayılar ekle
        }

        return imei.toString();
    }
}
