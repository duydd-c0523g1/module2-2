package extra.bai12.service;

import extra.bai12.controller.FruitController;
import extra.bai12.model.Fruit;
import extra.bai12.repository.FruitRepositoryImpl;
import extra.bai12.repository.IFruitRepository;
import extra.bai7.SocialBook;

import java.util.List;
import java.util.Scanner;

public class FruitServiceImpl implements IFruitService {
    private static IFruitRepository fruitRepository = new FruitRepositoryImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void addNew() {
        System.out.println("Please insert the following information:");
        System.out.print("Fruit ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Date of manufacture: ");
        String dom = scanner.nextLine();
        System.out.print("Expiration date: ");
        String exp = scanner.nextLine();
        System.out.print("Origin: ");
        String origin = scanner.nextLine();
        System.out.print("Price per kilogram ($): ");
        int price = Integer.parseInt(scanner.nextLine());
        Fruit fruit = new Fruit(id, name, type, dom, exp, origin, price);
        System.out.println(fruitRepository.addNew(id, fruit));
        System.out.println("-----------------------------------");
    }

    @Override
    public void displayAll() {
        List<Fruit> fruitList = fruitRepository.displayAll();
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }
    }

    @Override
    public void updateFruit() {
        displayAll();
        System.out.print("Insert fruit's ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String newnName = scanner.nextLine();
        System.out.print("Type: ");
        String newType = scanner.nextLine();
        System.out.print("Date of manufacture: ");
        String newDom = scanner.nextLine();
        System.out.print("Expiration date: ");
        String newExp = scanner.nextLine();
        System.out.print("Origin: ");
        String newOrigin = scanner.nextLine();
        System.out.print("Price per kilogram ($): ");
        int newPrice = Integer.parseInt(scanner.nextLine());
        Fruit newFruit = new Fruit(id, newnName, newType, newDom, newExp, newOrigin, newPrice);
        System.out.println(fruitRepository.updateFruit(id, newFruit));
    }

    @Override
    public void findFruitById() {
        System.out.print("Insert ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("-----------------------------------");
        System.out.println(fruitRepository.findFruit(id));
    }
}
