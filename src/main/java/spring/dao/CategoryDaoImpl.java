package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.entities.Category;

import java.util.List;

/**
 * Created by Eoller on 27-Aug-17.
 */
@Component
public class CategoryDaoImpl implements CategoryDaoInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Category> getCategories() {
        List<Category> categoryList = (List<Category>) sessionFactory.getCurrentSession()
                .createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return categoryList;
    }

    @Override
    @Transactional
    public Category getCategory(Long id) {
        return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    @Transactional
    public void addCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }


}
