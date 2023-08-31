package repository.facility;

import model.facilities.Facility;
import model.facilities.House;
import model.facilities.Room;
import model.facilities.Villa;

import java.util.*;

public class FacilityRepositoryImpl implements IFacilityRepository {
    private static Map<Facility, Integer> properties = new LinkedHashMap<>();

    static {
        properties.put(new Villa("SVVL-0001", "Furama Ocean Villa", 150,
                2000, 8, "Weekly Rental", "Furama Standard"
                , 10, 3), 0);
        properties.put(new House("SVHO-0001", "Furama Tree House", 100,
                1500, 4, "Weekly Rental",
                "Furama Standard", 1), 3);
        properties.put(new Room("SVRO-0001", "Furama Lux Suite", 80,
                800, 2, "Daily Rental"
                , "Free 5G Wifi"), 5);
    }

    @Override
    public List<Facility> displayList() {
        List<Facility> propertyList = new ArrayList<>();
        for (Map.Entry<Facility, Integer> prop : properties.entrySet()) {
            propertyList.add(prop.getKey());
        }
        return propertyList;
    }

    @Override
    public void addNew(Facility facility) {
        properties.put(facility, 0);
    }

    @Override
    public List<Facility> displayMaintenanceList() {
        List<Facility> maintenanceList = new ArrayList<>();
        for (Map.Entry<Facility, Integer> prop : properties.entrySet()) {
            if (prop.getValue() >= 5) {
                maintenanceList.add(prop.getKey());
            }
        }
        return maintenanceList;
    }

    @Override
    public boolean deleteFacility(String id) {
        for (Map.Entry<Facility, Integer> prop : properties.entrySet()) {
            if (prop.getKey().getId().equals(id)) {
                properties.remove(prop.getKey());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean idExist(String id) {
        for (Map.Entry<Facility, Integer> facil : properties.entrySet()) {
            if (facil.getKey().getId().equals(id)) {
                return false;
            }
        }
        return true;
    }
}
