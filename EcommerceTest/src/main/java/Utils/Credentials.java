package utils;

import java.util.Random;

public class Credentials {
    private static final Random random = new Random();

    public static String getRandomEmail() {
        return "user" + random.nextInt(10000) + "@testmaill343.com";
    }

    public static String getRandomPassword() {
        return "Password" + random.nextInt(1000) + "!";
    }

    public static String generateRandomFirstName() {
        return "First" + random.nextInt(100);
    }

    public static String generateRandomLastName() {
        return "Last" + random.nextInt(100);
    }
}
