package view.submenu;

import controller.EmployeeController;
import model.people.Employee;
import view.MainView;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import static utils.RegEx.*;
import static utils.Validator.validateAge;
import static utils.Validator.validateName;

public class EmployeeManagement {
    private static final EmployeeController controller = new EmployeeController();
    private static final Scanner scanner = new Scanner(System.in);

    private static void showMenu() {
        System.out.println("-----EMPLOYEE MANAGEMENT-----");
        System.out.println("1. Display employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee");
        System.out.println("4. Delete employee");
        System.out.println("5. Search employees by name");
        System.out.println("6. Back to main menu");
        System.out.println("0. Exit");
    }

    public static void startEmployeeManagement() {
        do {
            try {
                showMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(scanner.nextLine());
                boolean valid = false;
                switch (option) {
                    case 1:
                        System.out.println("[DISPLAYING EMPLOYEE LIST]");
                        List<Employee> employees = controller.displayEmployeeList();
                        if (employees.isEmpty()) {
                            System.out.println("[EMPTY LIST] No employee found");
                        } else {
                            for (Employee employee : employees) {
                                System.out.println("-----------------------------");
                                System.out.println(employee);
                                System.out.println("-----------------------------");
                            }
                        }
                        break;
                    case 2:
                        String name;
                        String id;
                        String identNum;
                        String phoneNumber;
                        String dob = null;
                        String email;
                        double salary;
                        System.out.println("[ADDING NEW EMPLOYEE]");
                        do {
                            System.out.print("Enter employee's ID: ");
                            id = scanner.nextLine();
                            if (regexEmployeeId(id)) {
                                if (!controller.idExist(id)) {
                                    valid = true;
                                } else {
                                    System.out.println("[INVALID ID] Must be unique");
                                }
                            } else {
                                System.out.println("[INVALID ID] Must look like this: NV-0123");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter employee's name: ");
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
                                System.out.print("Enter employee's date of birth: ");
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
                        System.out.print("Enter employee's gender: ");
                        String gender = scanner.nextLine();
                        do {
                            System.out.print("Enter employee's identification number: ");
                            identNum = scanner.nextLine();
                            if (regexIdentNumber(identNum)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID IDENTIFICATION] Must have 9 or 12 digits");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter employee's phone number: ");
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
                            System.out.print("Enter employee's email: ");
                            email = scanner.nextLine();
                            if (regexEmail(email)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID EMAIL] Illegal email format");
                            }
                        } while (!valid);
                        valid = false;
                        System.out.print("Enter employee's education level: ");
                        String eduLevel = eduLevel();
                        System.out.print("Enter employee's job position: ");
                        String jobPos = scanner.nextLine();
                        do {
                            System.out.print("Enter employee's salary ($): ");
                            salary = Double.parseDouble(scanner.nextLine());
                            if (salary > 0) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID SALARY] Must be greater than 0");
                            }
                        } while (!valid);
                        valid = false;
                        Employee employee = new Employee(id, name, dob, gender,
                                identNum, phoneNumber, email, eduLevel, jobPos, salary);
                        controller.addNewEmployee(employee);

                        break;
                    case 3:
                        Employee newEmployee = new Employee();
                        String newId;
                        String newName;
                        String newIdentNum;
                        String newPhoneNumber;
                        String idToFind;
                        String newDob = null;
                        String newEmail;
                        double newSalary;
                        System.out.println("[EDITING CUSTOMER]");
                        do {
                            System.out.print("Enter employee's ID: ");
                            idToFind = scanner.nextLine();
                            if (controller.idExist(idToFind)) {
                                newEmployee.setId(idToFind);
                                valid = true;
                            } else {
                                System.out.println("[ERROR] No ID found");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter employee's new ID: ");
                            newId = scanner.nextLine();
                            if (regexEmployeeId(newId)) {
                                if (!controller.idExist(newId) || newEmployee.getId().equals(newId)) {
                                    valid = true;
                                } else {
                                    System.out.println("[INVALID ID] Must be unique");
                                }
                            } else {
                                System.out.println("[INVALID ID] Must look like this: NV-0123");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter employee's new name: ");
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
                                System.out.print("Enter employee's new date of birth: ");
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
                        System.out.print("Enter employee's new gender: ");
                        String newGender = scanner.nextLine();
                        do {
                            System.out.print("Enter employee's new identification number: ");
                            newIdentNum = scanner.nextLine();
                            if (regexIdentNumber(newIdentNum)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID IDENTIFICATION] Must have 9 or 12 digits");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter employee's new phone number: ");
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
                            System.out.print("Enter employee's new email: ");
                            newEmail = scanner.nextLine();
                            if (regexEmail(newEmail)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID EMAIL] Illegal email format");
                            }
                        } while (!valid);
                        valid = false;
                        System.out.print("Enter employee's new education level: ");
                        String newEduLevel = eduLevel();
                        System.out.print("Enter employee's new job position: ");
                        String newJobPos = scanner.nextLine();
                        do {
                            System.out.print("Enter employee's new salary ($): ");
                            newSalary = Double.parseDouble(scanner.nextLine());
                            if (newSalary > 0) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID SALARY] Must be greater than 0");
                            }
                        } while (!valid);
                        valid = false;
                        newEmployee = new Employee(newId, newName, newDob, newGender, newIdentNum,
                                newPhoneNumber, newEmail, newEduLevel, newJobPos, newSalary);
                        boolean result = controller.editEmployee(idToFind, newEmployee);
                        if (result) {
                            System.out.println("Success");
                        } else {
                            System.out.println("Something went wrong...");
                        }
                        break;
                    case 4:
                        System.out.println("[DELETING EMPLOYEE]");
                        System.out.print("Enter employee's ID: ");
                        String idToDel = scanner.nextLine();
                        if (controller.deleteEmployee(idToDel)) {
                            System.out.println("Success!");
                        } else {
                            System.out.println("ID does not exist!");
                        }
                        break;
                    case 5:
                        System.out.println("[SEARCHING EMPLOYEE]");
                        System.out.print("Enter a name: ");
                        String nameToFind = scanner.nextLine();
                        List<Employee> employeeList = controller.searchEmployeeByName(nameToFind);
                        if (employeeList.isEmpty()) {
                            System.out.println("No customer found!");
                        } else {
                            for (Employee c : employeeList) {
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

    private static String eduLevel() {
        String level;
        do {
            try {
                System.out.println("---SELECT EDUCATION LEVEL---");
                System.out.println("1. Intermediate");
                System.out.println("2. College");
                System.out.println("3. Undergraduate ");
                System.out.println("4. Graduate");
                System.out.print("Your selection: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        level = "Intermediate";
                        return level;
                    case 2:
                        level = "College";
                        return level;
                    case 3:
                        level = "Undergraduate";
                        return level;
                    case 4:
                        level = "Graduate";
                        return level;
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

