package extra.custom_mvc.view;

import extra.custom_mvc.controller.Controller;
import extra.custom_mvc.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private static Controller controller = new Controller();
    private static void showMenu() {
        System.out.println("-----PRODUCT MANAGER-----");
        System.out.println("1. Add new product");
        System.out.println("2. Show product list");
        System.out.println("3. Delete product");
        System.out.println("0. Exit");
    }
    public static void launch() {
        do {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your option: ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    Product product = new Product();
                    System.out.print("Product ID:");
                    product.setId(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Product Name:");
                    product.setName(scanner.nextLine());
                    System.out.print("Product manufacture date:");
                    product.setManuDate(scanner.nextLine());
                    System.out.print("Product expire date:");
                    product.setExpDate(scanner.nextLine());
                    controller.add(product);
                    break;
                case 2:
                    List<Product> products = controller.display();
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    controller.delete(id);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Unavailable");
                    break;
            }
        } while (true);
    }
}
