package bo;

import dao.TypeOfCustomerDAO;
import dao.TypeOfCustomerDAOImpl;
import model.TypeOfCustomer;

import java.util.List;

public class TypeOfCustomerBOImpl implements TypeOfCustomerBO {
    TypeOfCustomerDAO typeOfCustomerDAO=new TypeOfCustomerDAOImpl();
    @Override
    public List<TypeOfCustomer> findAllTypeOfCustomer() {
        return this.typeOfCustomerDAO.findAllTypeOfCustomer();
    }
}
