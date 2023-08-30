package view.submenu;

import controller.CustomerController;
import model.people.Customer;
import view.MainView;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import static utils.RegEx.*;
import static utils.Validator.validateAge;
import static utils.Validator.validateName;

public class CustomerManagement {
    private static CustomerController controller = new CustomerController();
    private static Scanner scanner = new Scanner(System.in);

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
                boolean valid = false;
                switch (option) {
                    case 1:
                        System.out.println("[DISPLAYING CUSTOMER LIST]");
                        List<Customer> customers = controller.displayCustomerList();
                        if (customers.isEmpty()) {
                            System.out.println("No customer found");
                        } else {
                            for (Customer customer : customers) {
                                System.out.println("-----------------------------");
                                System.out.println(customer);
                                System.out.println("-----------------------------");
                            }
                        }
                        break;
                    case 2:
                        String id;
                        String name;
                        String dob = null;
                        String identNum;
                        String phoneNumber;
                        String email;
                        String gender;
                        System.out.println("[ADDING NEW CUSTOMER]");
                        do {
                            System.out.print("Enter customer's ID: ");
                            id = scanner.nextLine();
                            if (regexCustomerId(id)) {
                                if (!controller.idExist(id)) {
                                    valid = true;
                                } else {
                                    System.out.println("[INVALID ID] Must be unique");
                                }
                            } else {
                                System.out.println("[INVALID ID] Must look like this: KH-0123");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's name: ");
                            name = scanner.nextLine();
                            if (validateName(name)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID NAME] This name is invalid!");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            try {
                                System.out.print("Enter customer's date of birth (dd/mm/yyy): ");
                                dob = scanner.nextLine();
                                if (validateAge(dob)) {
                                    valid = true;
                                } else {
                                    System.out.println("[INVALID AGE] Must be 18 or older");
                                }
                            } catch (DateTimeParseException e) {
                                System.out.println("[INVALID DATE] Illegal date format");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's gender [Male | Female | Non-Binary]: ");
                            gender = scanner.nextLine();
                            if (regexGender(gender)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID GENDER] Must be Male, Female or Non-Binary");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's identity number: ");
                            identNum = scanner.nextLine();
                            if (regexIdentNumber(identNum)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID IDENTITY] Must have 9 or 12 digits");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's phone number: ");
                            phoneNumber = scanner.nextLine();
                            if (regexPhoneNumber(phoneNumber)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID PHONE NUMBER] Must start with 0 and have " +
                                        "\n10 digits in total");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's email: ");
                            email = scanner.nextLine();
                            if (regexEmail(email)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID EMAIL] Must look like an EMAIL");
                            }
                        } while (!valid);
                        valid = false;
                        System.out.print("Enter customer's type: ");
                        String type = customerType();
                        System.out.print("Enter customer's address: ");
                        String address = scanner.nextLine();
                        Customer customer = new Customer(id, name, dob, gender,
                                identNum, phoneNumber, email, type, address);
                        controller.addNewCustomer(customer);
                        break;
                    case 3:
                        Customer newCustomer = new Customer();
                        String newId;
                        String newName;
                        String newIdentNum;
                        String newPhoneNumber;
                        String idToFind;
                        String newDob = null;
                        String newEmail;
                        String newGender;
                        System.out.println("[EDITING CUSTOMER]");
                        do {
                            System.out.print("Enter customer's ID: ");
                            idToFind = scanner.nextLine();
                            if (controller.idExist(idToFind)) {
                                newCustomer.setId(idToFind);
                                valid = true;
                            } else {
                                System.out.println("[ERROR] No ID found");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's new ID: ");
                            newId = scanner.nextLine();
                            if (regexEmployeeId(newId)) {
                                if (!controller.idExist(newId) || newCustomer.getId().equals(newId)) {
                                    valid = true;
                                } else {
                                    System.out.println("[INVALID ID] Must be unique");
                                }
                            } else {
                                System.out.println("[INVALID ID] Must look like this: KH-0123");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's new name: ");
                            newName = scanner.nextLine();
                            if (validateName(newName)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID NAME] This name is invalid!");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            try {
                                System.out.print("Enter customer's new date of birth: ");
                                newDob = scanner.nextLine();
                                if (validateAge(newDob)) {
                                    valid = true;
                                } else {
                                    System.out.println("[INVALID AGE] Must be 18 or older");
                                }
                            } catch (DateTimeParseException e) {
                                System.out.println("[INVALID DATE] Illegal date format");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's gender [Male | Female | Non-Binary]: ");
                            newGender = scanner.nextLine();
                            if (regexGender(newGender)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID GENDER] Must be Male, Female or Non-Binary");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's new identity number: ");
                            newIdentNum = scanner.nextLine();
                            if (regexIdentNumber(newIdentNum)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID IDENTITY] Must have 9 or 12 digits");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's new phone number: ");
                            newPhoneNumber = scanner.nextLine();
                            if (regexPhoneNumber(newPhoneNumber)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID PHONE NUMBER] Must start with 0 and have " +
                                        "\n10 digits in total");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's new email: ");
                            newEmail = scanner.nextLine();
                            if (regexEmail(newEmail)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID EMAIL] Must look like an EMAIL");
                            }
                        } while (!valid);
                        valid = false;
                        System.out.print("Enter customer's new type: ");
                        String newType = customerType();
                        System.out.print("Enter customer's new address: ");
                        String newAddress = scanner.nextLine();
                        newCustomer = new Customer(newId, newName, newDob, newGender,
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
                                System.out.println("-----------------------------");
                                System.out.println(c);
                                System.out.println("-----------------------------");
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

    private static String customerType() {
        String type;
        do {
            try {
                System.out.println("---SELECT CUSTOMER TYPE---");
                System.out.println("1. Diamond");
                System.out.println("2. Platinum");
                System.out.println("3. Gold ");
                System.out.println("4. Silver");
                System.out.println("5. Member");
                System.out.print("Your selection: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        type = "Diamond";
                        return type;
                    case 2:
                        type = "Platinum";
                        return type;
                    case 3:
                        type = "Gold";
                        return type;
                    case 4:
                        type = "Silver";
                        return type;
                    case 5:
                        type = "Member";
                        return type;
                    default:
                        System.out.println("[INVALID OPTION] Please try again");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("[INVALID FORMAT] Please enter a number");
            }
        } while (true);
    }
}
