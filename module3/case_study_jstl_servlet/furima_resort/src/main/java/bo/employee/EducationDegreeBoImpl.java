package bo.employee;

import dao.employee.EducationDegreeDao;
import dao.employee.EducationDegreeDaoImpl;
import model.employee.EducationDegree;
import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public class EducationDegreeBoImpl implements EducationDegreeBo {
  EducationDegreeDao educationDegreeDao=new EducationDegreeDaoImpl();


    @Override
    public List<EducationDegree> findAllEducation() {
        return this.educationDegreeDao.findAllEducationDegree();
    }
}
