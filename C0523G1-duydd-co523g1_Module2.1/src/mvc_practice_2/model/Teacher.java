package src.mvc_practice_2.model;

public class Teacher extends Person{
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

    @Override
    public String toString() {
        return "Teacher{" +
                "profession='" + profession + '\'' +
                "} " + super.toString();
    }
}
