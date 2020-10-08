package bo.service;

import model.customer.Customer;
import model.service.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceBo {
    public String insertService(Service service) throws SQLException;
    List<Service> selectAllService();
    public Service findServiceByID(String id);
    public String deleteServiceByID(String id);
}
