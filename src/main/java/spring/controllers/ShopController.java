package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.dao.CategoryDaoInterface;
import spring.entities.Category;
import spring.entities.Product;
import spring.objects.SearchCriteria;
import spring.objects.User;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Eoller on 28-Aug-17.
 */
@Controller
public class ShopController {
    @Autowired
    private ShopServiceInterface shopServiceInterface;
    @Autowired
    private CategoryDaoInterface categoryDaoInterface;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(HttpSession session, ModelMap modelMap) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        return "redirect:/all";
    }

    @RequestMapping(value = "/getList/{id}/{name}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id,@PathVariable("name") String name, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryDaoInterface.getCategories());
        modelMap.addAttribute("productList", shopServiceInterface.searchProductByCategory(new Category(id,name)));
        modelMap.addAttribute("active", name);
        return "list";
    }

    @ModelAttribute
    public SearchCriteria searchCriteria(){
        return new SearchCriteria();
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String showNews(ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryDaoInterface.getCategories());
        modelMap.addAttribute("active", "news");
        return "news";
    }

    @RequestMapping(value = "/searchString", method = RequestMethod.POST)
    public String searchByString(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryDaoInterface.getCategories());
        modelMap.addAttribute("productList", shopServiceInterface.searchProductBySearchString(searchCriteria.getSearchString()));
        return "list";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAll(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        List<Category> categories = categoryDaoInterface.getCategories();
        modelMap.addAttribute("categoryList", categories);
        modelMap.addAttribute("productList", shopServiceInterface.getAllProducts());
        modelMap.addAttribute("active","main");
        return "list";
    }

    @RequestMapping(value = "/create",params ="form",method = RequestMethod.GET)
    public String createProduct(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryDaoInterface.getCategories());
        modelMap.addAttribute("catList", categoryDaoInterface.getCategories());
        Product product = new Product();
        modelMap.addAttribute("product", product);
        return "create";
    }

    @RequestMapping(value = "/added",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute SearchCriteria searchCriteria,@ModelAttribute("product") Product product, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryDaoInterface.getCategories());
        shopServiceInterface.addProduct(product);
        return "redirect:/";
    }
}
