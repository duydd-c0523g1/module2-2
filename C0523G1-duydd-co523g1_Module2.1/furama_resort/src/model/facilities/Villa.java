package model.facilities;

public class Villa extends Facility {
    private String roomStandard;
    private int poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String id, String name, int usageArea, double rentalFee, int maxUserAmount, String rentalType, String roomStandard, int poolArea, int floors) {
        super(id, name, usageArea, rentalFee, maxUserAmount, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nRoom standard: " + ".............. " + roomStandard
                + "\nPool area: " + ".................. " + poolArea
                + "\nNumber of floors: " + "........... " + floors;
    }
}
