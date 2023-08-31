package controller;

import model.facilities.Facility;
import service.facilities.FacilityServiceImpl;
import service.facilities.IFacilityService;

import java.util.List;

public class FacilityController {
    private final IFacilityService facilityService = new FacilityServiceImpl();

    public List<Facility> displayFacilities() {
        return facilityService.display();
    }

    public void addNewFacility(Facility facility) {
        facilityService.addNew(facility);
    }

    public List<Facility> displayMaintenanceList() {
        return facilityService.displayMaintenanceList();
    }

    public boolean deleteFacility(String id) {
        return facilityService.deleteFacility(id);
    }
    public boolean idExist(String id) {
        return facilityService.idExist(id);
    }

}
