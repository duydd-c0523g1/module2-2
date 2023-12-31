package view.submenu;

import controller.CustomerController;
import model.people.Customer;
import view.MainView;

import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static utils.RegEx.*;
import static utils.Validator.validateAge;
import static utils.Validator.validateName;

public class CustomerManagement {
    private static final CustomerController CONTROLLER = new CustomerController();
    private static final Scanner SCANNER = new Scanner(System.in);

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

    public static void launchCustomerMenu() {
        do {
            try {
                showMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(SCANNER.nextLine());
                boolean valid = false;
                switch (option) {
                    case 1:
                        System.out.println("[DISPLAYING CUSTOMER LIST]");
                        List<Customer> customers = CONTROLLER.displayCustomerList();
                        customers.sort(new Comparator<Customer>() {
                            @Override
                            public int compare(Customer o1, Customer o2) {
                                return o2.getId().compareTo(o1.getId());
                            }
                        });
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
                            id = SCANNER.nextLine();
                            if (regexCustomerId(id)) {
                                if (!CONTROLLER.idExist(id)) {
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
                            name = SCANNER.nextLine();
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
                                dob = SCANNER.nextLine();
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
                            System.out.print("Choose customer's gender: ");
                            gender = customerGender();
                        do {
                            System.out.print("Enter customer's identity number: ");
                            identNum = SCANNER.nextLine();
                            if (regexIdentNumber(identNum)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID IDENTITY] Must have 9 or 12 digits");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's phone number: ");
                            phoneNumber = SCANNER.nextLine();
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
                            email = SCANNER.nextLine();
                            if (regexEmail(email)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID EMAIL] Must look like an EMAIL");
                            }
                        } while (!valid);
                        System.out.print("Enter customer's type: ");
                        String type = customerType();
                        System.out.print("Enter customer's address: ");
                        String address = SCANNER.nextLine();
                        Customer customer = new Customer(id, name, dob, gender,
                                identNum, phoneNumber, email, type, address);
                        CONTROLLER.addNewCustomer(customer);
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
                            idToFind = SCANNER.nextLine();
                            if (CONTROLLER.idExist(idToFind)) {
                                newCustomer.setId(idToFind);
                                valid = true;
                            } else {
                                System.out.println("[ERROR] No ID found");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's new ID: ");
                            newId = SCANNER.nextLine();
                            if (regexEmployeeId(newId)) {
                                if (!CONTROLLER.idExist(newId) || newCustomer.getId().equals(newId)) {
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
                            newName = SCANNER.nextLine();
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
                                newDob = SCANNER.nextLine();
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
                        System.out.print("Choose customer's new gender: ");
                        newGender = customerGender();
                        do {
                            System.out.print("Enter customer's new identity number: ");
                            newIdentNum = SCANNER.nextLine();
                            if (regexIdentNumber(newIdentNum)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID IDENTITY] Must have 9 or 12 digits");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter customer's new phone number: ");
                            newPhoneNumber = SCANNER.nextLine();
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
                            newEmail = SCANNER.nextLine();
                            if (regexEmail(newEmail)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID EMAIL] Must look like an EMAIL");
                            }
                        } while (!valid);
                        System.out.print("Enter customer's new type: ");
                        String newType = customerType();
                        System.out.print("Enter customer's new address: ");
                        String newAddress = SCANNER.nextLine();
                        newCustomer = new Customer(newId, newName, newDob, newGender,
                                newIdentNum, newPhoneNumber, newEmail, newType, newAddress);
                        boolean result = CONTROLLER.editCustomer(idToFind, newCustomer);
                        if (result) {
                            System.out.println("Success");
                        } else {
                            System.out.println("Something went wrong...");
                        }
                        break;
                    case 4:
                        System.out.println("[DELETING CUSTOMER]");
                        System.out.print("Enter customer's ID: ");
                        String idToDel = SCANNER.nextLine();
                        if (CONTROLLER.deleteCustomer(idToDel)) {
                            System.out.println("Success!");
                        } else {
                            System.out.println("ID does not exist!");
                        }
                        break;
                    case 5:
                        System.out.println("[SEARCHING CUSTOMER]");
                        System.out.print("Enter a name: ");
                        String nameToFind = SCANNER.nextLine();
                        List<Customer> customerList = CONTROLLER.searchCustomerByName(nameToFind);
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
                        MainView.launch();
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
                int option = Integer.parseInt(SCANNER.nextLine());
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

    private static String customerGender() {
        String type;
        do {
            try {
                System.out.println("---SELECT CUSTOMER GENDER---");
                System.out.println("1. Male");
                System.out.println("2. Female");
                System.out.println("3. Non-Binary");
                System.out.print("Your selection:");
                int option = Integer.parseInt(SCANNER.nextLine());
                switch (option) {
                    case 1:
                        type = "Male";
                        return type;
                    case 2:
                        type = "Female";
                        return type;
                    case 3:
                        type = "Non-Binary";
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
