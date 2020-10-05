package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private BaseDAO baseDAO = new BaseDAO();



    private static final String INSERT_CUSTOMER_SQL = "insert into customer (customer_id, customer_name, customer_birthday, customer_gender,customer_id_card,customer_phone, customer_email,customer_type_id, customer_address)" +
            "values(?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_ALL_CUSTOMER="select customer_id, customer_name, customer_birthday, customer_gender,customer_id_card,customer_phone, customer_email,customer_type_id, customer_address" +
            "            from customer;";

    private static final String SELECT_CUSTOMER_BY_ID=" select customer_id, customer_name, customer_birthday, " +
            "customer_gender,customer_id_card,customer_phone,customer_address,customer_type_id from customer where customer_id=?;";

    private static final String UPDATE_CUSTOMER="update customer" +
            " set customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_type_id=?,customer_address=?" +
            " where customer_id=?";
    private static final String SELECT_CUSTOMER_BY_NAME="select customer_id, customer_name, customer_birthday, customer_gender,customer_id_card,customer_phone, customer_email,customer_type_id, customer_address" +
            "            from customer where customer_name  like ? escape '!';";


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
    public String insertCustomer(Customer customer) throws SQLException {


        try ( PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getCustomer_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setString(3, customer.getCustomer_birthday());
            preparedStatement.setString(4, customer.getCustomer_gender());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(7, customer.getCustomer_email());
            preparedStatement.setString(8, customer.getCustomer_type_id());
            preparedStatement.setString(9, customer.getCustomer_address());

          preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return "created new customer";
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer>customerList=new ArrayList<>();
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
            String customerId=rs.getString("customer_id");
            String customerName=rs.getString("customer_name");
            String customerBirthday=rs.getString("customer_birthday");
            String customerGender=rs.getString("customer_gender");
            String customerIdCard=rs.getString("customer_id_card");
            String customerPhone=rs.getString("customer_phone");
            String customerEmail=rs.getString("customer_email");
            String customerTypeId=rs.getString("customer_type_id");
            String customerAddress=rs.getString("customer_address");

            customerList.add(new Customer(customerId,customerName,customerBirthday,customerGender,
                    customerIdCard,customerPhone,customerEmail,customerTypeId,customerAddress));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findCustomerByID(String id) {
        Customer customer=null;
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID)) {

            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customer = new Customer(resultSet.getString("customer_id"),
                    resultSet.getString("customer_name"),resultSet.getString("customer_birthday"),
                    resultSet.getString("customer_gender"),resultSet.getString("customer_id_card"),resultSet.getString("customer_phone"),
                    resultSet.getString("customer_type_id"),resultSet.getString("customer_address"));
            customer.setCustomer_id(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public String deleteById(String id) {
        try {
            PreparedStatement preparedStatement
                    = this.baseDAO.getConnection().prepareStatement("delete from customer " +
                    "where customer_id = ?");
            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Deleted";
    }

    @Override
    public String updateCustomer(Customer customer) throws SQLException {
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(UPDATE_CUSTOMER)){
        preparedStatement.setString(1,customer.getCustomer_name());
        preparedStatement.setString(2,customer.getCustomer_birthday());
        preparedStatement.setString(3,customer.getCustomer_gender());
        preparedStatement.setString(4,customer.getCustomer_id_card());
        preparedStatement.setString(5,customer.getCustomer_phone());
        preparedStatement.setString(6,customer.getCustomer_type_id());
        preparedStatement.setString(7,customer.getCustomer_address());
        preparedStatement.setString(8,customer.getCustomer_id());
        preparedStatement.executeUpdate();
        }
        return "updated";
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
      List<Customer>customerList=new ArrayList<>();
      try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_CUSTOMER_BY_NAME)) {
          preparedStatement.setString(1, "%" + name + "%");
          ResultSet rs = preparedStatement.executeQuery();
          while (rs.next()){
              String customerId=rs.getString("customer_id");
              String customerName=rs.getString("customer_name");
              String customerBirthday=rs.getString("customer_birthday");
              String customerGender=rs.getString("customer_gender");
              String customerIdCard=rs.getString("customer_id_card");
              String customerPhone=rs.getString("customer_phone");
              String customerEmail=rs.getString("customer_email");
              String customerTypeId=rs.getString("customer_type_id");
              String customerAddress=rs.getString("customer_address");
              customerList.add(new Customer(customerId,customerName,customerBirthday,customerGender,
                      customerIdCard,customerPhone,customerEmail,customerTypeId,customerAddress));
          }

      } catch (SQLException e) {
          e.printStackTrace();
      }
        return customerList;
    }

}
