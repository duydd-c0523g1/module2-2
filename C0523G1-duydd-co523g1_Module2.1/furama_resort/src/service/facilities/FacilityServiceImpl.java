package service.facilities;

import model.facilities.Facility;
import repository.facility.FacilityRepositoryImpl;
import repository.facility.IFacilityRepository;

import java.util.List;

public class FacilityServiceImpl implements IFacilityService {
    private final IFacilityRepository facilityRepository = new FacilityRepositoryImpl();
    @Override
    public void addNew(Facility facility) {
        facilityRepository.addNew(facility);
    }

    @Override
    public List<Facility> display() {
        return facilityRepository.displayList();
    }

    @Override
    public List<Facility> displayMaintenanceList() {
        return facilityRepository.displayMaintenanceList();
    }

    @Override
    public boolean deleteFacility(String id) {
        return facilityRepository.deleteFacility(id);
    }
}
