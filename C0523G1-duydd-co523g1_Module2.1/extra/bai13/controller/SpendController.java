package extra.bai13.controller;

import extra.bai13.service.ISpendingService;
import extra.bai13.service.SpendingServiceImpl;

import java.util.Scanner;

public class SpendController {
    private static final ISpendingService spendingService = new SpendingServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);
    public static void showMenu() {
        do {
            try {
                int option;
                System.out.println("------SPENDING MANAGER-----");
                System.out.println("1. Show spending records");
                System.out.println("2. Add new spending plan");
                System.out.println("3. Delete spending plan");
                System.out.println("4. Edit spending plan");
                System.out.println("5. Search plan by id");
                System.out.println("6. Proximity search by name");
                System.out.println("0. Exit");
                System.out.print("Insert your option: ");
                option = Integer.parseInt(scanner.nextLine());
                System.out.println("---------------------------");
                switch (option) {
                    case 1:
                        spendingService.displayList();
                        break;
                    case 2:
                        spendingService.addNewPlan();
                        break;
                    case 3:
                        spendingService.deletePlan();
                        break;
                    case 4:
                        spendingService.editPlan();
                        break;
                    case 5:
                        spendingService.searchPlanById();
                        break;
                    case 6:
                        spendingService.proximitySearchByName();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Function is not available!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a NUMBER!!");
            }
        } while (true);
    }
}
