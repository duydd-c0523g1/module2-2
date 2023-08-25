package model.facilities;

public class House extends Facility {
    private String roomStandard;
    private int floors;

    public House() {
    }

    public House(String id, String name, int usageArea, double rentalFee, int maxUserAmount, String rentalType, String roomStandard, int floor) {
        super(id, name, usageArea, rentalFee, maxUserAmount, rentalType);
        this.roomStandard = roomStandard;
        this.floors = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floors;
    }

    public void setFloor(int floor) {
        this.floors = floor;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nRoom standard: " + roomStandard
                + "\nNumber of floors: " + floors;
    }
}
