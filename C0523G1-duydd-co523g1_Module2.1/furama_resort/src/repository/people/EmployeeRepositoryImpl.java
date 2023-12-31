package repository.people;

import model.people.Employee;
import utils.Stream;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private final String COMMA = ",";
    private final String FILE_PATH = "D:\\CodeGym\\Git\\C0523G1-duydd-co523g1_Module2.1\\furama_resort\\src\\data\\employee.csv";

    @Override
    public List<Employee> displayList() {
        List<String> strings = Stream.read(FILE_PATH);
        List<Employee> employees = new ArrayList<>();
        String[] arr;
        for (String s : strings) {
            arr = s.split(",");
            employees.add(new Employee(arr[0], arr[1], arr[2], arr[3], arr[4]
                    , arr[5], arr[6], arr[7], arr[8], Double.parseDouble(arr[9])));
        }
        return employees;
    }

    @Override
    public void addNew(Employee employee) {
        List<Employee> employees = this.displayList();
        employees.add(employee);
        List<String> strings = convertToString(employees);
        Stream.write(FILE_PATH, strings);
    }

    @Override
    public boolean editEmployee(String id, Employee employee) {
        List<Employee> employees = this.displayList();
        for (Employee c : employees) {
            if (c.getId().equals(id)) {
                int index = employees.indexOf(c);
                employees.set(index,employee);
                List<String> strings = convertToString(employees);
                Stream.write(FILE_PATH, strings);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) {
        List<Employee> employees = this.displayList();
        for (Employee c : employees) {
            if (c.getId().equals(id)) {
                employees.remove(c);
                List<String> strings = convertToString(employees);
                Stream.write(FILE_PATH, strings);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> employees = this.displayList();
        List<Employee> result = new ArrayList<>();
        for (Employee c : employees) {
            if (c.getName().contains(name)
                    || c.getName().toLowerCase().contains(name)
                    || c.getName().toUpperCase().contains(name)) {
                result.add(c);
            }
        }
        return result;
    }

    private List<String> convertToString(List<Employee> employees) {
        List<String> strings = new ArrayList<>();
        for (Employee c : employees) {
            strings.add(c.getId() + COMMA + c.getName() + COMMA + c.getDob()
                    + COMMA + c.getGender() + COMMA + c.getIdentNumber()
                    + COMMA + c.getPhoneNumber() + COMMA + c.getEmail()
                    + COMMA + c.getEduLevel() + COMMA + c.getJobPosition() + COMMA + c.getSalary());
        }
        return strings;
    }

    @Override
    public boolean idExist(String id) {
        List<Employee> employees = this.displayList();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
