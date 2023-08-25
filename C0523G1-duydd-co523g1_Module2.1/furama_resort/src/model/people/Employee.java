package model.people;

import view.submenu.EmployeeManagement;

public class Employee extends Person {
    private String eduLevel;
    private String jobPosition;
    private double salary;
    public Employee() {
    }

    public Employee(String id, String name, String dob, String gender,
                    String identNumber, String phoneNumber, String email,
                    String eduLevel, String jobPosition, double salary) {
        super(id, name, dob, gender, identNumber, phoneNumber, email);
        this.eduLevel = eduLevel;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nEducation level: " + eduLevel
                + "\nJob position: " + jobPosition
                + "\nSalary: " + salary;
    }
}
