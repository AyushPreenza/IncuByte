package Utils;

import java.security.SecureRandom;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        System.out.println(generatePassword(9));
    }

    public static String generatePassword(int length) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String allCharacters = lowercase + uppercase + digits + specialCharacters;

        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        password.append(randomCharFromSet(lowercase, random));
        password.append(randomCharFromSet(uppercase, random));
        password.append(randomCharFromSet(digits, random));
        password.append(randomCharFromSet(specialCharacters, random));

        for (int i = 4; i < length; i++) {
            password.append(randomCharFromSet(allCharacters, random));
        }

        return shuffleString(password.toString(), random);
    }

    private static char randomCharFromSet(String charSet, SecureRandom random) {
        int index = random.nextInt(charSet.length());
        return charSet.charAt(index);
    }

    private static String shuffleString(String str, SecureRandom random) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int j = random.nextInt(array.length);
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return new String(array);
    }
}

