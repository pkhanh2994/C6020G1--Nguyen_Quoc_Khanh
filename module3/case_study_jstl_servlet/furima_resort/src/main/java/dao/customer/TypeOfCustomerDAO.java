package dao.customer;

import model.customer.TypeOfCustomer;

import java.util.List;

public interface TypeOfCustomerDAO {
    List<TypeOfCustomer> findAllTypeOfCustomer();
}
