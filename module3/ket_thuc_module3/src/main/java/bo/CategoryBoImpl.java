package bo;

import dao.CategoryDao;
import dao.CategoryDaoImpl;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryBoImpl implements CategoryBo {
    CategoryDao categoryDao=new CategoryDaoImpl();

    @Override
    public List<Category> findAllCategory() {
        return this.categoryDao.findAllCategory();
    }

    @Override
    public Category SelectByID(String id) {
        return this.categoryDao.SelectByID(id);
    }
}
