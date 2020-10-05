package dao.employee;

import model.employee.Position;

import java.util.List;

public interface PositionDao {
    public List<Position> findAllPosition();
}
