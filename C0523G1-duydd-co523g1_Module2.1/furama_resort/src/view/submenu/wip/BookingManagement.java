package furama_resort.src.view.submenu.wip;

import controller.FacilityController;
import furama_resort.src.view.MainView;

import java.util.Scanner;

public class BookingManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private final FacilityController controller = new FacilityController();

    private static void showMenu() {
        System.out.println("-----BOOKING MANAGEMENT-----");
        System.out.println("1. Display booking list");
        System.out.println("2. Add new booking");
        System.out.println("3. Add new contract");
        System.out.println("4. Display contract list");
        System.out.println("5. Edit contract");
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
                        MainView.launch();
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
