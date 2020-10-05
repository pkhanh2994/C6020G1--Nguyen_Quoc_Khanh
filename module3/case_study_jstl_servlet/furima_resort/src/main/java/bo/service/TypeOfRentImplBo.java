package bo.service;

import dao.service.TypeOfRentDao;
import dao.service.TypeOfRentDaoImpl;
import model.service.TypeOfRent;

import java.util.List;

public class TypeOfRentImplBo implements TypeOfRentBo {
    TypeOfRentDao typeOfRentDao=new TypeOfRentDaoImpl();
    @Override
    public List<TypeOfRent> findAllTypeOfRent() {
        return this.typeOfRentDao.findAllTypeOfRent();
    }
}
