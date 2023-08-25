package controller;

import model.people.Customer;
import service.people.CustomerServiceImpl;
import service.people.ICustomerService;

import java.util.List;

public class CustomerController {
    private final ICustomerService customerService = new CustomerServiceImpl();

    public List<Customer> displayCustomerList() {
        return customerService.display();
    }
    public void addNewCustomer(Customer customer) {
        customerService.addNew(customer);
    }
    public boolean editCustomer(String id, Customer customer) {
        return customerService.editCustomer(id, customer);
    }
    public boolean deleteCustomer(String id) {
        return customerService.deleteCustomer(id);
    }
    public List<Customer> searchCustomerByName(String name) {
        return customerService.searchCustomerByName(name);
    }
}
