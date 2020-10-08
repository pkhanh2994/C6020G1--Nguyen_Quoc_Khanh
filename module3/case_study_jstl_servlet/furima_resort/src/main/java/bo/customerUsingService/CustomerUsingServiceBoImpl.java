package bo.customerUsingService;

import dao.customerUsingService.CustomerUsingServiceDao;
import dao.customerUsingService.CustomerUsingServiceDaoImpl;
import model.customerUsingService.CustomerUsingService;

import java.util.List;

public class CustomerUsingServiceBoImpl implements CustomerUsingServiceBo {
    CustomerUsingServiceDao customerUsingServiceDao=new CustomerUsingServiceDaoImpl();
    @Override
    public List<CustomerUsingService> selectAllCustomerUsingService() {
        return this.customerUsingServiceDao.selectAllCustomerUsingService();
    }
}
