package dao;

import model.TypeOfCustomer;
import model.TypeOfRent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TypeOfRentDaoImpl implements TypeOfRentDao {

    private BaseDAO baseDAO=new BaseDAO();
    @Override
    public List<TypeOfRent> findAllTypeOfRent() {
        List<TypeOfRent> typeOfRents = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().
                            prepareStatement("SELECT rent_type_id,rent_type_name FROM furama.rent_type;");

            ResultSet resultSet = preparedStatement.executeQuery();

           TypeOfRent typeOfRent;
            while (resultSet.next()) {
                String id = resultSet.getString("rent_type_id");
                String name = resultSet.getString("rent_type_name");

                typeOfRent = new TypeOfRent(id, name);
                typeOfRents.add(typeOfRent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeOfRents;
    }
}
