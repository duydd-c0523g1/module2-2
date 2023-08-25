package view.submenu;

import controller.Controller;
import view.MainView;

import java.util.Scanner;

public class PromotionManagement {
    private final Controller controller = new Controller();
    private static final Scanner scanner = new Scanner(System.in);

    private static void showPromotionMenu() {
        System.out.println("-----PROMOTION MANAGEMENT-----");
        System.out.println("1. Customers using services");
        System.out.println("2. Eligible customers for vouchers");
        System.out.println("3. Back to main menu");
        System.out.println("0. Exit");
    }

    public static void startPromotionManagement() {
        do {
            try {
                showPromotionMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        MainView.start();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Function unavailable");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            } catch (Exception e) {
                System.out.println("Something went wrong...");
            }
        } while (true);
    }
}
