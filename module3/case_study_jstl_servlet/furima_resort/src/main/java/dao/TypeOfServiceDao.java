package dao;

import model.TypeOfRent;
import model.TypeOfService;

import java.util.List;

public interface TypeOfServiceDao {
    public List<TypeOfService> findAllTypeOfService();
}
