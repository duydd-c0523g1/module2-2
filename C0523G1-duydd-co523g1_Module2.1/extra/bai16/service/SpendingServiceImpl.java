package extra.bai16.service;

import extra.bai16.Exeptions.IdNotFoundException;
import extra.bai16.Exeptions.UniqueIdException;
import extra.bai16.model.Spend;
import extra.bai16.repository.ISpendingRepository;
import extra.bai16.repository.SpendingRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class SpendingServiceImpl implements ISpendingService {
    private final ISpendingRepository spendingRepository = new SpendingRepositoryImpl();
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void displayList() {
        List<Spend> spendList = spendingRepository.displayList();
        if (spendList != null) {
            for (Spend spend : spendList) {
                System.out.println(spend);
            }
        } else {
            System.out.println("There is nothing on the list!");
        }
    }

    @Override
    public void addNewPlan() {
        boolean spendValid = false;
        boolean idValid = false;
        Spend spend = new Spend();
        do {
            try {
                System.out.print("Enter plan's ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                List<Spend> spendList = spendingRepository.displayList();
                if (spendList.contains(new Spend(id))) {
                    throw new UniqueIdException("Id already existed");
                }
                spend.setId(id);
                idValid = true;
            } catch (UniqueIdException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("ID must be a number");
            }
        } while (!idValid);
        System.out.print("Enter plan's name: ");
        spend.setName(scanner.nextLine());
        System.out.print("Enter plan's date:  ");
        spend.setSpendDate(scanner.nextLine());
        do {
            try {
                System.out.print("Enter amount of money ($): ");
                spend.setSpendAmount(Float.parseFloat(scanner.nextLine()));
                spendValid = true;
            } catch (NumberFormatException e) {
                System.out.println("That was not a number.");
            }
        } while (!spendValid);
        System.out.print("Enter description: ");
        spend.setDescription(scanner.nextLine());
        spendingRepository.addNewPlan(spend);
        System.out.println("Success!");
        System.out.println();
    }

    @Override
public void deletePlan() {
        try {
            List<Spend> spendList = spendingRepository.displayList();
            System.out.print("Enter plan ID to remove: ");
            Integer id = Integer.parseInt(scanner.nextLine());
                if (!spendList.contains(new Spend(id))) {
                    throw new IdNotFoundException("Can't find this ID");
                }
            System.out.println(spendingRepository.deletePlan(id));
        } catch (NumberFormatException e) {
            System.out.println("ID must be a NUMBER!!!");
        } catch (IdNotFoundException e) {
            System.out.println("Id does not exist.");
        }
    }

    @Override
    public void editPlan() {
        boolean valid = false;
            System.out.print("Enter plan's ID: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            Spend newSpend = new Spend();
            System.out.print("Enter new plan's name: ");
            newSpend.setName(scanner.nextLine());
            System.out.print("Enter new plan's date:  ");
            newSpend.setSpendDate(scanner.nextLine());
            do {
                try {
                    System.out.print("Enter new amount of money ($):  ");
                    newSpend.setSpendAmount(Float.parseFloat(scanner.nextLine()));
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Money must be a NUMBER!!!");
                }
            } while (!valid);
            System.out.print("Enter new description: ");
            newSpend.setDescription(scanner.nextLine());
        try {
            spendingRepository.editPlan(id, newSpend);
        } catch (IdNotFoundException e) {
            System.out.println("ID does not exist.");
        }
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

    @Override
    public void ascSortByName() {
        List<Spend> spendList = spendingRepository.ascSortByName();
        for (Spend spend : spendList) {
            System.out.println(spend);
        }
    }

    @Override
    public void descSortBySpendAmount() {
        List<Spend> spendList = spendingRepository.descSortBySpendAmount();
        for (Spend spend : spendList) {
            System.out.println(spend);
        }
    }
}
