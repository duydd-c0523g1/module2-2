package repository.people;

import model.people.Customer;
import model.people.Employee;

import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

    @Override
    public List<Employee> displayList() {
        return null;
    }

    @Override
    public void addNew(Employee employee) {

    }

    @Override
    public boolean editEmployee(String id) {
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
