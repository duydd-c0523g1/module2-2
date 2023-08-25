package controller;

import model.people.Employee;
import service.people.EmployeeServiceImpl;
import service.people.IEmployeeService;

import java.util.List;

public class EmployeeController {
    private final IEmployeeService employeeService = new EmployeeServiceImpl();
    public void addNewEmployee(Employee employee) {
        employeeService.addNew(employee);
    }
    public List<Employee> displayEmployeeList() {
        return employeeService.display();
    }
    public boolean editEmployee(String id, Employee employee) {
        return employeeService.editEmployee(id, employee);
    }
    public boolean deleteEmployee(String id) {
        return employeeService.deleteEmployee(id);
    }
    public List<Employee> searchEmployeeByName(String name) {
        return employeeService.searchEmployeeByName(name);
    }
}
