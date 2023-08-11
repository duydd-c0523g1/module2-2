package src.mvc_practice.service;

import src.mvc_practice.model.Person;
import src.mvc_practice.model.Student;
import src.mvc_practice.model.Teacher;
import src.mvc_practice.repository.IRepository;
import src.mvc_practice.repository.Repository;

import java.util.List;
import java.util.Scanner;

public class Service implements IService {
    private static IRepository repository = new Repository();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void addNewStudent() {
        System.out.println("Insert student's ID");
        String id = scanner.nextLine();
        System.out.println("Insert student's name");
        String name = scanner.nextLine();
        System.out.println("Insert student's date of birth");
        String dob = scanner.nextLine();
        System.out.println("Insert student's gender");
        String gender = scanner.nextLine();
        System.out.println("Insert student's class ID");
        String classId = scanner.nextLine();
        System.out.println("Insert student's score");
        String score = scanner.nextLine();
        Person student = new Student(id, name, dob, gender, classId, score);
        repository.addNewStudent(student);
    }

    @Override
    public void addNewTeacher() {
        System.out.println("Insert teacher's ID");
        String id = scanner.nextLine();
        System.out.println("Insert teacher's name");
        String name = scanner.nextLine();
        System.out.println("Insert teacher's date of birth");
        String dob = scanner.nextLine();
        System.out.println("Insert teacher's gender");
        String gender = scanner.nextLine();
        System.out.println("Insert teacher's profession");
        String profession = scanner.nextLine();
        Person teacher = new Teacher(id, name, dob, gender, profession);
        repository.addNewStudent(teacher);
    }

    @Override
    public void showStudentList() {
        List<Person> studentList = repository.showStudentList();
        for (Person student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void showTeacherList() {
        List<Person> teacherList  = repository.showTeacherList();
        for (Person teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeStudent() throws Exception {
        System.out.println("Insert student's ID to remove");
        String id = scanner.nextLine();
        repository.removeStudent(id);
        System.out.println("Updated student list: " + repository.showStudentList());
    }

    @Override
    public void removeTeacher() throws Exception {
        System.out.println("Insert teacher's ID to remove");
        String id = scanner.nextLine();
        repository.removeStudent(id);
        System.out.println("Updated teacher list: " + repository.showTeacherList());
    }
}
