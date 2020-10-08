package dao.employee;

import model.customer.Customer;
import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    public String insertEmployee(Employee employee) throws SQLException;
    List<Employee> selectAllEmployee();
    public Employee findEmployeeByID(String id);
    String deleteById(String id);
    public String updateEmployee(Employee employee);
    List<Employee>selectEmployeeByName(String name);
}
