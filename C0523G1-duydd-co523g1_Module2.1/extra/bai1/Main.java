package extra.bai1;

import src.bai7_abstraction.exercise.resizable.Circle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do try {
            System.out.print("First number = ");
            int num1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Second number = ");
            int num2 = Integer.parseInt(scanner.nextLine());
            System.out.println(Calculator.calculate(num1, num2));
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Lỗi");
        } while (true);
    }
}
