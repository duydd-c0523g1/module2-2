package src.mvc_new.repository;

import src.mvc_new.model.Product;
import src.mvc_new.utils.Stream;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static final String FILE_PATH = "D:\\CodeGym\\Git\\C0523G1-duydd-co523g1_Module2.1\\src\\mvc_new\\data\\product.csv";
    private static final String COMMA = ",";
    @Override
    public void addNewProduct(Product product) {
        List<Product> productList = displayProductList();
        if (!productList.isEmpty()) {
            product.setId(productList.get(productList.size() - 1).getId() + 1);
        } else {
            product.setId(1);
        }
        productList.add(product);
        List<String> strings = convertToString(productList);
        Stream.write(FILE_PATH, strings);
    }

    @Override
    public List<Product> displayProductList() {
        List<String> strings = Stream.read(FILE_PATH);
        List<Product> productList = new ArrayList<>();
        String[] arr = null;
        for (String str : strings) {
            arr = str.split(",");
            productList.add(new Product(Integer.parseInt(arr[0]), arr[1], Float.parseFloat(arr[2]), arr[3]));
        }
        return productList;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList = displayProductList();
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Product searchProductById(int id) {
        List<Product> productList = displayProductList();
        Product result = null;
        for (Product product : productList) {
            if (product.getId() == id) {
                result = product;
            }
        }
        return result;
    }

    @Override
    public boolean deleteProduct(int id) {
        List<Product> productList = displayProductList();
        for (Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product);
                List<String> strings = convertToString(productList);
                Stream.write(FILE_PATH, strings);
                return true;
            }
        }
        return false;
    }

    private List<String> convertToString(List<Product> productList) {
        List<String> convertedList = new ArrayList<>();
        for (Product product : productList) {
            convertedList.add(product.getId() + COMMA + product.getName() + COMMA
                    + product.getPrice() + COMMA + product.getBrand());
        }
        return convertedList;
    }
}
