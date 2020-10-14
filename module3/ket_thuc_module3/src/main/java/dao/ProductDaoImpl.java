package dao;

import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private BaseDAO baseDAO = new BaseDAO();
    private final String SELECT_ALL_PRODUCT = "select productID,productName,price,quantity,categoryID,description,colorID from productdb.product;";
    private final String INSERT_INTO_PRODUCT = "insert into product(productName,price,quantity,categoryID,description,colorID) \n" +
            "values(?,?,?,?,?,?);";
    private final String SELECT_PRODUCT_BY_ID = "select productID,productName,price,quantity,categoryID,description,colorID from productdb.product where productID=?";
    private final String UPDATE_PRODUCT = "update product set productName=?, price=?," +
            "quantity=?,color=?,categoryID=?,description=?,colorID=? where productID=?;";
    private final String DELETE_BY_ID = "delete from product where productID=?";

    private final String SELECT_PRODUCT_BY_NAME = "select productID,productName,price,quantity,categoryID,`description`,colorID from product where productName like ? escape '!';";
    private final String SELECT_PRODUCT_BY_PRICE = "select productID,productName,price,quantity,categoryID,description,colorID from productdb.product where price=?";

    private final String SELECT_BY_PRICE_BY_NAME_PRICE= "select productID,productName,price,quantity,categoryID,description,colorID from productdb.product where price=? and productName=?";

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
        List<Product> productList = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_PRODUCT)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String categoryID = rs.getString("categoryID");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                String colorID = rs.getString("colorID");
                productList.add(new Product(productID, productName, price, quantity, categoryID, description, colorID));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public String insertProduct(Product product) {
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_INTO_PRODUCT)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getCategoryID());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getColorID());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "created new product";
    }

    @Override
    public String updateProduct(Product product) {
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getCategoryID());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getColorID());
            preparedStatement.setString(7, product.getProductID());

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
        List<Product> productList = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_PRODUCT_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String categoryID = rs.getString("categoryID");
                String description = rs.getString("description");
                String colorID = rs.getString("colorID");

                productList.add(new Product(productID, productName, price, quantity, categoryID, description, colorID));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;

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
                    resultSet.getString("quantity"), resultSet.getString("categoryID"), resultSet.getString("description"), resultSet.getString("colorID"));
            product.setProductID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectProductByPrice(String price) {
        List<Product> productList = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_PRODUCT_BY_PRICE)) {
            preparedStatement.setString(1, price);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String quantity = rs.getString("quantity");
                String categoryID = rs.getString("categoryID");
                String description = rs.getString("description");
                String colorID = rs.getString("colorID");

                productList.add(new Product(productID, productName, price, quantity, categoryID, description, colorID));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> selectProductByNameAndPrice(String price, String name) {
        List<Product> productList = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_BY_PRICE_BY_NAME_PRICE)) {
            preparedStatement.setString(1, price);
            preparedStatement.setString(2, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String quantity = rs.getString("quantity");
                String categoryID = rs.getString("categoryID");
                String description = rs.getString("description");
                String colorID = rs.getString("colorID");
                productList.add(new Product(productID, productName, price, quantity, categoryID, description, colorID));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
