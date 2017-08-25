package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 25-Aug-17.
 */
@Component
public class ProductDaoImpl implements ProductDaoInterface {
    @Autowired
    private SessionFactory sessionFactory;

    private List<Product> products;

    @Override
    @Transactional
    public List<Product> getProducts() {
        products = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return products;
    }
}
