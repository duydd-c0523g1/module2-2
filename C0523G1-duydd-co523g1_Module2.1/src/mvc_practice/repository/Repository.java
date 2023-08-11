package src.mvc_practice.repository;

import src.mvc_practice.model.Person;
import src.mvc_practice.model.Student;
import src.mvc_practice.model.Teacher;
import src.mvc_practice.utils.Stream;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    public final String FILE_PATH_STUDENT =
            "D:\\CodeGym\\Git\\C0523G1-duydd-co523g1_Module2.1\\src\\mvc_practice\\data\\student.csv";
    public final String FILE_PATH_TEACHER =
            "D:\\CodeGym\\Git\\C0523G1-duydd-co523g1_Module2.1\\src\\mvc_practice\\data\\teacher.csv";

    @Override
    public void addNewStudent(Person student) {
        List<Person> students = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        students.add(student);
        for (int i = 0; i < students.size(); i++) {
            stringList.add(students.get(i).getInfoToCsv());
        }
        Stream.write(FILE_PATH_STUDENT, stringList, true);
    }

    @Override
    public void addNewTeacher(Person teacher) {
        List<Person> teachers = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        teachers.add(teacher);
        for (int i = 0; i < teachers.size(); i++) {
            stringList.add(teachers.get(i).getInfoToCsv());
        }
        Stream.write(FILE_PATH_TEACHER, stringList, true);
    }

    @Override
    public List<Person> showStudentList() {
        List<Person> studentList = new ArrayList<>();
        List<String> stringList = Stream.read(FILE_PATH_STUDENT);
        String[] array = null;
        for (String s : stringList) {
            array = s.split(",");
            Person student = new Student(array[0], array[1], array[2], array[3], array[4], array[5]);
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public List<Person> showTeacherList() {
        List<Person> teacherList = new ArrayList<>();
        List<String> stringList = Stream.read(FILE_PATH_TEACHER);
        String[] array = null;
        for (String s : stringList) {
            array = s.split(",");
            Person teacher = new Teacher(array[0], array[1], array[2], array[3], array[4]);
            teacherList.add(teacher);
        }
        return teacherList;
    }


    @Override
    public void removeStudent(String id) throws Exception {
        boolean idExist = false;
        List<Person> studentList = this.showStudentList();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentList.remove(studentList.get(i));
                idExist = true;
                break;
            }
        }
        if (!idExist) {
            throw new Exception("Person does not exist!");
        }
        for (Person student : studentList) {
            stringList.add(student.getInfoToCsv());
        }
        Stream.write(FILE_PATH_STUDENT, stringList, false);
    }


    @Override
    public void removeTeacher(String id) throws Exception {
        boolean idExist = false;
        List<Person> teacherList = this.showTeacherList();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId().equals(id)) {
                teacherList.remove(teacherList.get(i));
                idExist = true;
                break;
            }
        }
        if (!idExist) {
            throw new Exception("Person does not exist!");
        }
        for (Person teacher : teacherList) {
            stringList.add(teacher.getInfoToCsv());
        }
        Stream.write(FILE_PATH_TEACHER, stringList, false);
    }
}
