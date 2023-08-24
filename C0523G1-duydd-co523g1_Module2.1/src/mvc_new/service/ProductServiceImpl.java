package src.mvc_new.service;

import src.mvc_new.model.Product;
import src.mvc_new.repository.IProductRepository;
import src.mvc_new.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private final IProductRepository repository = new ProductRepositoryImpl();
    @Override
    public void addNewProduct(Product product) {
        repository.addNewProduct(product);
    }

    @Override
    public List<Product> displayProductList() {
        return repository.displayProductList();
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return repository.searchProductByName(name);
    }

    @Override
    public Product searchProductById(int id) {
        return repository.searchProductById(id);
    }
}
