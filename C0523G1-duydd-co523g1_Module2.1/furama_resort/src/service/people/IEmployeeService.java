package service.people;

import model.people.Employee;
import service.IService;

import java.util.List;

public interface IEmployeeService extends IService<Employee> {
    boolean editEmployee(String id, Employee employee);

    boolean deleteEmployee(String id);

    List<Employee> searchEmployeeByName(String name);

    boolean idExist(String id);
}
