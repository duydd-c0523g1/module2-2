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
    private static final EmployeeController CONTROLLER = new EmployeeController();
    private static final Scanner SCANNER = new Scanner(System.in);

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

    public static void launchEmployeeMenu() {
        do {
            try {
                showMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(SCANNER.nextLine());
                boolean valid = false;
                switch (option) {
                    case 1:
                        System.out.println("[DISPLAYING EMPLOYEE LIST]");
                        List<Employee> employees = CONTROLLER.displayEmployeeList();
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
                        String gender;
                        double salary;
                        System.out.println("[ADDING NEW EMPLOYEE]");
                        do {
                            System.out.print("Enter employee's ID: ");
                            id = SCANNER.nextLine();
                            if (regexEmployeeId(id)) {
                                if (!CONTROLLER.idExist(id)) {
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
                                System.out.print("Enter employee's date of birth: ");
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
                            System.out.print("Choose employee's gender: ");
                            gender = employeeGender();
                        do {
                            System.out.print("Enter employee's identity number: ");
                            identNum = SCANNER.nextLine();
                            if (regexIdentNumber(identNum)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID IDENTITY] Must have 9 or 12 digits");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter employee's phone number: ");
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
                            System.out.print("Enter employee's new email: ");
                            email = SCANNER.nextLine();
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
                        String jobPos = jobPos();
                        do {
                            System.out.print("Enter employee's salary ($): ");
                            salary = Double.parseDouble(SCANNER.nextLine());
                            if (salary > 0) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID SALARY] Must be greater than 0");
                            }
                        } while (!valid);
                        valid = false;
                        Employee employee = new Employee(id, name, dob, gender,
                                identNum, phoneNumber, email, eduLevel, jobPos, salary);
                        CONTROLLER.addNewEmployee(employee);

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
                        String newGender;
                        double newSalary;
                        System.out.println("[EDITING CUSTOMER]");
                        do {
                            System.out.print("Enter employee's ID: ");
                            idToFind = SCANNER.nextLine();
                            if (CONTROLLER.idExist(idToFind)) {
                                newEmployee.setId(idToFind);
                                valid = true;
                            } else {
                                System.out.println("[ERROR] No ID found");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter employee's new ID: ");
                            newId = SCANNER.nextLine();
                            if (regexEmployeeId(newId)) {
                                if (!CONTROLLER.idExist(newId) || newEmployee.getId().equals(newId)) {
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
                                System.out.print("Enter employee's new date of birth: ");
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
                            System.out.print("Choose employee's new gender: ");
                            newGender = employeeGender();
                        do {
                            System.out.print("Enter employee's new identity number: ");
                            newIdentNum = SCANNER.nextLine();
                            if (regexIdentNumber(newIdentNum)) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID IDENTITY] Must have 9 or 12 digits");
                            }
                        } while (!valid);
                        valid = false;
                        do {
                            System.out.print("Enter employee's new phone number: ");
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
                            System.out.print("Enter employee's new email: ");
                            newEmail = SCANNER.nextLine();
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
                        String newJobPos = jobPos();
                        do {
                            System.out.print("Enter employee's new salary ($): ");
                            newSalary = Double.parseDouble(SCANNER.nextLine());
                            if (newSalary > 0) {
                                valid = true;
                            } else {
                                System.out.println("[INVALID SALARY] Must be greater than 0");
                            }
                        } while (!valid);
                        valid = false;
                        newEmployee = new Employee(newId, newName, newDob, newGender, newIdentNum,
                                newPhoneNumber, newEmail, newEduLevel, newJobPos, newSalary);
                        boolean result = CONTROLLER.editEmployee(idToFind, newEmployee);
                        if (result) {
                            System.out.println("Success");
                        } else {
                            System.out.println("Something went wrong...");
                        }
                        break;
                    case 4:
                        System.out.println("[DELETING EMPLOYEE]");
                        System.out.print("Enter employee's ID: ");
                        String idToDel = SCANNER.nextLine();
                        if (CONTROLLER.deleteEmployee(idToDel)) {
                            System.out.println("Success!");
                        } else {
                            System.out.println("ID does not exist!");
                        }
                        break;
                    case 5:
                        System.out.println("[SEARCHING EMPLOYEE]");
                        System.out.print("Enter a name: ");
                        String nameToFind = SCANNER.nextLine();
                        List<Employee> employeeList = CONTROLLER.searchEmployeeByName(nameToFind);
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
                int option = Integer.parseInt(SCANNER.nextLine());
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
    private static String jobPos() {
        String jobPos;
        do {
            try {
                System.out.println("---SELECT Job Position---");
                System.out.println("1. Receptionist");
                System.out.println("2. Server");
                System.out.println("3. Specialist ");
                System.out.println("4. Supervisor");
                System.out.println("5. Manager");
                System.out.println("6. Director");
                System.out.print("Your selection: ");
                int option = Integer.parseInt(SCANNER.nextLine());
                switch (option) {
                    case 1:
                        jobPos = "Receptionist";
                        return jobPos;
                    case 2:
                        jobPos = "Server";
                        return jobPos;
                    case 3:
                        jobPos = "Specialist";
                        return jobPos;
                    case 4:
                        jobPos = "Supervisor";
                        return jobPos;
                    case 5:
                        jobPos = "Manager";
                        return jobPos;
                    case 6:
                        jobPos = "Director";
                        return jobPos;
                    default:
                        System.out.println("[INVALID OPTION] Please try again");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("[INVALID FORMAT] Please enter a number");
            }
        } while (true);
    }
    private static String employeeGender() {
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

