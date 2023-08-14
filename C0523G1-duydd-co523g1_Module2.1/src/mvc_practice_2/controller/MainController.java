package src.mvc_practice_2.controller;

import java.util.Scanner;

public class MainController {
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        do try {
            int option;
            System.out.println("-----STUDENT-TEACHER MANAGER-----");
            System.out.println("1. Student manager menu");
            System.out.println("2. Teacher manager menu");
            System.out.println("0. Exit");
            System.out.print("Insert your option: ");
            option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Option does not exist");
                }
            } catch (NumberFormatException e) {
            System.out.println("Please input a number!");
        } while (true);
    }
}
