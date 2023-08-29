package view.submenu;

import controller.CustomerController;
import model.people.Customer;
import view.MainView;
import java.util.List;
import java.util.Scanner;
import static utils.RegEx.*;
import static utils.Validator.*;

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
                                System.out.println("-----------------------------");
                                System.out.println(customer);
                                System.out.println("-----------------------------");
                            }
                        }
                        break;
                    case 2:
                        boolean validId = false;
                        boolean validName = false;
                        boolean validAge = false;
                        boolean validIdent = false;
                        boolean validPhone = false;
                        boolean validEmail = false;
                        String id;
                        String name;
                        String dob;
                        String identNum;
                        String phoneNumber;
                        String email;
                        System.out.println("[ADDING NEW CUSTOMER]");
                        do {
                            System.out.print("Enter customer's ID: ");
                            id = scanner.nextLine();
                            if (regexCustomerId(id)) {
                                if (!controller.idExist(id)) {
                                    validId = true;
                                } else {
                                    System.out.println("[INVALID ID] Must be unique");
                                }
                            } else {
                                System.out.println("[INVALID ID] Must look like this: KH-0123");
                            }
                        } while (!validId);
                        do {
                            System.out.print("Enter customer's name: ");
                            name = scanner.nextLine();
                            if (validateName(name)) {
                                validName = true;
                            } else {
                                System.out.println("[INVALID NAME] This name is invalid!");
                            }
                        } while (!validName);
                        do {
                            System.out.print("Enter customer's date of birth (dd/mm/yyy): ");
                            dob = scanner.nextLine();
                            if (validateAge(dob)) {
                                validAge = true;
                            } else {
                                System.out.println("[INVALID AGE] Must be 18 or older");
                            }
                        } while (!validAge);
                        System.out.print("Enter customer's gender: ");
                        String gender = scanner.nextLine();
                        do {
                            System.out.print("Enter customer's identification number: ");
                            identNum = scanner.nextLine();
                            if (regexIdentNumber(identNum)) {
                                validIdent = true;
                            } else {
                                System.out.println("[INVALID IDENTIFICATION] Must have 9 or 12 digits");
                            }
                        } while (!validIdent);
                        do {
                            System.out.print("Enter customer's phone number: ");
                            phoneNumber = scanner.nextLine();
                            if (regexPhoneNumber(phoneNumber)) {
                                validPhone = true;
                            } else {
                                System.out.println("[INVALID PHONE NUMBER] Must start with 0 and have " +
                                        "\n10 digits in total");
                            }
                        } while (!validPhone);
                        do {
                            System.out.print("Enter customer's email: ");
                            email = scanner.nextLine();
                            if (regexEmail(email)) {
                                validEmail = true;
                            } else {
                                System.out.println("[INVALID EMAIL] Must look like an EMAIL");
                            }
                        } while (!validEmail);
                        System.out.print("Enter customer's type: ");
                        String type = scanner.nextLine();
                        System.out.print("Enter customer's address: ");
                        String address = scanner.nextLine();
                        Customer customer = new Customer(id, name, dob, gender,
                                identNum, phoneNumber, email, type, address);
                        controller.addNewCustomer(customer);
                        break;
                    case 3:
                        Customer newCustomer = new Customer();
                        boolean validNewId = false;
                        boolean validNewName = false;
                        boolean validNewIdent = false;
                        boolean validNewPhone = false;
                        boolean validIdToFind = false;
                        boolean validNewAge = false;
                        boolean validNewEmail = false;
                        String newId;
                        String newName;
                        String newIdentNum;
                        String newPhoneNumber;
                        String idToFind;
                        String newDob;
                        String newEmail;
                        System.out.println("[EDITING CUSTOMER]");
                        do {
                            System.out.print("Enter customer's ID: ");
                            idToFind = scanner.nextLine();
                            if (controller.idExist(idToFind)) {
                                newCustomer.setId(idToFind);
                                validIdToFind = true;
                            } else {
                                System.out.println("[ERROR] No ID found");
                            }
                        } while (!validIdToFind);
                        do {
                            System.out.print("Enter customer's new ID: ");
                            newId = scanner.nextLine();
                            if (regexEmployeeId(newId)) {
                                if (!controller.idExist(newId) || newCustomer.getId().equals(newId)) {
                                    validNewId = true;
                                } else {
                                    System.out.println("[INVALID ID] Must be unique");
                                }
                            } else {
                                System.out.println("[INVALID ID] Must look like this: KH-0123");
                            }
                        } while (!validNewId);
                        do {
                            System.out.print("Enter customer's new name: ");
                            newName = scanner.nextLine();
                            if (validateName(newName)) {
                                validNewName = true;
                            } else {
                                System.out.println("[INVALID NAME] This name is invalid!");
                            }
                        } while (!validNewName);
                        do {
                            System.out.print("Enter customer's new date of birth: ");
                            newDob = scanner.nextLine();
                            if (validateAge(newDob)) {
                                validNewAge = true;
                            } else {
                                System.out.println("[INVALID AGE] Must be 18 or older");
                            }
                        } while (!validNewAge);
                        System.out.print("Enter new customer's gender: ");
                        String newGender = scanner.nextLine();
                        do {
                            System.out.print("Enter customer's new identification number: ");
                            newIdentNum = scanner.nextLine();
                            if (regexIdentNumber(newIdentNum)) {
                                validNewIdent = true;
                            } else {
                                System.out.println("[INVALID IDENTIFICATION] Must have 9 or 12 digits");
                            }
                        } while (!validNewIdent);
                        do {
                            System.out.print("Enter customer's new phone number: ");
                            newPhoneNumber = scanner.nextLine();
                            if (regexPhoneNumber(newPhoneNumber)) {
                                validNewPhone = true;
                            } else {
                                System.out.println("[INVALID PHONE NUMBER] Must start with 0 and have " +
                                        "\n10 digits in total");
                            }
                        } while (!validNewPhone);
                        do {
                            System.out.print("Enter customer's new email: ");
                            newEmail = scanner.nextLine();
                            if (regexEmail(newEmail)) {
                                validNewEmail = true;
                            } else {
                                System.out.println("[INVALID EMAIL] Must look like an EMAIL");
                            }
                        } while (!validNewEmail);
                        System.out.print("Enter new customer's type: ");
                        String newType = scanner.nextLine();
                        System.out.print("Enter new customer's address: ");
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
}
