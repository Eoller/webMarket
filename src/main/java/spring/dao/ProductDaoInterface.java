package spring.dao;

import spring.entities.Category;
import spring.entities.Producer;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 25-Aug-17.
 */
public interface ProductDaoInterface {

    public List<Product> getProducts();
    public List<Product> getProducts(Category category);
    public List<Product> getProducts(Producer producer);
    public List<Product> getProducts(String productName);
    public List<Product> getProducts(Character letter);
}
