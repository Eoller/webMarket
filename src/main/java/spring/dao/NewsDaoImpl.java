package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.entities.News;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 11-Sep-17.
 */
@Component
public class NewsDaoImpl implements NewsDaoInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<News> getAllNews() {
        return (List<News>) sessionFactory.getCurrentSession().createCriteria(News.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    @Transactional
    public News getNewsById(Long id) {
        return (News) sessionFactory.getCurrentSession().get(News.class, id);
    }

    @Override
    @Transactional
    public void addNews(News news) {

    }

    @Override
    @Transactional
    public void deleteNews(Long id) {
        News news =(News) sessionFactory.getCurrentSession().load(News.class, id);
        if(null != news){
            sessionFactory.getCurrentSession().delete(news);
        }
    }
}
