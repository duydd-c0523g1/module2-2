package src.mvc_new.service;

import src.mvc_new.controller.ProductController;
import src.mvc_new.model.Product;

import java.util.List;

public interface IProductService {
    void addNewProduct(Product product);
    List<Product> displayProductList();
    List<Product> searchProductByName(String name);
    Product searchProductById(int id);
    boolean deleteProduct(int id);
}
