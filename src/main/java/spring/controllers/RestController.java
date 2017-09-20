package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.entities.Category;
import spring.entities.Product;
import spring.services.CategoryServiceInterface;
import spring.services.ShopServiceInterface;

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

}
