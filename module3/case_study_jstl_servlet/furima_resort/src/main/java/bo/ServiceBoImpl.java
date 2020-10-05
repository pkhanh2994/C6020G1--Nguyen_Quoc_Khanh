package bo;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import dao.ServiceDao;
import dao.ServiceDaoImpl;
import model.Service;

import java.sql.SQLException;

public class ServiceBoImpl implements ServiceBo {
    ServiceDao serviceDao = new ServiceDaoImpl();
    @Override
    public String insertService(Service service) throws SQLException {
        String message = "";
        message= serviceDao.insertService(service);
        return message;
    }
}
