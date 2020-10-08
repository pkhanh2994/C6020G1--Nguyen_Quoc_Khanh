package bo;

import model.Category;

import java.util.List;

public interface CategoryBo {
    List<Category>findAllCategory();
    Category SelectByID(String id);
}
