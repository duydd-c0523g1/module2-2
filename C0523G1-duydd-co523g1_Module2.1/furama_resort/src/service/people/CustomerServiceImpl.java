package service.people;

import model.people.Customer;
import repository.people.CustomerRepositoryImpl;
import repository.people.ICustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void addNew(Customer customer) {
        customerRepository.addNew(customer);
    }

    @Override
    public List<Customer> display() {
        return customerRepository.displayList();
    }

    @Override
    public boolean editCustomer(String id, Customer customer) {
        return customerRepository.editCustomer(id, customer);
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return customerRepository.searchCustomerByName(name);
    }

    @Override
    public boolean idExist(String id) {
        return customerRepository.idExist(id);
    }
}
