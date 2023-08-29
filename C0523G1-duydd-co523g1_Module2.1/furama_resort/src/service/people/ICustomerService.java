package service.people;

import model.people.Customer;
import service.IService;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    boolean editCustomer(String id, Customer customer);

    boolean deleteCustomer(String id);

    List<Customer> searchCustomerByName(String name);

    boolean idExist(String id);
}
