package dao.employee;

import model.employee.Employee;

import java.sql.SQLException;

public interface EmployeeDao {
    public String insertEmployee(Employee employee) throws SQLException;
}
