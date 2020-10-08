package bo;

import model.Product;

import java.util.List;

public interface ProductBo {
    List<Product>findAllProduct();
    String insertProduct(Product product);
    String updateProduct(Product product);
    String deleteProductByID(String id);
    List<Product> selectProductByName(String name);
    Product selectProductByID(String id);

}
