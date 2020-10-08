package dao;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private BaseDAO baseDAO=new BaseDAO();
    private final String SELECT_ALL_CATEGORY="select categoryID,typeOfProduct from productdb.category;";
    private final String SELECT_CATEGORY_BY_ID="select categoryID,typeOfProduct from productdb.category where categoryID =?; ";
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
    public List<Category> findAllCategory() {
        List<Category>categoryList=new ArrayList<>();
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CATEGORY)) {
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String categoryID = rs.getString("categoryID");
                String typeOfProduct = rs.getString("typeOfProduct");
                categoryList.add(new Category(categoryID,typeOfProduct));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category SelectByID(String id) {
        Category category=null;
        try (PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_CATEGORY_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            category=new Category(resultSet.getString("categoryID"),resultSet.getString("typeOfProduct"));
            category.setCategoryID(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return category;
    }
}
