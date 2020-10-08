package bo.employee;

import common.Validate;
import dao.employee.EmployeeDao;
import dao.employee.EmployeeDaoImpl;
import model.customer.Customer;
import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public String insertEmployee(Employee employee) throws SQLException {
        String message = "";
        if(employee.getEmployee_id()==null||employee.getEmployee_id()==""){
            message="Please enter the employee id";
        }else if(!Validate.isValidIdentifyCard(employee.getEmployee_id_card())||employee.getEmployee_id_card()==null){
            message="The identify must be enter and have 9 or 12 number";
        }else if(!Validate.isNumber(employee.getEmployee_salary())||employee.getEmployee_salary()==null){
            message="The salary must be enter";
        }else if(!Validate.isValidPhoneNumber(employee.getEmployee_phone())||employee.getEmployee_phone()==null){
            message="he phone number was wrong.Please follow this form 090xxxxxxx or 091xxxxxxx or 8490xxxxxxx or 8491xxxxxxx";
        }else if(!Validate.isValidEmail(employee.getEmployee_email())||employee.getEmployee_email()==null){
            message="Please enter the email";
        }else {
            message = this.employeeDao.insertEmployee(employee);
        }
        return message;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return this.employeeDao.selectAllEmployee();
    }

    @Override
    public Employee findEmployeeByID(String id) {
        return  this.employeeDao.findEmployeeByID(id);
    }

    @Override
    public String deleteById(String id) {
        return this.employeeDao.deleteById(id);
    }

    @Override
    public String updateEmployee(Employee employee) {
        String message="";
        if(!Validate.isValidIdentifyCard(employee.getEmployee_id_card())||employee.getEmployee_id_card()==null){
            message="The identify must be enter and have 9 or 12 number";
        }else if(!Validate.isNumber(employee.getEmployee_salary())||employee.getEmployee_salary()==null){
            message="The salary must be enter";
        }else if(!Validate.isValidPhoneNumber(employee.getEmployee_phone())||employee.getEmployee_phone()==null){
            message="he phone number was wrong.Please follow this form 090xxxxxxx or 091xxxxxxx or 8490xxxxxxx or 8491xxxxxxx";
        }else if(!Validate.isValidEmail(employee.getEmployee_email())||employee.getEmployee_email()==null){
            message="Please enter the email";
        }else {
            message=this.employeeDao.updateEmployee(employee);
        }
        return message;
    }

    @Override
    public List<Employee> selectEmployeeByName(String name) {
        return this.employeeDao.selectEmployeeByName(name);
    }
}
