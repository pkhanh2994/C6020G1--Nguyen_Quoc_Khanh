package dao;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAOImpl implements ProductDAO {

   private static Map<Integer,Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Tom", 3000, "expensive", "USA"));
        productMap.put(2, new Product(2, "Temp", 3000, "cheap", "China"));
        productMap.put(3, new Product(3, "Mem", 3000, "cheap", "Viet Nam"));
        productMap.put(4, new Product(4, "Mom", 3000, "cheap", "Ha Noi"));
        productMap.put(5, new Product(5, "Mum", 3000, "cheap", "Quang Nam"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
    productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);

    }

    @Override
    public void remove(int id) {
        productMap.remove(id);

    }
}
