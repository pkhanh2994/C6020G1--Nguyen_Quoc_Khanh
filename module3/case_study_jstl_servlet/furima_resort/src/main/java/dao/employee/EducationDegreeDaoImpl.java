package dao.employee;

import dao.baseDao.BaseDAO;
import model.employee.Division;
import model.employee.EducationDegree;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDaoImpl implements EducationDegreeDao {
    private BaseDAO baseDAO=new BaseDAO();
    @Override
    public List<EducationDegree> findAllEducationDegree() {
        List<EducationDegree> educationDegrees = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().
                            prepareStatement("SELECT education_degree_id,education_degree_name FROM furama.education_degree;");

            ResultSet resultSet = preparedStatement.executeQuery();

         EducationDegree educationDegree;
            while (resultSet.next()) {
                String id = resultSet.getString("education_degree_id");
                String name = resultSet.getString("education_degree_name");

                educationDegree = new EducationDegree(id, name);
                educationDegrees.add(educationDegree);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return educationDegrees;
    }

}
