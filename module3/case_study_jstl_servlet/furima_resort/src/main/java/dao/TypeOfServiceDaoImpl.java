package dao;

import model.TypeOfRent;
import model.TypeOfService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfServiceDaoImpl implements TypeOfServiceDao{
    private BaseDAO baseDAO=new BaseDAO();
    @Override
    public List<TypeOfService> findAllTypeOfService() {
        List<TypeOfService> typeOfServices = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().
                            prepareStatement("SELECT service_type_id,service_type_name FROM furama.service_type;");

            ResultSet resultSet = preparedStatement.executeQuery();

            TypeOfService typeOfService;
            while (resultSet.next()) {
                String id = resultSet.getString("service_type_id");
                String name = resultSet.getString("service_type_name");

                typeOfService = new TypeOfService(id, name);
                typeOfServices.add(typeOfService);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeOfServices;

    }
}
