package bo.customer;

import dao.customer.CustomerDao;
import dao.customer.CustomerDaoImpl;
import model.customer.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao = new CustomerDaoImpl();
//    @Override
//    public String save(Customer customer) {
//        String message = "";
//        if (customer.getCustomer_name() == null || customer.getCustomer_name().equals("")) {
//            message = "Please input name";
//        } else {
//            message = customerDao.save(customer);
//        }
//
//        return message;
//    }

    @Override
    public String insertCustomer(Customer customer) throws SQLException {
        String message = "";
       message= customerDao.insertCustomer(customer);
        return message;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer>customerList;
        customerList=this.customerDao.selectAllCustomer();
        return customerList;
    }

    @Override
    public Customer findCustomerByID(String id) {
        return  this.customerDao.findCustomerByID(id);
    }

    @Override
    public String deleteById(String id) {
        return this.customerDao. deleteById(id);
    }

    @Override
    public String updateCustomer(Customer customer) {
        String message="";
        try {
             message=this.customerDao.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
      List<Customer>customerList=new ArrayList<>();
      customerList=this.customerDao.selectCustomerByName(name);
      return customerList;
    }

}
