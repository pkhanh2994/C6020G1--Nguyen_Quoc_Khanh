package dao;

import model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAllCategory();
    Category SelectByID(String id);
}
