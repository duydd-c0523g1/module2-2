package src.mvc_practice.model;

public abstract class Person {
    private String id;
    private String name;
    private String dob;
    private String gender;
    public Person() {
    }

    public Person(String id, String name, String dob, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
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
    public abstract String getInfoToCsv();

    @Override
    public String toString() {
        return  "ID:" + id + "\n" +
                "Name:'" + name + "\n" +
                "Date of birth: " + dob + "\n" +
                "Gender: " + gender + "\n";
    }
}
