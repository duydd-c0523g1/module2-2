package controller;

import model.people.Employee;
import service.people.EmployeeServiceImpl;
import service.people.IEmployeeService;

import java.util.List;

public class EmployeeController {
    private final IEmployeeService employeeService = new EmployeeServiceImpl();
    void addNewEmployee(Employee employee) {
        employeeService.addNew(employee);
    }
    List<Employee> displayEmployeeList() {
        return employeeService.display();
    }
    boolean editEmployee(String id) {
        return employeeService.editEmployee(id);
    }
    boolean deleteEmployee(String id) {
        return employeeService.deleteEmployee(id);
    }
    List<Employee> searchEmployeeByName(String name) {
        return employeeService.searchEmployeeByName(name);
    }
}
