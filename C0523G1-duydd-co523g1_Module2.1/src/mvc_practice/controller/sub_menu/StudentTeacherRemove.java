package src.mvc_practice.controller.sub_menu;

import src.mvc_practice.controller.StudentManager;
import src.mvc_practice.service.IService;
import src.mvc_practice.service.Service;

import java.util.Scanner;

public class StudentTeacherRemove {
    private static IService service = new Service();

    public static void showSubMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("1. Remove student");
                System.out.println("2. Remove teacher");
                System.out.println("3. Home");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                int option = Integer.parseInt(scanner.nextLine());
                System.out.println("----------------------------");
                switch (option) {
                    case 1:
                        service.removeStudent();
                        break;
                    case 2:
                        service.removeTeacher();
                        break;
                    case 3:
                        StudentManager.showMenu();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please insert a NUMBER!!!!");
            }
        } while (true);
    }
}