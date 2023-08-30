package extra.custom_mvc.service;

import extra.custom_mvc.model.Product;

import java.util.List;

public interface IService {
    List<Product> display();
    void add(Product product);
    void delete(int id);
}
