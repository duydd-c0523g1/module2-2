package view;

import view.submenu.*;

import java.util.Scanner;

public class MainView {
    private static final Scanner scanner = new Scanner(System.in);
    private static void showMenu() {
        System.out.println("-----FURAMA RESORT-----");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer management");
        System.out.println("3. Facility management");
        System.out.println("4. Booking management");
        System.out.println("5. Promotion management");
        System.out.println("0. Exit");
    }
    public static void start() {
        do {
            try {
                showMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        EmployeeManagement.startEmployeeManagement();
                        break;
                    case 2:
                        CustomerManagement.startCustomerManagement();
                        break;
                    case 3:
                        FacilityManagement.startFacilityManagement();
                        break;
                    case 4:
                        System.out.println("Work in progress");
                        //BookingManagement.startEmployeeManagement();
                        break;
                    case 5:
                        System.out.println("Work in progress");
                        //PromotionManagement.startPromotionManagement();
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
