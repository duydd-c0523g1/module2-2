package src.mvc_new.view;

import src.mvc_new.controller.ProductController;
import src.mvc_new.exceptions.InvalidPriceException;
import src.mvc_new.model.Product;

import java.util.List;
import java.util.Scanner;

public class View {
    private static final ProductController controller = new ProductController();
    private static final Scanner scanner = new Scanner(System.in);

    private static void showMenu() {
        System.out.println("-----PRODUCT MANAGER-----");
        System.out.println("1. Add new product");
        System.out.println("2. Display all products");
        System.out.println("3. Find product");
        System.out.println("4. Exit");
    }

    public static void start() {
        do {
            showMenu();
            System.out.print("Enter your selection: ");
            int selection = Integer.parseInt(scanner.nextLine());
            switch (selection) {
                case 1:
                    boolean validProduct = false;
                    System.out.println("[ADD] You are adding a new product.");
                    System.out.println("ID will be set automatically");
                    do {
                        try {
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Price: ");
                            float price = Float.parseFloat(scanner.nextLine());
                            if (price < 0) {
                                throw new InvalidPriceException("Price can't be negative");
                            }
                            System.out.print("Enter Brand: ");
                            String brand = scanner.nextLine();
                            validProduct = true;
                            Product product = new Product(name, price, brand);
                            controller.addNewProduct(product);
                        } catch (NumberFormatException e) {
                            System.out.println("Price must be a NUMBER");
                        } catch (InvalidPriceException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!validProduct);
                    break;
                case 2:
                    List<Product> productList = controller.displayProductList();
                    if (productList.isEmpty()) {
                        System.out.println("The list is empty!");
                        break;
                    } else {
                        for (Product product : productList) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 3:
                    findProduct();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("[VIEW] Function is not yet available");
                    break;
            }
        } while (true);
    }

    private static void findProduct() {
        System.out.println("1. Find product by ID");
        System.out.println("2. Find product by name");
        int selection = Integer.parseInt(scanner.nextLine());
        if (selection == 1) {
            System.out.print("[ID] Enter an ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (controller.searchById(id) != null) {
                System.out.println(controller.searchById(id));
            } else {
                System.out.println("No product found");
            }
        } else if (selection == 2) {
            System.out.print("[NAME] Enter a name:");
            String name = scanner.nextLine();
            List<Product> productList = controller.searchByName(name);
            if (!productList.isEmpty()) {
                for (Product product : productList) {
                    System.out.println(product);
                }
            } else {
                System.out.println("No product found");
            }
        } else {
            System.out.println("Invalid input, please try again!");
            findProduct();
        }
    }
}
