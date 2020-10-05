package bo;

import dao.TypeOfRentDao;
import dao.TypeOfRentDaoImpl;
import model.TypeOfCustomer;
import model.TypeOfRent;

import java.util.List;

public class TypeOfRentImplBo implements TypeOfRentBo {
    TypeOfRentDao typeOfRentDao=new TypeOfRentDaoImpl();
    @Override
    public List<TypeOfRent> findAllTypeOfRent() {
        return this.typeOfRentDao.findAllTypeOfRent();
    }
}
