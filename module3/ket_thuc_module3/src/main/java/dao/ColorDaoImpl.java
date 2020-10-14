package dao;

import model.Category;
import model.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDaoImpl implements ColorDao {
    private BaseDAO baseDAO=new BaseDAO();
    private final String SELECT_ALL_COLOR="select colorID,colorName from productdb.color;";
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
    public List<Color> findAllColor() {
        List<Color> colorList = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_COLOR)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String colorID = rs.getString("colorID");
                String colorName = rs.getString("colorName");
                colorList.add(new Color(colorID, colorName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colorList;
    }
}
