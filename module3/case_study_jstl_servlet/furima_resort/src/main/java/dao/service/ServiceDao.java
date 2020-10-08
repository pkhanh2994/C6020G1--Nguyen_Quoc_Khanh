package dao.service;

import model.service.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDao {
    public String insertService(Service service) throws SQLException;
    List<Service> selectAllService();
    public Service findServiceByID(String id);
    public String deleteServiceById(String id);
}
