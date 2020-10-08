package bo.service;

import common.Validate;
import dao.service.ServiceDao;
import dao.service.ServiceDaoImpl;
import model.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ServiceBoImpl implements ServiceBo {
    ServiceDao serviceDao = new ServiceDaoImpl();
    @Override
    public String insertService(Service service) throws SQLException {
        String message = "";
        if(!Validate.isValidServiceID(service.getService_id())||service.getService_id()==null){
            message="Please enter service id with form DV-XXXX.XXXX is number 0-9";
        }else if(!Validate.isNumber(service.getNumber_of_floors())||service.getNumber_of_floors()==null||!Validate.isNumber(service.getService_area())
        ||service.getService_area()==null||!Validate.isNumber(service.getPool_area())||service.getPool_area()==null){
            message="Please enter digits";
        }else if(!Validate.isNumber(service.getService_cost())||service.getService_cost()==null||!Validate.isNumber(service.getService_max_people())){
            message="Please enter the digits";
        }else {
            message= serviceDao.insertService(service);
        }

        return message;
    }

    @Override
    public List<Service> selectAllService() {
        return this.serviceDao.selectAllService();
    }

    @Override
    public Service findServiceByID(String id) {
        return this.serviceDao.findServiceByID(id);
    }

    @Override
    public String deleteServiceByID(String id) {
        return this.serviceDao.deleteServiceById(id);
    }
}
