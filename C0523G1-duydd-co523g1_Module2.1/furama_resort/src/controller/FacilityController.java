package controller;

import model.facilities.Facility;
import service.facilities.FacilityServiceImpl;
import service.facilities.IFacilityService;

import java.util.List;

public class FacilityController {
    private final IFacilityService facilityService = new FacilityServiceImpl();
    List<Facility> displayFacilities() {
        return facilityService.display();
    }
    void addNewFacility(Facility facility) {
        facilityService.addNew(facility);
    }
    List<Facility> displayMaintenanceList() {
        return facilityService.displayMaintenanceList();
    }
    boolean deleteFacility(String id) {
        return facilityService.deleteFacility(id);
    }

}
