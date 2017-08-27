package spring.dao;

import spring.entities.Category;

import java.util.List;

/**
 * Created by Eoller on 27-Aug-17.
 */
public interface CategoryDaoInterface {
    public List<Category> getCategories();
}
