package dao.employee;

import dao.baseDao.BaseDAO;
import model.employee.EducationDegree;
import model.employee.Position;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDaoImpl implements PositionDao{
    private BaseDAO baseDAO=new BaseDAO();
    @Override
    public List<Position> findAllPosition() {
        List<Position> positions = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseDAO.getConnection().
                            prepareStatement("SELECT position_id,position_name FROM furama.position;");

            ResultSet resultSet = preparedStatement.executeQuery();

           Position position;
            while (resultSet.next()) {
                String id = resultSet.getString("position_id");
                String name = resultSet.getString("position_name");

                position = new Position(id, name);
                positions.add(position);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return positions;
    }

}
