package spring.dao;

import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 25-Aug-17.
 */
public interface ProductDaoInterface {

    public List<Product> getProducts();
}
