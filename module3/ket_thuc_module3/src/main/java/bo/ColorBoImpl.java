package bo;

import dao.ColorDao;
import dao.ColorDaoImpl;
import model.Color;

import java.util.List;

public class ColorBoImpl implements ColorBo {
    ColorDao colorDao=new ColorDaoImpl();
    @Override
    public List<Color> findAllColor() {
        return this.colorDao.findAllColor();
    }
}
