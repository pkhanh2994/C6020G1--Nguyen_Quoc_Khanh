package bo.customer;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo {
    public String insertCustomer(Customer customer) throws SQLException;

    List<Customer> selectAllCustomer();

    public Customer findCustomerByID(String id);
    String deleteById(String id);

    public String updateCustomer(Customer customer);
    public List<Customer> selectCustomerByName(String name);

}
