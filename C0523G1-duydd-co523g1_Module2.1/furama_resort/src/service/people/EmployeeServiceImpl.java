package service.people;

import model.people.Employee;
import repository.people.EmployeeRepositoryImpl;
import repository.people.IEmployeeRepository;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public void addNew(Employee employee) {
        employeeRepository.addNew(employee);
    }

    @Override
    public List<Employee> display() {
        return employeeRepository.displayList();
    }

    @Override
    public boolean editEmployee(String id, Employee employee) {
        return employeeRepository.editEmployee(id, employee);
    }

    @Override
    public boolean deleteEmployee(String id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return employeeRepository.searchEmployeeByName(name);
    }

    @Override
    public boolean idExist(String id) {
        return employeeRepository.idExist(id);
    }
}
