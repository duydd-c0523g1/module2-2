package extra.bai19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        do {
            System.out.print("Enter your Email: ");
            String email = scanner.nextLine();
            if (RegEx.validate(email)) {
                System.out.println("Valid Email");
                isValid = true;
            } else {
                System.out.println("Invalid Email");
            }
        } while (!isValid);
        scanner.close();
    }
}
