package bo;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO=new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        return this.productDAO.findAll();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }
}
