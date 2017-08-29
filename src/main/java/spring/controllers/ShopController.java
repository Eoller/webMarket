package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.dao.CategoryDaoInterface;
import spring.entities.Category;
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
        modelMap.addAttribute("genreList", categoryDaoInterface.getCategories());
        return "facade";
    }

    @RequestMapping(value = "/getList/{id}/{name}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id,@PathVariable("name") String name, ModelMap modelMap){
        modelMap.addAttribute("genreList", categoryDaoInterface.getCategories());
        modelMap.addAttribute("productList", shopServiceInterface.searchProductByCategory(new Category(id,name)));
        return "facade";
    }

}
