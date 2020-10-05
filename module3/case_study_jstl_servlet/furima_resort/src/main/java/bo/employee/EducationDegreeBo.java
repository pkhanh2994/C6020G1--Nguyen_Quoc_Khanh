package bo.employee;

import model.employee.Division;
import model.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeBo {
    List<EducationDegree> findAllEducation();
}
