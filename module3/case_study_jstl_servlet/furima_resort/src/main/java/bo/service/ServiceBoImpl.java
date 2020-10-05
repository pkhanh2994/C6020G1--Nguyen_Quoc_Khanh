package bo.service;

import dao.service.ServiceDao;
import dao.service.ServiceDaoImpl;
import model.service.Service;

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
