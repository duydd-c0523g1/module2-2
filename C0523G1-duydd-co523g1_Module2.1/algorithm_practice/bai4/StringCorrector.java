package algorithm_practice.bai4;

public class StringCorrector {
    public static void main(String[] args) {
        String string = "chuong TrinhXuLiXauKyTu";
        String result = correctString(string);
        System.out.println(result);
    }
    public static String correctString(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (i > 0 && Character.isUpperCase(c)) {
                output.append(' ');
                output.append(Character.toLowerCase(c));
            } else {
                output.append(Character.toLowerCase(c));
            }
        }
        return output.toString();
    }
}
