package service;



import model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService {
    List<Product> findAllProduct();
    Product findProductById(int id);
    Product deleteById(int id);
    void update(int id,Product product);
    void save(Product product);

}
