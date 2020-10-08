package dao.employee;

import dao.baseDao.BaseDAO;
import model.customer.Customer;
import model.employee.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private BaseDAO baseDAO = new BaseDAO();

    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_id, employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone," +
            " employee_email,employee_address, position_id,education_degree_id,division_id,user_name)" +
            "values(?,?,?,?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_ALL_EMPLOYEE="select employee_id,employee_name,employee_birthday," +
            "employee_id_card,employee_salary,employee_phone,employee_email,employee_address," +
            "position_id,education_degree_id,division_id,user_name from furama.employee;";

    private static final String SELECT_EMPLOYEE_BY_ID=" select employee_id,employee_name,employee_birthday," +
            "employee_id_card,employee_salary,employee_phone,employee_email,employee_address," +
            "position_id,education_degree_id,division_id,user_name from furama.employee where employee_id=? ;";

    private static final String UPDATE_EMPLOYEE="update employee" +
            " set employee_name=?,employee_birthday=?,employee_id_card=?,employee_salary=?,employee_phone=?," +
            "employee_email=?,employee_address=?,position_id=?,education_degree_id=?,division_id=?,user_name=?" +
            " where employee_id=?";

    private static final String SELECT_EMPLOYEE_BY_NAME=" select employee_id,employee_name,employee_birthday," +
            "employee_id_card,employee_salary,employee_phone,employee_email,employee_address," +
            "position_id,education_degree_id,division_id,user_name from furama.employee where employee_name like ? escape '!';";
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

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee>employeeList=new ArrayList<>();
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_ALL_EMPLOYEE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String employeeId=rs.getString("employee_id");
                String employeeName=rs.getString("employee_name");
                String birthday=rs.getString("employee_birthday");
                String employeeIdCard=rs.getString("employee_id_card");
                String employeeSalary=rs.getString("employee_salary");
                String employeePhone=rs.getString("employee_phone");
                String employeeEmail=rs.getString("employee_email");
                String employeeAddress=rs.getString("employee_address");
                String positionId=rs.getString("position_id");
                String degreeId=rs.getString("education_degree_id");
                String divisionId=rs.getString("division_id");
                String userName=rs.getString("user_name");

                employeeList.add(new Employee(employeeId,employeeName,birthday,employeeIdCard,
                        employeeSalary,employeePhone,employeeEmail,employeeAddress,positionId,
                        degreeId,divisionId,userName));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findEmployeeByID(String id) {
        Employee employee=null;
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID)) {

            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            employee = new Employee(resultSet.getString("employee_id"),
                    resultSet.getString("employee_name"),resultSet.getString("employee_birthday"),
                    resultSet.getString("employee_id_card"),resultSet.getString("employee_salary"),
                    resultSet.getString("employee_phone"),
                    resultSet.getString("employee_email"),
                    resultSet.getString("employee_address"),resultSet.getString("position_id"),
                    resultSet.getString("education_degree_id"),resultSet.getString("division_id"),resultSet.getString("user_name"));
            employee.setEmployee_id(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public String deleteById(String id) {
        try {
            PreparedStatement preparedStatement
                    = this.baseDAO.getConnection().prepareStatement("delete from employee " +
                    "where employee_id = ?");
            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Deleted";
    }

    @Override
    public String updateEmployee(Employee employee) {
        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setString(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setString(8, employee.getPosition_id());
            preparedStatement.setString(9, employee.getEducation_degree_id());
            preparedStatement.setString(10, employee.getDivision_id());
            preparedStatement.setString(11, employee.getUser_name());
            preparedStatement.setString(12, employee.getEmployee_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "updated";
    }

    @Override
    public List<Employee> selectEmployeeByName(String name) {
        List<Employee>employeeList=new ArrayList<>();
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String employeeId=rs.getString("employee_id");
                String employeeName=rs.getString("employee_name");
                String employeeBirthday=rs.getString("employee_birthday");
                String idCard=rs.getString("employee_id_card");
                String salary=rs.getString("employee_salary");
                String phone=rs.getString("employee_phone");
                String employeeEmail=rs.getString("employee_email");
                String employeeAddress=rs.getString("employee_address");
                String positionId=rs.getString("position_id");
                String educationDegreeId=rs.getString("education_degree_id");
                String divisionId=rs.getString("division_id");
                String userName=rs.getString("user_name");
                employeeList.add(new Employee(employeeId,employeeName,employeeBirthday,idCard,salary,
                        phone,employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,userName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
