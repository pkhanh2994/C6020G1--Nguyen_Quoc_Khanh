package bo;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;

import java.util.List;

public class ProductBoImpl implements ProductBo {
    ProductDao productDao=new ProductDaoImpl();
    @Override
    public List<Product> findAllProduct() {
        return this.productDao.findAllProduct();
    }

    @Override
    public String insertProduct(Product product) {
        String message=this.productDao.insertProduct(product);
        return message ;
    }

    @Override
    public String updateProduct(Product product) {
        String message=this.productDao.updateProduct(product);
        return message;
    }

    @Override
    public String deleteProductByID(String id) {
        String message=this.productDao.deleteProductByID(id);
        return message;
    }

    @Override
    public List<Product> selectProductByName(String name) {
        return null;
    }

    @Override
    public Product selectProductByID(String id) {
        return this.productDao.selectProductByID(id);
    }
}
