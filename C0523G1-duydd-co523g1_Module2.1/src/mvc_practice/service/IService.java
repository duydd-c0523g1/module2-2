package src.mvc_practice.service;

public interface IService {
    void addNewStudent();
    void addNewTeacher();
    void showStudentList();
    void showTeacherList();
    void removeStudent() throws Exception;
    void removeTeacher() throws Exception;
}
