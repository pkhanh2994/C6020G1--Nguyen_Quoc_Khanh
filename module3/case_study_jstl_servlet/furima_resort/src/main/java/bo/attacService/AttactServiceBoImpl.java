package bo.attacService;

import dao.attactService.AttactServiceDao;
import dao.attactService.AttactServiceDaoImpl;
import model.acttactService.AttactService;

import java.util.List;

public class AttactServiceBoImpl implements AttactServiceBo {
    AttactServiceDao attactServiceDao=new AttactServiceDaoImpl();
    @Override
    public List<AttactService> selectAllAttactService() {
        return this.attactServiceDao.selectAllAttactService();
    }
}
