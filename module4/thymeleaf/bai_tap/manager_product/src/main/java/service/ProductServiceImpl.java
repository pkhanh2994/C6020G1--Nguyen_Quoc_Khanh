package service;


import model.Product;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductServiceImpl implements ProductService {
  private static Map<Integer, Product> productMap;
  static   {
      productMap=new HashMap<>();
       productMap.put(1,new Product(1,"samsung","1000","5"));
        productMap.put(2,new Product(2,"nokia","200","6"));
        productMap.put(3,new Product(3,"iphone","400","5"));
        productMap.put(4,new Product(4,"motorola","500","6"));
        productMap.put(5,new Product(5,"redmi","300","2"));
        productMap.put(6,new Product(6,"vivo","100","5"));
    }

    @Override
    public List<Product> findAllProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findProductById(int id) {
        return productMap.get(id);
    }

    @Override
    public Product deleteById(int id) {
        return productMap.remove(id);
    }

    @Override
    public void update(int id,Product product) {
      productMap.put(id,product);

    }

    @Override
    public void save(Product product) {
      productMap.put(product.getProductID(),product);

    }
}
