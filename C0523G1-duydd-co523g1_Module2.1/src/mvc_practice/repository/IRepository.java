package src.mvc_practice.repository;

import src.mvc_practice.model.Person;

import java.util.List;

public interface IRepository {
    void addNewStudent(Person student);
    void addNewTeacher(Person teacher);
    List<Person> showStudentList();
    List<Person> showTeacherList();
    void removeStudent(String id) throws Exception;
    void removeTeacher(String id) throws Exception;
}
