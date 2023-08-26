package view.submenu;

import controller.EmployeeController;
import model.people.Employee;
import utils.Validator;
import utils.RegEx;
import view.MainView;

import java.util.List;
import java.util.Scanner;

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
                switch (option) {
                    case 1:
                        System.out.println("[DISPLAYING EMPLOYEE LIST]");
                        List<Employee> employees = controller.displayEmployeeList();
                        if (employees.isEmpty()) {
                            System.out.println("No customer found");
                        } else {
                            for (Employee employee : employees) {
                                System.out.println(employee);
                            }
                        }
                        break;
                    case 2:
                        boolean validId = false;
                        boolean validName = false;
                        boolean validIdent = false;
                        boolean validPhone = false;
                        boolean validSalary = false;
                        boolean validAge = false;
                        String name;
                        String id;
                        String identNum;
                        String phoneNumber;
                        String dob;
                        double salary;
                        System.out.println("[ADDING NEW EMPLOYEE]");
                        do {
                            System.out.print("Enter employee's ID: ");
                            id = scanner.nextLine();
                            if (RegEx.regexEmployeeId(id)) {
                                if (!controller.idExist(id)) {
                                    validId = true;
                                } else {
                                    System.out.println("[INVALID ID] Must be unique");
                                }
                            } else {
                                System.out.println("[INVALID ID] Must look like this: NV-0123");
                            }
                        } while (!validId);
                        do {
                            System.out.print("Enter employee's name: ");
                            name = scanner.nextLine();
                            if (Validator.validateName(name)) {
                                validName = true;
                            } else {
                                System.out.println("[INVALID NAME] This name is invalid!");
                            }
                        } while (!validName);
                        do {
                            System.out.print("Enter employee's date of birth: ");
                            dob = scanner.nextLine();
                            if (Validator.validateAge(dob)) {
                                validAge = true;
                            } else {
                                System.out.println("[INVALID AGE] Must be 18 or older");
                            }
                        } while (!validAge);

                        System.out.print("Enter employee's gender: ");
                        String gender = scanner.nextLine();
                        do {
                            System.out.print("Enter employee's identification number: ");
                            identNum = scanner.nextLine();
                            if (RegEx.regexIdentNumber(identNum)) {
                                validIdent = true;
                            } else {
                                System.out.println("[INVALID IDENTIFICATION] Must have 9 or 12 digits");
                            }
                        } while (!validIdent);
                        do {
                            System.out.print("Enter employee's phone number: ");
                            phoneNumber = scanner.nextLine();
                            if (RegEx.regexPhoneNumber(phoneNumber)) {
                                validPhone = true;
                            } else {
                                System.out.println("[INVALID PHONE NUMBER] Must start with 0 and have " +
                                        "\n10 digits in total");
                            }
                        } while (!validPhone);
                        System.out.print("Enter employee's email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter employee's education level: ");
                        String eduLevel = scanner.nextLine();
                        System.out.print("Enter employee's job position: ");
                        String jobPos = scanner.nextLine();
                        do {
                            System.out.print("Enter employee's salary: ");
                            salary = Double.parseDouble(scanner.nextLine());
                            if (salary > 0) {
                                validSalary = true;
                            } else {
                                System.out.println("[INVALID SALARY] Must be greater than 0");
                            }
                        } while (!validSalary);
                        Employee employee = new Employee(id, name, dob, gender,
                                identNum, phoneNumber, email, eduLevel, jobPos, salary);
                        controller.addNewEmployee(employee);

                        break;
                    case 3:
                        boolean validNewId = false;
                        boolean validNewName = false;
                        boolean validNewIdent = false;
                        boolean validNewPhone = false;
                        boolean validNewSalary = false;
                        boolean validIdToFind = false;
                        boolean validNewAge = false;
                        String newId;
                        String newName;
                        String newIdentNum;
                        String newPhoneNumber;
                        String idToFind;
                        String newDob;
                        double newSalary;
                        System.out.println("[EDITING CUSTOMER]");
                        do {
                            System.out.print("Enter employee's ID: ");
                            idToFind = scanner.nextLine();
                            if (controller.idExist(idToFind)) {
                                validIdToFind = true;
                            } else {
                                System.out.println("[ERROR] No ID found");
                            }
                        } while (!validIdToFind);
                        do {
                            System.out.print("Enter employee's new ID: ");
                            newId = scanner.nextLine();
                            if (RegEx.regexEmployeeId(newId)) {
                                validNewId = true;
                            } else {
                                System.out.println("[INVALID ID] Must look like this: NV-0123");
                            }
                        } while (!validNewId);
                        do {
                            System.out.print("Enter employee's new name: ");
                            newName = scanner.nextLine();
                            if (Validator.validateName(newName)) {
                                validNewName = true;
                            } else {
                                System.out.println("[INVALID NAME] This name is invalid!");
                            }
                        } while (!validNewName);
                        do {
                            System.out.print("Enter employee's new date of birth: ");
                            newDob = scanner.nextLine();
                            if (Validator.validateAge(newDob)) {
                                validNewAge = true;
                            } else {
                                System.out.println("[INVALID AGE] Must be 18 or older");
                            }
                        } while (!validNewAge);
                        System.out.print("Enter employee's new gender: ");
                        String newGender = scanner.nextLine();
                        do {
                            System.out.print("Enter employee's new identification number: ");
                            newIdentNum = scanner.nextLine();
                            if (RegEx.regexIdentNumber(newIdentNum)) {
                                validNewIdent = true;
                            } else {
                                System.out.println("[INVALID IDENTIFICATION] Must have 9 or 12 digits");
                            }
                        } while (!validNewIdent);
                        do {
                            System.out.print("Enter employee's new phone number: ");
                            newPhoneNumber = scanner.nextLine();
                            if (RegEx.regexPhoneNumber(newPhoneNumber)) {
                                validNewPhone = true;
                            } else {
                                System.out.println("[INVALID PHONE NUMBER] Must start with 0 and have " +
                                        "\n10 digits in total");
                            }
                        } while (!validNewPhone);
                        System.out.print("Enter employee's new email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter employee's new education level: ");
                        String newEduLevel = scanner.nextLine();
                        System.out.print("Enter employee's new job position: ");
                        String newJobPos = scanner.nextLine();
                        do {
                            System.out.print("Enter employee's new salary: ");
                            newSalary = Double.parseDouble(scanner.nextLine());
                            if (newSalary > 0) {
                                validNewSalary = true;
                            } else {
                                System.out.println("[INVALID SALARY] Must be greater than 0");
                            }
                        } while (!validNewSalary);
                        Employee newEmployee = new Employee(newId, newName, newDob, newGender, newIdentNum,
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
