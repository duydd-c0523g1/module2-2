package extra.bai12.controller;

import extra.bai12.service.FruitServiceImpl;
import extra.bai12.service.IFruitService;

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
                System.out.println("3. Update fruit product");
                System.out.println("4. Find fruit");
                System.out.println("0. Exit");
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
                        fruitService.updateFruit();
                        break;
                    case 4:
                        int select;
                        System.out.println("1. Find by ID");
                        System.out.println("2. Find by name");
                        System.out.println("0. Back");
                        System.out.print("Insert your option: ");
                        select = Integer.parseInt(scanner.nextLine());
                        switch (select) {
                            case 1:
                                fruitService.findFruitById();
                                break;
                            case 0:
                                showMenu();
                                break;
                            default:
                                System.out.println("Function is not available.");
                                showMenu();
                                break;
                        }
                    case 0:
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