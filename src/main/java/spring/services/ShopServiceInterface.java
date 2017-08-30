package spring.services;

import spring.entities.Category;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 27-Aug-17.
 */
public interface ShopServiceInterface {
    public List<Product> searchProductBySearchString(String searchString);
    public List<Product> searchProductByCategory(Category category);
    public Product searchProductById(Long id);
}
