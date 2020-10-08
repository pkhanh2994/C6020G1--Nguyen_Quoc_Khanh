package dao;

import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
private BaseDAO baseDAO=new BaseDAO();
private final String SELECT_ALL_PRODUCT="select productID,productName,price,quantity,color,categoryID from productdb.product;";
private final String INSERT_INTO_PRODUCT="insert into product(productName,price,quantity,color,categoryID) \n" +
        "values(?,?,?,?,?);";
private final String SELECT_PRODUCT_BY_ID="select productID,productName,price,quantity,color,categoryID from productdb.product where productID=?";
private final String UPDATE_PRODUCT="update product set productName=?, price=?," +
        "quantity=?,color=?,categoryID=? where productID=?;";
private final String DELETE_BY_ID="delete from product where productID=?";
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product>productList=new ArrayList<>();
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_ALL_PRODUCT)){
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String color = rs.getString("color");
                String categoryID = rs.getString("categoryID");
                String productName = rs.getString("productName");
                productList.add(new Product(productID,productName,price,quantity,color,categoryID));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public String insertProduct(Product product) {
        try (PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(INSERT_INTO_PRODUCT)){
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategoryID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "created new product";
    }

    @Override
    public String updateProduct(Product product) {
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(UPDATE_PRODUCT)){
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setString(2,product.getPrice());
            preparedStatement.setString(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getCategoryID());
            preparedStatement.setString(6,product.getProductID());

            try {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "updated";
    }

    @Override
    public String deleteProductByID(String id) {
        try {
            PreparedStatement preparedStatement
                    = this.baseDAO.getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Deleted";
    }

    @Override
    public List<Product> selectProductByName(String name) {
        return null;
    }

    @Override
    public Product selectProductByID(String id) {
        Product product = null;
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_PRODUCT_BY_ID)) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            product = new Product(resultSet.getString("productID"),
                    resultSet.getString("productName"), resultSet.getString("price"),
                    resultSet.getString("quantity"), resultSet.getString("color"),
                    resultSet.getString("categoryID"));
            product.setProductID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

}
