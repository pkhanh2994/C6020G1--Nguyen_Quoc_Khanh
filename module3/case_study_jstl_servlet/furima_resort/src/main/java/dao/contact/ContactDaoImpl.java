package dao.contact;

import dao.baseDao.BaseDAO;
import model.contact.Contract;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements ContactDao {
    private final String INSERT_CONTACT = "insert into contract (contract_id, " +
            "contract_start_date, contract_end_date, contract_deposit,contract_total_money," +
            "employee_id, customer_id,service_id)" +
            "values(?,?,?,?,?,?,?,?);";

    private final String SELECT_ALL_CONTRACT="select contract_id,contract_start_date,contract_end_date," +
            "contract_deposit,contract_total_money,employee_id,customer_id,service_id from contract;";


    private BaseDAO baseDAO = new BaseDAO();

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
    public String insertContact(Contract contract) throws SQLException {

        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_CONTACT)) {
            preparedStatement.setString(1, contract.getContract_id());
            preparedStatement.setString(2, contract.getContract_start_date());
            preparedStatement.setString(3, contract.getContract_end_date());
            preparedStatement.setString(4, contract.getContract_deposit());
            preparedStatement.setString(5, contract.getContract_total_money());
            preparedStatement.setString(6, contract.getEmployee_id());
            preparedStatement.setString(7, contract.getCustomer_id());
            preparedStatement.setString(8, contract.getService_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return "created new contract";
    }

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> contractList =new ArrayList<>();
        try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CONTRACT)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String contractId=rs.getString("contract_id");
                String contractStartDate=rs.getString("contract_start_date");
                String contractEndDate=rs.getString("contract_end_date");
                String contractDeposit=rs.getString("contract_deposit");
                String totalMoney=rs.getString("contract_total_money");
                String employeeId=rs.getString("employee_id");
                String customerId=rs.getString("customer_id");
                String serviceId=rs.getString("service_id");

                contractList.add(new Contract(contractId,contractStartDate,contractEndDate,contractDeposit,
                        totalMoney,employeeId,customerId,serviceId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}
