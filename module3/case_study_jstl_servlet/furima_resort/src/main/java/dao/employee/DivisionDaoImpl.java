package dao.employee;

import bo.employee.DivisionBo;
import dao.baseDao.BaseDAO;
import model.customer.TypeOfCustomer;
import model.employee.Division;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionDaoImpl implements DivisionDao {
    private BaseDAO baseDAO=new BaseDAO();
    @Override
    public List<Division> findAllDivision() {
        List<Division> divisions = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().
                            prepareStatement("SELECT division_id,division_name FROM furama.division;");

            ResultSet resultSet = preparedStatement.executeQuery();

            Division division;
            while (resultSet.next()) {
                String id = resultSet.getString("division_id");
                String name = resultSet.getString("division_name");

                division = new Division(id, name);
                divisions.add(division);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return divisions;
    }

}
