package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.entities.Category;
import spring.entities.Producer;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 25-Aug-17.
 */
@Component
public class ProductDaoImpl implements ProductDaoInterface {
    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList projectionList;

    public ProductDaoImpl(){
        projectionList = Projections.projectionList();
        projectionList.add(Projections.property("id"), "id");
        projectionList.add(Projections.property("name"), "name");
        projectionList.add(Projections.property("price"), "price");
        projectionList.add(Projections.property("dscr"), "dscr");
        projectionList.add(Projections.property("photo"), "photo");
        projectionList.add(Projections.property("uniqueNumber"), "uniqueNumber");
        projectionList.add(Projections.property("categoryId"), "categoryId");
        projectionList.add(Projections.property("producerId"), "producerId");
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        List<Product> products = (List<Product>) sessionFactory.getCurrentSession()
                .createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return products;
    }

    @Override
    @Transactional
    public List<Product> getProducts(Category category) {
        List<Product> products = createProductList(createProductCriteria().add(Restrictions.eq("categoryId.id", category.getId())));
        return products;
    }

    @Override
    @Transactional

    public List<Product> getProducts(Producer producer) {
        List<Product> products = createProductList(createProductCriteria().add(Restrictions.eq("producerId.id", producer.getId())));
        return  products;
    }

    @Override
    @Transactional
    public List<Product> getProducts(String productName) {
        List<Product> products = createProductList(createProductCriteria().add(Restrictions.ilike("p.name", productName, MatchMode.ANYWHERE)));
        return products;
    }

    @Override
    @Transactional
    public List<Product> getProducts(Character letter) {
        List<Product> products = createProductList(createProductCriteria().add(Restrictions.ilike("p.name", letter.toString(), MatchMode.START)));
        return products;
    }

    private DetachedCriteria createProductCriteria(){
        DetachedCriteria productListCriteria = DetachedCriteria.forClass(Product.class, "p");
        createAliases(productListCriteria);
        return productListCriteria;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("p.categoryId", "categoryId");
        criteria.createAlias("p.producerId", "producerId");
    }

    private List<Product> createProductList(DetachedCriteria productListCriteria){
        Criteria criteria = productListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("p.name")).setProjection(projectionList).setResultTransformer(Transformers.aliasToBean(Product.class));
        return criteria.list();
    }

}
