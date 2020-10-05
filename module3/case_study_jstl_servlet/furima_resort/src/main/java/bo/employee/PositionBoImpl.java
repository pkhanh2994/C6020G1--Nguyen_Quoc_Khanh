package bo.employee;

import dao.employee.PositionDao;
import dao.employee.PositionDaoImpl;
import model.employee.Position;

import java.util.List;

public class PositionBoImpl implements PositionBo {
    PositionDao positionDao=new PositionDaoImpl();
    @Override
    public List<Position> findAllPosition() {
        return this.positionDao.findAllPosition();
    }
}
