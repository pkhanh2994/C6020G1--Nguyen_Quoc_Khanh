package bo.contact;

import model.contact.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContactBo {
    public String insertContact(Contract contract) throws SQLException;
    List<Contract> selectAllContract();
}
