package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.entities.Producer;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 05-Sep-17.
 */
@Component
public class ProducerDaoImpl implements ProducerDaoInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Producer> getProducers() {
        return (List<Producer>) sessionFactory.getCurrentSession().createCriteria(Producer.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    @Transactional
    public void addProducer(Producer producer) {
        sessionFactory.getCurrentSession().save(producer);
    }

    @Override
    @Transactional
    public void deleteProducer(Long id) {
        Producer producer = (Producer) sessionFactory.getCurrentSession().load(Producer.class, id);
        List<Product> products = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("producerId.id", producer.getId())).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        for (Product product: products ) {
            sessionFactory.getCurrentSession().delete(product);
        }
        sessionFactory.getCurrentSession().delete(producer);
    }
}
