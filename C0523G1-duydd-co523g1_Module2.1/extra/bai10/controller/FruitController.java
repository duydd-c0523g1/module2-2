package extra.bai10.controller;

import extra.bai10.service.FruitServiceImpl;
import extra.bai10.service.IFruitService;

import java.util.Scanner;

public class FruitController {
    private static IFruitService fruitService = new FruitServiceImpl();

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                int option;
                System.out.println("=====FRUITS MENU=====");
                System.out.println("1. Add new fruit");
                System.out.println("2. Display fruit list");
                System.out.println("3. Exit");
                System.out.print("Insert your option: ");
                option = Integer.parseInt(scanner.nextLine());
                System.out.println("-----------------------------------");
                switch (option) {
                    case 1:
                        fruitService.addNew();
                        break;
                    case 2:
                        fruitService.displayAll();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a number!!");
            }
        } while (true) ;
    }
}