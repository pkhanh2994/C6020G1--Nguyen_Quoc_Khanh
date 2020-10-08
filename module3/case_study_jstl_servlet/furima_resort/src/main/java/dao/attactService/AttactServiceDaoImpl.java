package dao.attactService;

import dao.baseDao.BaseDAO;
import model.acttactService.AttactService;
import model.customer.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttactServiceDaoImpl implements AttactServiceDao {
    private BaseDAO baseDAO=new BaseDAO();
    private final String SELECT_ALL_ATTACT_SERVICE="select attach_service_id,attach_service_name from attach_service";

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
    public List<AttactService> selectAllAttactService() {

            List<AttactService>attactServiceList=new ArrayList<>();
            try(PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_ALL_ATTACT_SERVICE)) {
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    String attachServiceId=rs.getString("attach_service_id");
                    String attachServiceName=rs.getString("attach_service_name");

                   attactServiceList.add(new AttactService(attachServiceId,attachServiceName));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return attactServiceList;
        }
}
