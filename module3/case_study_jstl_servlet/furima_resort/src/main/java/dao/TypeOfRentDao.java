package dao;

import model.TypeOfCustomer;
import model.TypeOfRent;

import java.util.List;

public interface TypeOfRentDao {
    public List<TypeOfRent> findAllTypeOfRent();
}
