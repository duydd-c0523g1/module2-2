package extra.custom_mvc.repository;

import extra.custom_mvc.model.Product;

import java.util.List;

public interface IRepo {
    List<Product> display();
    void add(Product product);
    void delete(int id);
}
