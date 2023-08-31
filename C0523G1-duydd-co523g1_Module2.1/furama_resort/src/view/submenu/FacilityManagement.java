package view.submenu;

import controller.FacilityController;
import model.facilities.Facility;
import model.facilities.House;
import model.facilities.Room;
import model.facilities.Villa;
import view.MainView;

import java.util.List;
import java.util.Scanner;

import static utils.RegEx.*;
import static utils.Validator.validateName;

public class FacilityManagement {
    private static final FacilityController CONTROLLER = new FacilityController();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static void showMenu() {
        System.out.println("-----FACILITY MANAGEMENT-----");
        System.out.println("1. Display facilities");
        System.out.println("2. Add new facility");
        System.out.println("3. Facilities maintenance");
        System.out.println("4. Delete facility");
        System.out.println("5. Back to main menu");
        System.out.println("0. Exit");
    }

    public static void launchFacilityMenu() {
        do {
            try {
                showMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(SCANNER.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("[DISPLAYING FACILITY LIST]");
                        List<Facility> facilities = CONTROLLER.displayFacilities();
                        if (facilities.isEmpty()) {
                            System.out.println("No facility found");
                        } else {
                            for (Facility facility : facilities) {
                                System.out.println("-----------------------------");
                                System.out.println(facility);
                                System.out.println("-----------------------------");
                            }
                        }
                        break;
                    case 2:
                        do {
                            try {
                                System.out.println("[ADDING NEW FACILITY]");
                                System.out.println("1. Add a new Villa");
                                System.out.println("2. Add a new House");
                                System.out.println("3. Add a new Room");
                                System.out.println("0. Back");
                                System.out.print("Your option: ");
                                int selection = Integer.parseInt(SCANNER.nextLine());
                                if (selection == 1) {
                                    CONTROLLER.addNewFacility(newVilla());
                                } else if (selection == 2) {
                                    CONTROLLER.addNewFacility(newHouse());
                                } else if (selection == 3) {
                                    CONTROLLER.addNewFacility(newRoom());
                                } else if (selection == 0) {
                                    launchFacilityMenu();
                                } else {
                                    System.out.println("Function unavailable");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a number");
                            } catch (Exception e) {
                                System.out.println("Something went wrong...");
                            }
                        } while (true);
                    case 3:
                        List<Facility> maintenanceList = CONTROLLER.displayMaintenanceList();
                        if (maintenanceList.isEmpty()) {
                            System.out.println("Facilities are in good condition");
                        } else {
                            for (Facility m : maintenanceList) {
                                System.out.println("-----------------------------");
                                System.out.println(m);
                                System.out.println("-----------------------------");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("[DELETING FACILITY]");
                        System.out.print("Enter facility's ID: ");
                        String id = SCANNER.nextLine();
                        if (CONTROLLER.deleteFacility(id)) {
                            System.out.println("Success!");
                        } else {
                            System.out.println("No facility found");
                        }
                        break;
                    case 5:
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
                System.out.println("Something went wrong...");
            }
        } while (true);
    }

    private static Facility newVilla() {
        String id;
        String name;
        int usageArea = 0;
        double rentalFee = 0;
        int maxUserAmount = 0;
        String rentalType;
        String roomStandard;
        int poolArea = 0;
        int floor = 0;
        boolean valid = false;
        System.out.println("[ADDING NEW VILLA]");
        do {
            System.out.print("Enter villa's ID: ");
            id = SCANNER.nextLine();
            if (regexVillaId(id)) {
                if (!CONTROLLER.idExist(id)) {
                    System.out.println("[INVALID ID] ID must be unique");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("[INVALID ID] Must look like this: SVVL-0123");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter villa's name: ");
            name = SCANNER.nextLine();
            if (validateName(name)) {
                valid = true;
            } else {
                System.out.println("[INVALID NAME] Cannot use this name");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter usage area: ");
                usageArea = Integer.parseInt(SCANNER.nextLine());
                if (usageArea >= 30) {
                    valid = true;
                } else {
                    System.out.println("[INVALID AREA] Must be larger than 30m2");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }

        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter rental fee ($): ");
                rentalFee = Double.parseDouble(SCANNER.nextLine());
                if (rentalFee >= 0) {
                    valid = true;
                } else {
                    System.out.println("[INVALID FEE] Must be higher than 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter maximum number of user: ");
                maxUserAmount = Integer.parseInt(SCANNER.nextLine());
                if (maxUserAmount > 0 && maxUserAmount < 20) {
                    valid = true;
                } else {
                    System.out.println("[INVALID NUMBER] Must be higher than 0 and lower than 20 user");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter rental type: ");
            rentalType = SCANNER.nextLine();
            if (validateName(rentalType)) {
                valid = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter room standard: ");
            roomStandard = SCANNER.nextLine();
            if (validateName(roomStandard)) {
                valid = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter pool area: ");
                poolArea = Integer.parseInt(SCANNER.nextLine());
                if (poolArea >= 30) {
                    valid = true;
                } else {
                    System.out.println("[INVALID AREA] Must be larger than 30m2");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter number of floors: ");
                floor = Integer.parseInt(SCANNER.nextLine());
                if (floor > 0) {
                    valid = true;
                } else {
                    System.out.println("[INVALID FLOOR] Are you high?");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        return new Villa(id, name, usageArea, rentalFee,
                maxUserAmount, rentalType, roomStandard, poolArea, floor);
    }

    private static Facility newHouse() {
        String id;
        String name;
        int usageArea = 0;
        double rentalFee = 0;
        int maxUserAmount = 0;
        String rentalType;
        String roomStandard;
        int floor = 0;
        boolean valid = false;
        System.out.println("[ADDING NEW HOUSE]");
        do {
            System.out.print("Enter house's ID: ");
            id = SCANNER.nextLine();
            if (regexHouseId(id)) {
                if (!CONTROLLER.idExist(id)) {
                    System.out.println("[INVALID ID] ID must be unique");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("[INVALID ID] Must look like this: SVHO-0123");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter house's name: ");
            name = SCANNER.nextLine();
            if (validateName(name)) {
                valid = true;
            } else {
                System.out.println("[INVALID NAME] Cannot use this name");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter usage area: ");
                usageArea = Integer.parseInt(SCANNER.nextLine());
                if (usageArea >= 30) {
                    valid = true;
                } else {
                    System.out.println("[INVALID AREA] Must be larger than 30m2");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter rental fee ($): ");
                rentalFee = Double.parseDouble(SCANNER.nextLine());
                if (rentalFee >= 0) {
                    valid = true;
                } else {
                    System.out.println("[INVALID FEE] Must be higher than 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter maximum number of user: ");
                maxUserAmount = Integer.parseInt(SCANNER.nextLine());
                if (maxUserAmount > 0 && maxUserAmount < 20) {
                    valid = true;
                } else {
                    System.out.println("[INVALID NUMBER] Must be higher than 0 and lower than 20 user");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter rental type: ");
            rentalType = SCANNER.nextLine();
            if (validateName(rentalType)) {
                valid = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter room standard: ");
            roomStandard = SCANNER.nextLine();
            if (validateName(roomStandard)) {
                valid = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter number of floors: ");
                floor = Integer.parseInt(SCANNER.nextLine());
                if (floor > 0) {
                    valid = true;
                } else {
                    System.out.println("[INVALID FLOOR] Are you high?");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        return new House(id, name, usageArea, rentalFee,
                maxUserAmount, rentalType, roomStandard, floor);
    }


    private static Facility newRoom() {
        String id;
        String name;
        int usageArea = 0;
        double rentalFee = 0;
        int maxUserAmount = 0;
        String rentalType;
        String roomService;
        boolean valid = false;
        System.out.println("[ADDING NEW ROOM]");
        do {
            System.out.print("Enter room's ID: ");
            id = SCANNER.nextLine();
            if (regexRoomId(id)) {
                if (!CONTROLLER.idExist(id)) {
                    System.out.println("[INVALID ID] ID must be unique");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("[INVALID ID] Must look like this: SVRO-0123");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter room's name: ");
            name = SCANNER.nextLine();
            if (validateName(name)) {
                valid = true;
            } else {
                System.out.println("[INVALID NAME] Cannot use this name");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter usage area: ");
                usageArea = Integer.parseInt(SCANNER.nextLine());
                if (usageArea >= 30) {
                    valid = true;
                } else {
                    System.out.println("[INVALID AREA] Must be larger than 30m2");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter rental fee ($): ");
                rentalFee = Double.parseDouble(SCANNER.nextLine());
                if (rentalFee >= 0) {
                    valid = true;
                } else {
                    System.out.println("[INVALID FEE] Rental fee cannot be negative");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            try {
                System.out.print("Enter maximum number of user: ");
                maxUserAmount = Integer.parseInt(SCANNER.nextLine());
                if (maxUserAmount > 0 && maxUserAmount < 6) {
                    valid = true;
                } else {
                    System.out.println("[INVALID NUMBER] Must be higher than 0 and lower than 6 user");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Must be a number");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter rental type: ");
            rentalType = SCANNER.nextLine();
            if (validateName(rentalType)) {
                valid = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!valid);
        valid = false;
        do {
            System.out.print("Enter additional room service: ");
            roomService = SCANNER.nextLine();
            if (validateName(roomService)) {
                valid = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!valid);
        return new Room(id, name, usageArea, rentalFee, maxUserAmount, rentalType, roomService);
    }
}
