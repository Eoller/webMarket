package spring.dao;

import spring.entities.Category;

import java.util.List;

/**
 * Created by Eoller on 27-Aug-17.
 */
public interface CategoryDaoInterface {
    public List<Category> getCategories();
    public Category getCategory(Long id);
    public void addCategory(Category category);
    public void deleteCategory(Long id);
}
