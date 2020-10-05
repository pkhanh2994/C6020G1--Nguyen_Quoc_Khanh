package bo;

import model.Service;

import java.sql.SQLException;

public interface ServiceBo {
    public String insertService(Service service) throws SQLException;
}
