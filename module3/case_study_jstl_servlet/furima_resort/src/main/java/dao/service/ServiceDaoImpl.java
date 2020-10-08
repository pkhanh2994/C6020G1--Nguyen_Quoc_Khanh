package dao.service;

import dao.baseDao.BaseDAO;
import model.customer.Customer;
import model.service.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl implements ServiceDao {
    private BaseDAO baseDAO = new BaseDAO();

    private static final String INSERT_SERVICE_SQL = "insert into service (service_id, service_name, service_area, service_cost,service_max_people,standard_room, " +
            "description_other_convenience,pool_area, number_of_floors," +
            "rent_type_id,service_type_id)" +
            "values(?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_SERVICE = "select service_id,service_name,service_area," +
            "service_cost,service_max_people,standard_room,description_other_convenience,pool_area,number_of_floors,rent_type_id,service_type_id from service;";


    private static final String FIND_SERVICE_BY_ID = "select service_id,service_name,service_area," +
            "service_cost,service_max_people,standard_room,description_other_convenience,pool_area," +
            "number_of_floors,rent_type_id,service_type_id from service where service_id=?;";

    //thiet lap message thong bao loi
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
    public String insertService(Service service) throws SQLException {
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_SERVICE_SQL)) {
            preparedStatement.setString(1, service.getService_id());
            preparedStatement.setString(2, service.getService_name());
            preparedStatement.setString(3, service.getService_area());
            preparedStatement.setString(4, service.getService_cost());
            preparedStatement.setString(5, service.getService_max_people());
            preparedStatement.setString(6, service.getStandard_room());
            preparedStatement.setString(7, service.getDescription_other_convenience());
            preparedStatement.setString(8, service.getPool_area());
            preparedStatement.setString(9, service.getNumber_of_floors());
            preparedStatement.setString(10, service.getRent_type_id());
            preparedStatement.setString(11, service.getService_type_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return "created new service";
    }

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_SERVICE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String serviceId = rs.getString("service_id");
                String serviceName = rs.getString("service_name");
                String serviceArea = rs.getString("service_area");
                String serviceCost = rs.getString("service_cost");
                String maxPeople = rs.getString("service_max_people");
                String standardRoom = rs.getString("standard_room");
                String descriptionOtherConvenience = rs.getString("description_other_convenience");
                String poolArea = rs.getString("pool_area");
                String numberOfFloors = rs.getString("number_of_floors");
                String rentTypeId = rs.getString("rent_type_id");
                String typeId = rs.getString("service_type_id");

                serviceList.add(new Service(serviceId, serviceName, serviceArea, serviceCost,
                        maxPeople, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, rentTypeId, typeId));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public Service findServiceByID(String id) {
        Service service = null;
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(FIND_SERVICE_BY_ID)) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            service = new Service(resultSet.getString("service_id"),
                    resultSet.getString("service_name"), resultSet.getString("service_area"),
                    resultSet.getString("service_cost"), resultSet.getString("service_max_people"),
                    resultSet.getString("standard_room"),
                    resultSet.getString("description_other_convenience"), resultSet.getString("pool_area"),
                    resultSet.getString("number_of_floors"), resultSet.getString("rent_type_id"),
                    resultSet.getString("service_type_id"));
            service.setService_id(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public String deleteServiceById(String id) {
        try {
            PreparedStatement preparedStatement
                    = this.baseDAO.getConnection().prepareStatement("delete from service " +
                    "where service_id = ?");
            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Deleted";
    }
}
