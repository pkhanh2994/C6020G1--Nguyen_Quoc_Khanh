package dao.service;

import model.service.Service;

import java.sql.SQLException;

public interface ServiceDao {
    public String insertService(Service service) throws SQLException;
}
