package repository.people;

import model.people.Customer;
import utils.Stream;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private final String COMMA = ",";
    private final String FILE_PATH = "D:\\CodeGym\\Git\\C0523G1-duydd-co523g1_Module2.1\\furama_resort\\src\\data\\customer.csv";

    @Override
    public List<Customer> displayList() {
        List<String> strings = Stream.read(FILE_PATH);
        List<Customer> customers = new ArrayList<>();
        String[] arr = null;
        for (String s : strings) {
            arr = s.split(",");
            customers.add(new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]));
        }
        return customers;
    }

    @Override
    public void addNew(Customer customer) {
        List<Customer> customers = this.displayList();
        customers.add(customer);
        List<String> strings = convertToString(customers);
        Stream.write(FILE_PATH, strings);
    }

    @Override
    public boolean editCustomer(String id, Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return null;
    }

    private List<String> convertToString(List<Customer> customers) {
        List<String> strings = new ArrayList<>();
        for (Customer c : customers) {
            strings.add(c.getId() + COMMA + c.getName() + COMMA + c.getDob() + COMMA + c.getIdentNumber() + COMMA
                    + c.getPhoneNumber() + COMMA + c.getEmail() + COMMA + c.getType() + COMMA + c.getAddress());
        }
        return strings;
    }
}
