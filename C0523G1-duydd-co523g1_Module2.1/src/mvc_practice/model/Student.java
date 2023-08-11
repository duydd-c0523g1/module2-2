package src.mvc_practice.model;

public class Student extends Person {
    private String classId;
    private String score;
    public Student() {
    }

    public Student(String id, String name, String dob, String gender, String classId, String score) {
        super(id, name, dob, gender);
        this.classId = classId;
        this.score = score;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    @Override
    public String getInfoToCsv() {
        return this.getId() + "," + this.getName() + "," + this.getDob()  + "," + this.getGender() + "," + this.classId
                + "," + this.score;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Class: " + classId + "\n" +
                "Score: " + score;
    }
}
