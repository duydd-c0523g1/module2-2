package model.facilities;

public abstract class Facility {
    private String id;
    private String name;
    private int usageArea;
    private double rentalFee;
    private int maxUserAmount;
    private String rentalType;

    public Facility() {
    }

    public Facility(String id, String name, int usageArea, double rentalFee, int maxUserAmount, String rentalType) {
        this.id = id;
        this.name = name;
        this.usageArea = usageArea;
        this.rentalFee = rentalFee;
        this.maxUserAmount = maxUserAmount;
        this.rentalType = rentalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUsageArea() {
        return usageArea;
    }

    public void setUsageArea(int usageArea) {
        this.usageArea = usageArea;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public int getMaxUserAmount() {
        return maxUserAmount;
    }

    public void setMaxUserAmount(int maxUserAmount) {
        this.maxUserAmount = maxUserAmount;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + "\nFacility name: " + name
                + "\nArea in use: " + usageArea
                + "\nRental fee: " + rentalFee
                + "\nUser limit: " + maxUserAmount
                + "\nRental type: " + rentalType;
    }
}
