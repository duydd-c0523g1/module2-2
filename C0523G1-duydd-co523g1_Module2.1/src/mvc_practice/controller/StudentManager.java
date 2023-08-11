package src.mvc_practice.controller;

import src.mvc_practice.controller.sub_menu.StudenTeacherAdd;
import src.mvc_practice.service.IService;
import src.mvc_practice.service.Service;

import java.util.Scanner;

public class StudentManager {
    private static IService service = new Service();
    public static void showMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("-----STUDENT MANAGER-----");
            System.out.println("1. Add new");
            System.out.println("2. Delete");
            System.out.println("3.Display list");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option  = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    StudenTeacherAdd.showSubMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                default:
                    throw new Exception("Invalid option");
            }
        } while (true);
    }
}
