package extra.bai10.bai10_1.service;

import extra.bai10.bai10_1.model.Fruit;
import extra.bai10.bai10_1.repository.FruitRepositoryImpl;
import extra.bai10.bai10_1.repository.IFruitRepository;

import java.util.List;
import java.util.Scanner;

public class FruitServiceImpl implements IFruitService{
    private static IFruitRepository fruitRepository = new FruitRepositoryImpl();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void addNew() {
        System.out.println("Please insert the following information:");
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
        System.out.print("Price per kilogram: ");
        int price = Integer.parseInt(scanner.nextLine());
        Fruit fruit = new Fruit(name, type, dom, exp, origin, price);
        fruitRepository.addNew(fruit);
    }

    @Override
    public void displayAll() {
        List<Fruit> fruitList = fruitRepository.displayAll();
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }
    }
}
