package repository.facility;

import model.facilities.Facility;

import java.util.List;

public class FacilityRepositoryImpl implements IFacilityRepository {
    @Override
    public List<Facility> displayList() {
        return null;
    }

    @Override
    public void addNew(Facility facility) {

    }

    @Override
    public List<Facility> displayMaintenanceList() {
        return null;
    }

    @Override
    public boolean deleteFacility(String id) {
        return false;
    }
}
