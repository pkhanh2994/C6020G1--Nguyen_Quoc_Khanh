package bo.service;

import dao.service.TypeOfServiceDao;
import dao.service.TypeOfServiceDaoImpl;
import model.service.TypeOfService;

import java.util.List;

public class TypeOfServiceBoImpl implements TypeOfServiceBo {
    TypeOfServiceDao typeOfServiceDao=new TypeOfServiceDaoImpl();

    @Override
    public List<TypeOfService> findAllTypeOfService() {
            return this.typeOfServiceDao.findAllTypeOfService();
    }
}
