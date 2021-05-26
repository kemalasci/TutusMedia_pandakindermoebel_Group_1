package utils;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class MyMethods implements Locators {
    public String randomStringMail() {
        //  String rndString = UUID.randomUUID().toString();
        String rndString = RandomStringUtils.randomAlphabetic(8);

        return rndString + "@gmail.com";
    }
    public String randomUserName() {
        //  String rndString = UUID.randomUUID().toString();
        String rndString = RandomStringUtils.randomAlphabetic(8);

        return rndString ;
    }


    private static final String[] charCategories = new String[] {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789"
    };

    public static String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        System.out.println(new String(password));
        return new String(password);
    }


}
