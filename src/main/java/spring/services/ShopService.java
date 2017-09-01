package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.dao.ProductDaoInterface;
import spring.entities.Category;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 27-Aug-17.
 */
@Component
public class ShopService implements ShopServiceInterface{

    @Autowired
    private ProductDaoInterface productDaoInterface;


    @Override
    public List<Product> searchProductBySearchString(String searchString) {
        return productDaoInterface.getProducts(searchString);
    }

    @Override
    public List<Product> searchProductByCategory(Category category) {
        return productDaoInterface.getProducts(category);
    }

    @Override
    public Product getProductById(Long id) {
        return productDaoInterface.getProduct(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDaoInterface.getProducts();
    }

    @Override
    public void addProduct(Product product) {
        productDaoInterface.addProduct(product);
    }

    @Override
    public void removeProduct(Long id) {
        productDaoInterface.removeProduct(id);
    }
}
