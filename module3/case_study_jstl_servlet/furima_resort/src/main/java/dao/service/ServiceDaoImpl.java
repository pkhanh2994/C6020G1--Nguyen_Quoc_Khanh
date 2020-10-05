package dao.service;

import dao.baseDao.BaseDAO;
import model.service.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceDaoImpl implements ServiceDao {
    private BaseDAO baseDAO = new BaseDAO();

    private static final String INSERT_SERVICE_SQL = "insert into service (service_id, service_name, service_area, service_cost,service_max_people,standard_room, " +
            "description_other_convenience,pool_area, number_of_floors," +
            "rent_type_id,service_type_id)" +
            "values(?,?,?,?,?,?,?,?,?,?,?);";


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
        try ( PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_SERVICE_SQL)) {
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
}
