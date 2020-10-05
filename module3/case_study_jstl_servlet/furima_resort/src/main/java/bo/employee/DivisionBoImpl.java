package bo.employee;

import dao.employee.DivisionDao;
import dao.employee.DivisionDaoImpl;
import model.employee.Division;

import java.util.List;

public class DivisionBoImpl implements DivisionBo {
    DivisionDao divisionDao=new DivisionDaoImpl();
    @Override
    public List<Division> findAllDivision() {
        return this.divisionDao.findAllDivision();
    }
}
