package dao.employee;

import dao.baseDao.BaseDAO;
import model.employee.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {
    private BaseDAO baseDAO = new BaseDAO();

    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_id, employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone," +
            " employee_email,employee_address, position_id,education_degree_id,division_id,user_name)" +
            "values(?,?,?,?,?,?,?,?,?,?,?,?);";


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
    public String insertEmployee(Employee employee) throws SQLException {

        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getEmployee_id());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setString(3, employee.getEmployee_birthday());
            preparedStatement.setString(4, employee.getEmployee_id_card());
            preparedStatement.setString(5, employee.getEmployee_salary());
            preparedStatement.setString(6, employee.getEmployee_phone());
            preparedStatement.setString(7, employee.getEmployee_email());
            preparedStatement.setString(8, employee.getEmployee_address());
            preparedStatement.setString(9, employee.getPosition_id());
            preparedStatement.setString(10, employee.getEducation_degree_id());
            preparedStatement.setString(11, employee.getDivision_id());
            preparedStatement.setString(12, employee.getUser_name());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return "created new customer";
    }
}
