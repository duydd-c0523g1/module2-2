package extra.bai1;

import java.util.Scanner;

public class Calculator {
    public static int calculate(int num1, int num2) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select calculation: (+, -, *, /)");
        String calculation = scanner.nextLine();
        int result = 0;
        switch (calculation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Lỗi");
        }
        return result;
    }
}
