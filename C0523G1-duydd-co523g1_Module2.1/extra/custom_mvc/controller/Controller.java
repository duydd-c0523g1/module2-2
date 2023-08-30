package extra.custom_mvc.controller;

import extra.custom_mvc.model.Product;
import extra.custom_mvc.service.IService;
import extra.custom_mvc.service.ServiceImpl;

import java.util.List;

public class Controller {
    private IService service = new ServiceImpl();
    public List<Product> display() {
        return service.display();
    }
    public void add(Product product) {
        service.add(product);
    }
    public void delete(int id) {
        service.delete(id);
    }
}
