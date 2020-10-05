package bo.customer;

import dao.customer.TypeOfCustomerDAO;
import dao.customer.TypeOfCustomerDAOImpl;
import model.customer.TypeOfCustomer;

import java.util.List;

public class TypeOfCustomerBOImpl implements TypeOfCustomerBO {
    TypeOfCustomerDAO typeOfCustomerDAO=new TypeOfCustomerDAOImpl();
    @Override
    public List<TypeOfCustomer> findAllTypeOfCustomer() {
        return this.typeOfCustomerDAO.findAllTypeOfCustomer();
    }
}
