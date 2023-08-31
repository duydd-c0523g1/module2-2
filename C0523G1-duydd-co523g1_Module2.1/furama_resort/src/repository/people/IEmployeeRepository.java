package repository.people;

import model.people.Employee;
import repository.IRepository;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee> {
    boolean editEmployee(String id, Employee employee);

    boolean deleteEmployee(String id);

    List<Employee> searchEmployeeByName(String name);

}