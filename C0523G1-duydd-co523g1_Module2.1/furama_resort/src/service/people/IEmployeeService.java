package service.people;

import model.people.Employee;
import service.IService;

import java.util.List;

public interface IEmployeeService extends IService<Employee> {
    boolean editEmployee(String id);
    boolean deleteEmployee(String id);
    List<Employee> searchEmployeeByName(String name);
}
