package spring.services;

import spring.entities.Category;

import java.util.List;

/**
 * Created by Eoller on 05-Sep-17.
 */
public interface CategoryServiceInterface {
    public List<Category> getCategories();
    public void addCategory(Category category);
    public Category getCategoryById(Long id);
    public void deleteCategory(Long id);
}
