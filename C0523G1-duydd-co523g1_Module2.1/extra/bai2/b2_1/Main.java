package extra.bai2.b2_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number (> 0)");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(Sum.sum(number));
    }
}
