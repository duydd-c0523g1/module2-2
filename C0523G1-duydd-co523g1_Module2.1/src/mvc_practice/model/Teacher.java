package src.mvc_practice.model;

public class Teacher extends Person {
    private String profession;
    public Teacher() {
    }

    public Teacher(String id, String name, String dob, String gender, String profession) {
        super(id, name, dob, gender);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getInfoToCsv() {
        return this.getId() + "," + this.getName() + "," + this.getDob()  + "," + this.getGender() + "," + this.profession;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Profession: " + profession + "\n" +
                "----------------------------";
    }
}
