package bo;

import common.Validate;
import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBoImpl implements ProductBo {
    ProductDao productDao=new ProductDaoImpl();
    @Override
    public List<Product> findAllProduct() {
        return this.productDao.findAllProduct();
    }

    @Override
    public String insertProduct(Product product) {
        String message="";
        if(!Validate.isValidName(product.getProductName())){
            message="The form's name is wrong.Please enter again";
        }else if(!Validate.isValidNumber(product.getQuantity())){
            message="Please enter digits";
        }else if(!Validate.isPrice(product.getPrice())) {
            message="The price must be greater 10000000";

        }else if(!Validate.isValidName(product.getDescription())) {
            message="Please enter product description";

        }else {
            message = this.productDao.insertProduct(product);
        }
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
      List<Product>productList=new ArrayList<>();
      productList=this.productDao.selectProductByName(name);
      return productList;
    }

    @Override
    public List<Product> selectProductByPrice(String price) {
        List<Product>productList=new ArrayList<>();
        productList=this.productDao.selectProductByPrice(price);
        return productList;
    }

    @Override
    public Product selectProductByID(String id) {
        return this.productDao.selectProductByID(id);
    }

    @Override
    public List<Product> selectProductByNameAndPrice(String price, String name) {
        return this.productDao.selectProductByNameAndPrice(price,name);
    }
}
