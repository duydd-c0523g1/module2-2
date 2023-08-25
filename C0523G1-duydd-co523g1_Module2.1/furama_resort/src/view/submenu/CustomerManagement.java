package view.submenu;

import com.sun.xml.internal.ws.server.ServerRtException;
import controller.CustomerController;
import model.people.Customer;
import view.MainView;

import java.util.List;
import java.util.Scanner;

public class CustomerManagement {
    private static final CustomerController controller = new CustomerController();
    private static final Scanner scanner = new Scanner(System.in);

    private static void showMenu() {
        System.out.println("-----CUSTOMER MANAGEMENT-----");
        System.out.println("1. Display customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer");
        System.out.println("4. Delete customer");
        System.out.println("5. Search customer by name");
        System.out.println("6. Back to main menu");
        System.out.println("0. Exit");
    }

    public static void startCustomerManagement() {
        do {
            try {
                showMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("[DISPLAYING CUSTOMER LIST]");
                        List<Customer> customers = controller.displayCustomerList();
                        if (customers.isEmpty()) {
                            System.out.println("No customer found");
                        } else {
                            for (Customer customer : customers) {
                                System.out.println(customer);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("[ADDING NEW CUSTOMER]");
                        System.out.print("Enter customer's ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter customer's name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter customer's date of birth: ");
                        String dob = scanner.nextLine();
                        System.out.print("Enter customer's gender: ");
                        String gender = scanner.nextLine();
                        System.out.print("Enter customer's identification number: ");
                        String identNum = scanner.nextLine();
                        System.out.print("Enter customer's phone number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter customer's email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter customer's type: ");
                        String type = scanner.nextLine();
                        System.out.print("Enter customer's address: ");
                        String address = scanner.nextLine();
                        Customer customer = new Customer(id, name, dob, gender,
                                identNum, phoneNumber, email, type, address);
                        controller.addNewCustomer(customer);
                        break;
                    case 3:
                        System.out.println("[EDITING CUSTOMER]");
                        System.out.print("Enter customer's ID: ");
                        String idToFind = scanner.nextLine();
                        System.out.print("Enter new customer's ID: ");
                        String newId = scanner.nextLine();
                        System.out.print("Enter new customer's name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new customer's date of birth: ");
                        String newDob = scanner.nextLine();
                        System.out.print("Enter new customer's gender: ");
                        String newGender = scanner.nextLine();
                        System.out.print("Enter new customer's identification number: ");
                        String newIdentNum = scanner.nextLine();
                        System.out.print("Enter new customer's phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        System.out.print("Enter new customer's email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter new customer's type: ");
                        String newType = scanner.nextLine();
                        System.out.print("Enter new customer's address: ");
                        String newAddress = scanner.nextLine();
                        Customer newCustomer = new Customer(newId, newName, newDob, newGender,
                                newIdentNum, newPhoneNumber, newEmail, newType, newAddress);
                        boolean result = controller.editCustomer(idToFind, newCustomer);
                        if (result) {
                            System.out.println("Success");
                        } else {
                            System.out.println("Something went wrong...");
                        }
                        break;
                    case 4:
                        System.out.println("[DELETING CUSTOMER]");
                        System.out.print("Enter customer's ID: ");
                        String idToDel = scanner.nextLine();
                        if (controller.deleteCustomer(idToDel)) {
                            System.out.println("Success!");
                        } else {
                            System.out.println("ID does not exist!");
                        }
                        break;
                    case 5:
                        System.out.println("[SEARCHING CUSTOMER]");
                        System.out.print("Enter a name: ");
                        String nameToFind = scanner.nextLine();
                        List<Customer> customerList = controller.searchCustomerByName(nameToFind);
                        if (customerList.isEmpty()) {
                            System.out.println("No customer found!");
                        } else {
                            for (Customer c : customerList) {
                                System.out.println(c);
                            }
                        }
                        break;
                    case 6:
                        MainView.start();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Function unavailable");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            } catch (Exception e) {
                System.out.println("[Exception] Something went wrong...");
                e.printStackTrace();
            }
        } while (true);
    }
}
