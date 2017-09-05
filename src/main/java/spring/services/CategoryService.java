package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.CategoryDaoInterface;
import spring.entities.Category;

import java.util.List;

/**
 * Created by Eoller on 05-Sep-17.
 */
@Service
public class CategoryService implements CategoryServiceInterface {
    @Autowired
    private CategoryDaoInterface categoryDaoInterface;

    @Override
    public List<Category> getCategories() {
        return categoryDaoInterface.getCategories();
    }
}
