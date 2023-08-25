package service.people;

import model.people.Customer;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    @Override
    public void addNew(Customer customer) {

    }

    @Override
    public List<Customer> display() {
        return null;
    }

    @Override
    public boolean editCustomer(String id) {
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
}
