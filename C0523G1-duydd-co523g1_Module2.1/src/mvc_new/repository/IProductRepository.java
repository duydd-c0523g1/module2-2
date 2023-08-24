package src.mvc_new.repository;

import src.mvc_new.model.Product;

import java.util.List;

public interface IProductRepository {
    void addNewProduct(Product product);
    List<Product> displayProductList();
    List<Product> searchProductByName(String name);
    Product searchProductById(int id);
    boolean deleteProduct(int id);
}
