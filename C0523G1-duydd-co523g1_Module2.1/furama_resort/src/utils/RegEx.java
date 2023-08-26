package utils;

import java.util.regex.Pattern;

public class RegEx {
    public static boolean regexEmployeeId(String id) {
        Pattern pattern = Pattern.compile("^NV-\\d{4}$");
        return pattern.matcher(id).matches();
    }
    public static boolean regexCustomerId(String id) {
        Pattern pattern = Pattern.compile("^KH-\\d{4}$");
        return pattern.matcher(id).matches();
    }
    public static boolean regexVillaId(String id) {
        Pattern pattern = Pattern.compile("^SVVL-\\d{4}$");
        return pattern.matcher(id).matches();
    }
    public static boolean regexHouseId(String id) {
        Pattern pattern = Pattern.compile("^SVHO-\\d{4}$");
        return pattern.matcher(id).matches();
    }
    public static boolean regexRoomId(String id) {
        Pattern pattern = Pattern.compile("^SVRO-\\d{4}$");
        return pattern.matcher(id).matches();
    }
    public static boolean regexIdentNumber(String id) {
        Pattern pattern1 = Pattern.compile("^\\d{9}$");
        Pattern pattern2 = Pattern.compile("^\\d{12}$");
        return pattern1.matcher(id).matches() || pattern2.matcher(id).matches();
    }
    public static boolean regexPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^0\\d{9}");
        return pattern.matcher(phoneNumber).matches();
    }
}
