package dao;

import model.TypeOfCustomer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfCustomerDAOImpl implements TypeOfCustomerDAO {
    private BaseDAO baseDAO = new BaseDAO();


    @Override
    public List<TypeOfCustomer> findAllTypeOfCustomer() {
        List<TypeOfCustomer> typeOfCustomers = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().
                            prepareStatement("SELECT customer_type_id,customer_type_name FROM furama.customer_type;");

            ResultSet resultSet = preparedStatement.executeQuery();

            TypeOfCustomer typeOfCustomer;
            while (resultSet.next()) {
                Integer id = Integer.valueOf(resultSet.getString("customer_type_id"));
                String name = resultSet.getString("customer_type_name");

                typeOfCustomer = new TypeOfCustomer(id, name);
                typeOfCustomers.add(typeOfCustomer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeOfCustomers;
    }

}
