package repository.people;

import model.people.Customer;
import repository.IRepository;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer> {
    boolean editCustomer(String id, Customer customer);

    boolean deleteCustomer(String id);

    List<Customer> searchCustomerByName(String name);

}
