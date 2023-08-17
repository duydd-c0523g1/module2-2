package extra.bai13.service;

import extra.bai13.model.Spend;
import extra.bai13.repository.ISpendingRepository;
import extra.bai13.repository.SpendingRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class SpendingServiceImpl implements ISpendingService {
    private final ISpendingRepository spendingRepository = new SpendingRepositoryImpl();
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void displayList() {
        List<Spend> spendList = spendingRepository.displayList();
        for (Spend spend : spendList) {
            System.out.println(spend);
        }
    }

    @Override
    public void addNewPlan() {
        Spend spend = new Spend();
        System.out.println("Plan's ID will be initialized automatically");
        System.out.print("Enter plan's name: ");
        spend.setName(scanner.nextLine());
        System.out.print("Enter plan's date:  ");
        spend.setSpendDate(scanner.nextLine());
            try {
                System.out.print("Enter amount of money ($): ");
                spend.setSpendAmount(Float.parseFloat(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("That was not a number. \nField will be set to 0 automatically. \nUse Editing function to reassign the field.");
            }
        System.out.print("Enter description: ");
        spend.setDescription(scanner.nextLine());
        spendingRepository.addNewPlan(spend);
        System.out.println("Success!");
        System.out.println();
    }

    @Override
    public void deletePlan() {
        try {
            System.out.print("Enter plan ID to remove: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            System.out.println(spendingRepository.deletePlan(id));
        } catch (NumberFormatException e) {
            System.out.println("ID must be a NUMBER!!!");
        }
    }

    @Override
    public void editPlan() {
            System.out.print("Enter plan's ID: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            Spend newSpend = new Spend();
            System.out.print("Enter plan's name: ");
            newSpend.setName(scanner.nextLine());
            System.out.print("Enter plan's date:  ");
            newSpend.setSpendDate(scanner.nextLine());
        try {
            System.out.print("Enter amount of money ($):  ");
            newSpend.setSpendAmount(Float.parseFloat(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("ID must be a NUMBER!!!");
        }
            System.out.print("Enter description: ");
            newSpend.setDescription(scanner.nextLine());
            spendingRepository.editPlan(id, newSpend);

    }

    @Override
    public void searchPlanById() {
        Integer id = null;
        try {
            System.out.print("Enter plan's ID: ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID must be a NUMBER!!!");
        }
        Spend result = spendingRepository.searchPlanById(id);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Plan does not exist.");
        }
    }

    @Override
    public void proximitySearchByName() {
        System.out.print("Enter plan's name: ");
        String name = scanner.nextLine();
        List<Spend> spendList = spendingRepository.proximitySearchByName(name);
        if (spendList.isEmpty()) {
            System.out.println("Cannot find any plan with that name");
        } else {
            for (Spend spend : spendList) {
                System.out.println(spend);
            }
        }
    }
}
