package model.people;

public abstract class Person {
    private String id;
    private String name;
    private String dob;
    private String gender;
    private String identNumber;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String id, String name, String dob, String gender, String identNumber, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.identNumber = identNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[ID: " + id + "]"
                + "\nName: " + "....................... " + name
                + "\nDate of birth: "+ ".............. " + dob
                + "\nGender: " + "..................... " + gender
                + "\nIdentity number: " + "............ " + identNumber
                + "\nPhone number: " + "............... " + phoneNumber
                + "\nEmail: " + "...................... " + email;
    }
}
