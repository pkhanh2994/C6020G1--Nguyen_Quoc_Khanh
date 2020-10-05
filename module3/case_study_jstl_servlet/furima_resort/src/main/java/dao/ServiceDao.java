package dao;

import model.Service;

import java.sql.SQLException;

public interface ServiceDao {
    public String insertService(Service service) throws SQLException;
}
