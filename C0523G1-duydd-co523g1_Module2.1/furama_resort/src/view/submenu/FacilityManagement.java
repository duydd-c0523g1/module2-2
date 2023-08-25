package view.submenu;

import controller.Controller;
import view.MainView;

import java.util.Scanner;

public class FacilityManagement {
    private final Controller controller = new Controller();
    private static final Scanner scanner = new Scanner(System.in);

    private static void showMenu() {
        System.out.println("-----FACILITY MANAGEMENT-----");
        System.out.println("1. Display facilities");
        System.out.println("2. Add new facility");
        System.out.println("3. Facilities maintenance");
        System.out.println("4. Delete facility");
        System.out.println("5. Back to main menu");
        System.out.println("0. Exit");
    }

    public static void startFacilityManagement() {
        do {
            try {
                showMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
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
