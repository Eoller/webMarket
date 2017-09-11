package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.entities.Producer;

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
        sessionFactory.getCurrentSession().delete(producer);
    }
}
