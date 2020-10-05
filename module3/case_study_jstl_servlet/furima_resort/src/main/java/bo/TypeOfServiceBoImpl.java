package bo;

import dao.TypeOfServiceDao;
import dao.TypeOfServiceDaoImpl;
import model.TypeOfRent;
import model.TypeOfService;

import java.util.List;

public class TypeOfServiceBoImpl implements TypeOfServiceBo {
    TypeOfServiceDao typeOfServiceDao=new TypeOfServiceDaoImpl();

    @Override
    public List<TypeOfService> findAllTypeOfService() {
            return this.typeOfServiceDao.findAllTypeOfService();
    }
}
