package dao.customerUsingService;

import dao.baseDao.BaseDAO;
import model.customerUsingService.CustomerUsingService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingServiceDaoImpl implements CustomerUsingServiceDao {
    private BaseDAO baseDAO=new BaseDAO();

    private static final String SELECT_CUTOMER_USER_SERVICE="select customer.customer_id,customer.customer_name,contract.contract_id,group_concat(attach_service.attach_service_name) as attach_service\n" +
            "from customer\n" +
            "inner join contract on contract.customer_id=customer.customer_id\n" +
            "left join contract_detail on contract_detail.contract_id=contract.contract_id\n" +
            "left join attach_service on attach_service.attach_service_id=contract_detail.attach_service_id\n" +
            "where contract.contract_end_date>=curdate()\n" +
            "group by customer.customer_id;";

    @Override
    public List<CustomerUsingService> selectAllCustomerUsingService() {
        List<CustomerUsingService>customerUsingServiceList=new ArrayList<>();
        try (PreparedStatement preparedStatement=this.baseDAO.getConnection().prepareStatement(SELECT_CUTOMER_USER_SERVICE)){
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String customerId=rs.getString("customer_id");
                String customerName=rs.getString("customer_name");
                String contractId=rs.getString("contract_id");
                String attachServiceName=rs.getString("attach_Service");

                customerUsingServiceList.add(new CustomerUsingService(customerId,customerName,contractId,attachServiceName));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerUsingServiceList;
    }


}
