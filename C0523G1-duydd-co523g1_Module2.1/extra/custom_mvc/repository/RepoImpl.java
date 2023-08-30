package extra.custom_mvc.repository;

import extra.bai13.repository.SpendingRepositoryImpl;
import extra.custom_mvc.model.Product;
import extra.custom_mvc.utils.Stream;

import java.util.ArrayList;
import java.util.List;

public class RepoImpl implements IRepo {
    private final String FILE_PATH = "D:\\CodeGym\\Git\\C0523G1-duydd-co523g1_Module2.1\\extra\\custom_mvc\\data\\product.csv";
    private final String COMMA = ",";
    @Override
    public List<Product> display() {
        List<String> strings = Stream.read(FILE_PATH);
        List<Product> products = new ArrayList<>();
        String[] arr = null;
        for (String s : strings) {
            arr = s.split(",");
            products.add(new Product(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]));
        }
        return products;
    }

    @Override
    public void add(Product product) {
        List<Product> products = this.display();
        products.add(product);
        List<String> strings = convertToString(products);
        Stream.write(FILE_PATH, strings);
    }

    @Override
    public void delete(int id) {
        List<Product> products = this.display();
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
            }
        }
        List<String> strings = convertToString(products);
        Stream.write(FILE_PATH, strings);
    }
    private List<String> convertToString(List<Product> products) {
        List<String> strings = new ArrayList<>();
        for (Product product : products) {
            strings.add(product.getId() + COMMA + product.getName() + COMMA
            + product.getManuDate() + COMMA + product.getExpDate());
        }
        return strings;
    }
}
