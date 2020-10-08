package dao.contractDetails;

import dao.baseDao.BaseDAO;
import model.contracDetails.ContractDetails;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDetailsDaoImpl implements ContractDetailsDao {
    private BaseDAO baseDAO=new BaseDAO();

    private final String INSERT_CONTRACT_DETAILS="insert into contract_detail (contract_detail_id," +
            "quantity,contract_id,attach_service_id) values(?,?,?,?);";
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
    public String insertContractDetails(ContractDetails contractDetails) {

        try (PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_CONTRACT_DETAILS)) {
            preparedStatement.setString(1, contractDetails.getContract_detail_id());
            preparedStatement.setString(2, contractDetails.getQuantity());
            preparedStatement.setString(3, contractDetails.getContract_id());
            preparedStatement.setString(4, contractDetails.getAttach_service_id());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return "created new contract";
    }
}
