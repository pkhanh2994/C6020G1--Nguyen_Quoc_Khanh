package bo.employee;

import model.customer.Customer;
import model.employee.Employee;

import java.sql.SQLException;

public interface EmployeeBo {
    public String insertEmployee(Employee employee) throws SQLException;

}
