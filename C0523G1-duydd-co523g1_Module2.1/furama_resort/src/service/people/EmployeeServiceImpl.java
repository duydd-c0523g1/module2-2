package service.people;

import model.people.Employee;
import repository.people.EmployeeRepositoryImpl;
import repository.people.IEmployeeRepository;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public void addNew(Employee employee) {

    }

    @Override
    public List<Employee> display() {
        return null;
    }

    @Override
    public boolean editEmployee(String id, Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) {
        return false;
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return null;
    }
}
