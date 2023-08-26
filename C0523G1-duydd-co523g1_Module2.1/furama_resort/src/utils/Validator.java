package utils;

public class Validator {
    public static boolean validateName(String name) {
        String[] parts = name.split(" ");
        if (parts.length < 2) {
            return false;
        }
        for (String part : parts) {
            if (part.length() < 1) {
                return false;
            }
        }
        for (String part : parts) {
            if (!Character.isUpperCase(part.charAt(0))) {
                return false;
            }
        }
        return true;
    }
}
