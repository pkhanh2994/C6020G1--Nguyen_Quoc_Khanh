package bo.customer;

import common.Validate;
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
//    message = customerDao.insertCustomer(customer);
    @Override
    public String insertCustomer(Customer customer) throws SQLException {
        String message = "";
        if(customer.getCustomer_id()==null||customer.getCustomer_id()==""){
            message = "Please input customer ID";
        }else if(!Validate.isValidCustomerID(customer.getCustomer_id())){
            message="You were entered wrong form of customer ID.Please follow this form:KH-XXXX.Which XXXX is number from 0-9";
        }else if(!Validate.isValidPhoneNumber(customer.getCustomer_phone())||customer.getCustomer_phone()==null) {
            message="The phone number was wrong.Please follow this form 090xxxxxxx or 091xxxxxxx or 8490xxxxxxx or 8491xxxxxxx";
        }else if(!Validate.isValidIdentifyCard(customer.getCustomer_id_card())||customer.getCustomer_id_card()==null) {
            message="The identify card was wrong.Please enter 9 or 12 digits";
        }else if(!Validate.isValidEmail(customer.getCustomer_email())||customer.getCustomer_email()==null){
            message="The email is invalid";
        }else {
            message = customerDao.insertCustomer(customer);
        }
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
            if(!Validate.isValidCustomerID(customer.getCustomer_id())||customer.getCustomer_id()==null){
                message="You were entered wrong form of customer ID.Please follow this form:KH-XXXX.Which XXXX is number from 0-9";
            }else if(!Validate.isValidPhoneNumber(customer.getCustomer_phone())||customer.getCustomer_phone()==null) {
                message="The phone number was wrong.Please follow this form 090xxxxxxx or 091xxxxxxx or 8490xxxxxxx or 8491xxxxxxx";
            }else if(!Validate.isValidIdentifyCard(customer.getCustomer_id_card())||customer.getCustomer_id_card()==null) {
                message="The identify card was wrong.Please enter 9 or 12 digits";
            }else {
                message=this.customerDao.updateCustomer(customer);
            }

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
