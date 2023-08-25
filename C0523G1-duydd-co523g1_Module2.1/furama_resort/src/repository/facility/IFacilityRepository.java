package repository.facility;

import model.facilities.Facility;
import repository.IRepository;

import java.util.List;

public interface IFacilityRepository extends IRepository<Facility> {
    List<Facility> displayMaintenanceList();
    boolean deleteFacility(String id);
}
