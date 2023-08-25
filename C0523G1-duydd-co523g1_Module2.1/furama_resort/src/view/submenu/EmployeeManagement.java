package view.submenu;

import controller.EmployeeController;
import view.MainView;

import java.util.Scanner;

public class EmployeeManagement {
    private final EmployeeController controller = new EmployeeController();
    private static final Scanner scanner = new Scanner(System.in);

    private static void showMenu() {
        System.out.println("-----EMPLOYEE MANAGEMENT-----");
        System.out.println("1. Display employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee");
        System.out.println("4. Delete employee");
        System.out.println("5. Search employees by name");
        System.out.println("6. Back to main menu");
        System.out.println("0. Exit");
    }

    public static void startEmployeeManagement() {
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
                        break;
                    case 6:
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
