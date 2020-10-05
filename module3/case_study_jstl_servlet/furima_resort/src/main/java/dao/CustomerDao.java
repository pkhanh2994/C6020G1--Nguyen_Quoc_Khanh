package dao;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    public String insertCustomer(Customer customer) throws SQLException;
    List<Customer> selectAllCustomer();
    public Customer findCustomerByID(String id);
    public String deleteById(String id);
    public String updateCustomer(Customer customer) throws SQLException;
    public List<Customer>selectCustomerByName(String name);
}
