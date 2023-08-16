package algorithm_practice.bai2.chat_gpt;

public class CommonCharacterCount {
    public static int commonCharacterCount(String s1, String s2) {
        int[] countS1 = new int[26]; // Mảng đếm số lần xuất hiện của các ký tự trong xâu s1
        int[] countS2 = new int[26]; // Mảng đếm số lần xuất hiện của các ký tự trong xâu s2
        int commonCount = 0; // Biến đếm số lượng ký tự chung
        // Đếm số lần xuất hiện của các ký tự trong xâu s1
        for (char c : s1.toCharArray()) {
            countS1[c - 'a']++;
        }
        // Đếm số lần xuất hiện của các ký tự trong xâu s2 và kiểm tra ký tự chung
        for (char c : s2.toCharArray()) {
            if (countS1[c - 'a'] > 0) {
                commonCount++;
                countS1[c - 'a']--; // Đánh dấu đã sử dụng một lần
            }
        }
        return commonCount;
    }
}