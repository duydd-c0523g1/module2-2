package controller;

import model.people.Customer;
import service.people.CustomerServiceImpl;
import service.people.ICustomerService;

import java.util.List;

public class CustomerController {
    private final ICustomerService customerService = new CustomerServiceImpl();

    List<Customer> displayCustomerList() {
        return customerService.display();
    }
    void addNewCustomer(Customer customer) {
        customerService.addNew(customer);
    }
    boolean editCustomer(String id) {
        return customerService.editCustomer(id);
    }
    boolean deleteCustomer(String id) {
        return customerService.deleteCustomer(id);
    }
    List<Customer> searchCustomerByName(String name) {
        return customerService.searchCustomerByName(name);
    }
}
