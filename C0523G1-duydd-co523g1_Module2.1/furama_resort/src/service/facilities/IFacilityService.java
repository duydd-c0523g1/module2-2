package service.facilities;

import model.facilities.Facility;
import service.IService;

import java.util.List;

public interface IFacilityService extends IService<Facility> {
    List<Facility> displayMaintenanceList();

    boolean deleteFacility(String id);
}
