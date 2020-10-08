package bo.contact;

import dao.contact.ContactDao;
import dao.contact.ContactDaoImpl;
import model.contact.Contract;

import java.sql.SQLException;
import java.util.List;

public class ContactBoImpl implements ContactBo {
    ContactDao contactDao=new ContactDaoImpl();
    @Override
    public String insertContact(Contract contract) throws SQLException {
        return this.contactDao.insertContact(contract);
    }

    @Override
    public List<Contract> selectAllContract() {
        return this.contactDao.selectAllContract();
    }
}
