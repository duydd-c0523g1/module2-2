package extra.bai8;

import java.util.List;

public class Employee {
    private String name;
    private int age;
    private List<String> awards;
    private double ctc;
    private int experienceYears;
    public Employee() {
    }

    public Employee(String name, int age, List<String> awards, double ctc, int experienceYears) {
        this.name = name;
        this.age = age;
        this.awards = awards;
        this.ctc = ctc;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public double getCtc() {
        return ctc;
    }

    public void setCtc(double ctc) {
        this.ctc = ctc;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", awards=" + awards +
                ", ctc=" + ctc +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
