package src.mvc_new.controller;

import src.mvc_new.model.Product;
import src.mvc_new.service.IProductService;
import src.mvc_new.service.ProductServiceImpl;

import java.util.List;

public class ProductController {
    private final IProductService service = new ProductServiceImpl();

    public void addNewProduct(Product product) {
        service.addNewProduct(product);
    }

    public List<Product> displayProductList() {
        return service.displayProductList();
    }

    public Product searchById(int id) {
        return service.searchProductById(id);
    }

    public List<Product> searchByName(String name) {
        return service.searchProductByName(name);
    }
    public boolean deleteProduct(int id) {
        return service.deleteProduct(id);
    }
}
