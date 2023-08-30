package model.people;

public class Customer extends Person {
    private String type;
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String dob, String gender, String identNumber,
                    String phoneNumber, String email, String type, String address) {
        super(id, name, dob, gender, identNumber, phoneNumber, email);
        this.type = type;
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCustomer type: " + ".............. " + type
                + "\nAddress: " + ".................... " + address;
    }
}
