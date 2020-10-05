package bo.employee;

import dao.employee.EmployeeDao;
import dao.employee.EmployeeDaoImpl;
import model.employee.Employee;

import java.sql.SQLException;

public class EmployeeBoImpl implements EmployeeBo {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public String insertEmployee(Employee employee) throws SQLException {
        String message = "";
        message = this.employeeDao.insertEmployee(employee);
        return message;
    }
}
