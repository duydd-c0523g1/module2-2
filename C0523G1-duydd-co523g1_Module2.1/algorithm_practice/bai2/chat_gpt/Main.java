package algorithm_practice.bai2.chat_gpt;

import java.util.Scanner;

import static algorithm_practice.bai2.chat_gpt.CommonCharacterCount.commonCharacterCount;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập xâu thứ nhất: ");
        String s1 = scanner.nextLine();
        System.out.print("Nhập xâu thứ hai: ");
        String s2 = scanner.nextLine();
        int result = commonCharacterCount(s1, s2);
        System.out.println("Số lượng ký tự chung: " + result);
        scanner.close();
    }
}

