package spring.services;

import org.springframework.stereotype.Component;
import spring.dao.ProductDaoInterface;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 27-Aug-17.
 */
@Component
public class ShopService {

    private ProductDaoInterface productDaoInterface;

    private List<Product> products;

}
