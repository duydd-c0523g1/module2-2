package view.submenu;

import controller.FacilityController;
import model.facilities.Facility;
import model.facilities.House;
import model.facilities.Room;
import model.facilities.Villa;
import utils.RegEx;
import utils.Validator;
import view.MainView;

import java.util.List;
import java.util.Scanner;

public class FacilityManagement {
    private static final FacilityController controller = new FacilityController();
    private static final Scanner scanner = new Scanner(System.in);

    private static void showMenu() {
        System.out.println("-----FACILITY MANAGEMENT-----");
        System.out.println("1. Display facilities");
        System.out.println("2. Add new facility");
        System.out.println("3. Facilities maintenance");
        System.out.println("4. Delete facility");
        System.out.println("5. Back to main menu");
        System.out.println("0. Exit");
    }

    public static void startFacilityManagement() {
        do {
            try {
                showMenu();
                System.out.print("Your option: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        List<Facility> facilities = controller.displayFacilities();
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
                                System.out.print("Your option: ");
                                int selection = Integer.parseInt(scanner.nextLine());
                                if (selection == 1) {
                                    controller.addNewFacility(newVilla());
                                } else if (selection == 2) {
                                    controller.addNewFacility(newHouse());
                                } else if (selection == 3) {
                                    controller.addNewFacility(newRoom());
                                } else if (selection == 0) {
                                    startFacilityManagement();
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
                        List<Facility> maintenanceList = controller.displayMaintenanceList();
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
                        String id = scanner.nextLine();
                        if (controller.deleteFacility(id)) {
                            System.out.println("Success!");
                        } else {
                            System.out.println("No facility found");
                        }
                        break;
                    case 5:
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
                System.out.println("Something went wrong...");
            }
        } while (true);
    }

    private static Facility newVilla() {
        String id;
        String name;
        int usageArea;
        double rentalFee;
        int maxUserAmount;
        String rentalType;
        String roomStandard;
        int poolArea;
        int floor;
        boolean validId = false;
        boolean validName = false;
        boolean validUsageArea = false;
        boolean validRentalFee = false;
        boolean validMaxUser = false;
        boolean validRentalType = false;
        boolean validRoomStandard = false;
        boolean validPoolArea = false;
        boolean validFloor = false;
        System.out.println("[ADDING NEW VILLA]");
        do {
            System.out.print("Enter villa's ID: ");
            id = scanner.nextLine();
            if (RegEx.regexVillaId(id)) {
                validId = true;
            } else {
                System.out.println("[INVALID ID] Must look like this: SVVL-0123");
            }
        } while (!validId);
        do {
            System.out.print("Enter villa's name: ");
            name = scanner.nextLine();
            if (Validator.validateName(name)) {
                validName = true;
            } else {
                System.out.println("[INVALID NAME] Cannot use this name");
            }
        } while (!validName);
        do {
            System.out.print("Enter usage area: ");
            usageArea = Integer.parseInt(scanner.nextLine());
            if (usageArea >= 30) {
                validUsageArea = true;
            } else {
                System.out.println("[INVALID AREA] Must be larger than 30m2");
            }
        } while (!validUsageArea);
        do {
            System.out.print("Enter rental fee ($): ");
            rentalFee = Double.parseDouble(scanner.nextLine());
            if (rentalFee >= 0) {
                validRentalFee = true;
            } else {
                System.out.println("[INVALID FEE] Must be higher than 0");
            }
        } while (!validRentalFee);
        do {
            System.out.print("Enter maximum number of user: ");
            maxUserAmount = Integer.parseInt(scanner.nextLine());
            if (maxUserAmount > 0 && maxUserAmount < 20) {
                validMaxUser = true;
            } else {
                System.out.println("[INVALID NUMBER] Must be higher than 0 and lower than 20 user");
            }
        } while (!validMaxUser);
        do {
            System.out.print("Enter rental type: ");
            rentalType = scanner.nextLine();
            if (Validator.validateName(rentalType)) {
                validRentalType = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!validRentalType);
        do {
            System.out.print("Enter room standard: ");
            roomStandard = scanner.nextLine();
            if (Validator.validateName(roomStandard)) {
                validRoomStandard = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!validRoomStandard);
        do {
            System.out.print("Enter pool area: ");
            poolArea = Integer.parseInt(scanner.nextLine());
            if (poolArea >= 30) {
                validPoolArea = true;
            } else {
                System.out.println("[INVALID AREA] Must be larger than 30m2");
            }
        } while (!validPoolArea);
        do {
            System.out.print("Enter number of floors: ");
            floor = Integer.parseInt(scanner.nextLine());
            if (floor > 0) {
                validFloor = true;
            } else {
                System.out.println("[INVALID FLOOR] Are you high?");
            }
        } while (!validFloor);

        return new Villa(id, name, usageArea, rentalFee,
                maxUserAmount, rentalType, roomStandard, poolArea, floor);
    }

    private static Facility newHouse() {
        String id;
        String name;
        int usageArea;
        double rentalFee;
        int maxUserAmount;
        String rentalType;
        String roomStandard;
        int floor;
        boolean validId = false;
        boolean validName = false;
        boolean validUsageArea = false;
        boolean validRentalFee = false;
        boolean validMaxUser = false;
        boolean validRentalType = false;
        boolean validRoomStandard = false;
        boolean validFloor = false;
        System.out.println("[ADDING NEW HOUSE]");
        do {
            System.out.print("Enter house's ID: ");
            id = scanner.nextLine();
            if (RegEx.regexHouseId(id)) {
                validId = true;
            } else {
                System.out.println("[INVALID ID] Must look like this: SVHO-0123");
            }
        } while (!validId);
        do {
            System.out.print("Enter house's name: ");
            name = scanner.nextLine();
            if (Validator.validateName(name)) {
                validName = true;
            } else {
                System.out.println("[INVALID NAME] Cannot use this name");
            }
        } while (!validName);
        do {
            System.out.print("Enter usage area: ");
            usageArea = Integer.parseInt(scanner.nextLine());
            if (usageArea >= 30) {
                validUsageArea = true;
            } else {
                System.out.println("[INVALID AREA] Must be larger than 30m2");
            }
        } while (!validUsageArea);
        do {
            System.out.print("Enter rental fee ($): ");
            rentalFee = Double.parseDouble(scanner.nextLine());
            if (rentalFee >= 0) {
                validRentalFee = true;
            } else {
                System.out.println("[INVALID FEE] Must be higher than 0");
            }
        } while (!validRentalFee);
        do {
            System.out.print("Enter maximum number of user: ");
            maxUserAmount = Integer.parseInt(scanner.nextLine());
            if (maxUserAmount > 0 && maxUserAmount < 20) {
                validMaxUser = true;
            } else {
                System.out.println("[INVALID NUMBER] Must be higher than 0 and lower than 20 user");
            }
        } while (!validMaxUser);
        do {
            System.out.print("Enter rental type: ");
            rentalType = scanner.nextLine();
            if (Validator.validateName(rentalType)) {
                validRentalType = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!validRentalType);
        do {
            System.out.print("Enter room standard: ");
            roomStandard = scanner.nextLine();
            if (Validator.validateName(roomStandard)) {
                validRoomStandard = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!validRoomStandard);
        do {
            System.out.print("Enter number of floors: ");
            floor = Integer.parseInt(scanner.nextLine());
            if (floor > 0) {
                validFloor = true;
            } else {
                System.out.println("[INVALID FLOOR] Are you high?");
            }
        } while (!validFloor);

        return new House(id, name, usageArea, rentalFee,
                maxUserAmount, rentalType, roomStandard, floor);
    }


    private static Facility newRoom() {
        String id;
        String name;
        int usageArea;
        double rentalFee;
        int maxUserAmount;
        String rentalType;
        String roomStandard;
        String roomService;
        boolean validId = false;
        boolean validName = false;
        boolean validUsageArea = false;
        boolean validRentalFee = false;
        boolean validMaxUser = false;
        boolean validRentalType = false;
        boolean validRoomStandard = false;
        boolean validService = false;
        System.out.println("[ADDING NEW ROOM]");
        do {
            System.out.print("Enter room's ID: ");
            id = scanner.nextLine();
            if (RegEx.regexRoomId(id)) {
                validId = true;
            } else {
                System.out.println("[INVALID ID] Must look like this: SVRO-0123");
            }
        } while (!validId);
        do {
            System.out.print("Enter room's name: ");
            name = scanner.nextLine();
            if (Validator.validateName(name)) {
                validName = true;
            } else {
                System.out.println("[INVALID NAME] Cannot use this name");
            }
        } while (!validName);
        do {
            System.out.print("Enter usage area: ");
            usageArea = Integer.parseInt(scanner.nextLine());
            if (usageArea >= 30) {
                validUsageArea = true;
            } else {
                System.out.println("[INVALID AREA] Must be larger than 30m2");
            }
        } while (!validUsageArea);
        do {
            System.out.print("Enter rental fee ($): ");
            rentalFee = Double.parseDouble(scanner.nextLine());
            if (rentalFee >= 0) {
                validRentalFee = true;
            } else {
                System.out.println("[INVALID FEE] Rental fee cannot be negative");
            }
        } while (!validRentalFee);
        do {
            System.out.print("Enter maximum number of user: ");
            maxUserAmount = Integer.parseInt(scanner.nextLine());
            if (maxUserAmount > 0 && maxUserAmount < 6) {
                validMaxUser = true;
            } else {
                System.out.println("[INVALID NUMBER] Must be higher than 0 and lower than 6 user");
            }
        } while (!validMaxUser);
        do {
            System.out.print("Enter rental type: ");
            rentalType = scanner.nextLine();
            if (Validator.validateName(rentalType)) {
                validRentalType = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!validRentalType);
        do {
            System.out.print("Enter room standard: ");
            roomStandard = scanner.nextLine();
            if (Validator.validateName(roomStandard)) {
                validRoomStandard = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!validRoomStandard);
        do {
            System.out.print("Enter additional room service: ");
            roomService = scanner.nextLine();
            if (Validator.validateName(roomService)) {
                validService = true;
            } else {
                System.out.println("[INVALID FORMAT] ...bruh wth was that??");
            }
        } while (!validService);
        return new Room(id, name, usageArea, rentalFee,
                maxUserAmount, rentalType, roomStandard);
    }
}
