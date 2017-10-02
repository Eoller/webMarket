package spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.entities.Category;
import spring.entities.Product;
import spring.objects.Cart;
import spring.objects.JsonConverter;
import spring.services.CategoryServiceInterface;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpSession;

/**
 * Created by Eoller on 18-Sep-17.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    CategoryServiceInterface categoryServiceInterface;

    @Autowired
    ShopServiceInterface shopServiceInterface;

    @RequestMapping(value = "/rest/{categoryId}", method = RequestMethod.GET)
    public Category read(@PathVariable(value = "categoryId") Long id){
        //return categoryServiceInterface.getCategoryById(id);
        return categoryServiceInterface.getCategoryById(id);
    }

    @RequestMapping(value = "/rest", method = RequestMethod.POST)
    public void create(@RequestBody Category category){
        categoryServiceInterface.addCategory(category);
    }

    @RequestMapping(value = "/rest/cart", method = RequestMethod.GET)
    public Cart getRestCard(HttpSession httpSession){
        Cart cart = (Cart) httpSession.getAttribute("cart");
        return cart;
    }

    @RequestMapping(value = "rest/delete/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") Long id){
        shopServiceInterface.removeProduct(id);
        return "Product removed";
    }

    @RequestMapping(value = "rest/product/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id) throws JsonProcessingException {
        return JsonConverter.toJson(shopServiceInterface.getProductById(id));
    }

}
