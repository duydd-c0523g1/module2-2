package algorithm_practice.bai2;

public class Main {
    public static void main(String[] args) {
        String str1 = "aabcc ";
        String str2 = "adcaa";
        System.out.println("Số lượng ký tự trùng lặp là: " + CharacterInCommon.checkCharInCommon(str1, str2));
    }
}
