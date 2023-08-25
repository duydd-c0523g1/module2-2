package model.facilities;

public class Room extends Facility {
    private String additionalFreeService;

    public Room() {
    }

    public Room(String id, String name, int usageArea, double rentalFee, int maxUserAmount, String rentalType, String additionalFreeService) {
        super(id, name, usageArea, rentalFee, maxUserAmount, rentalType);
        this.additionalFreeService = additionalFreeService;
    }

    public String getAdditionalFreeServices() {
        return additionalFreeService;
    }

    public void setAdditionalFreeServices(String additionalFreeService) {
        this.additionalFreeService = additionalFreeService;
    }

    @Override
    public String toString() {
        return super.toString()
                +"\nAdditional free service: " + additionalFreeService;
    }
}
