package extra.custom_mvc.service;

import extra.custom_mvc.model.Product;
import extra.custom_mvc.repository.IRepo;
import extra.custom_mvc.repository.RepoImpl;

import java.util.List;

public class ServiceImpl implements IService {
    private IRepo repo = new RepoImpl();

    @Override
    public List<Product> display() {
        return repo.display();
    }

    @Override
    public void add(Product product) {
        repo.add(product);
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }
}
