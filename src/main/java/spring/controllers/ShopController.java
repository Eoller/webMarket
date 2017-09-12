package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import spring.dto.ProductDto;
import spring.entities.Category;
import spring.entities.Product;
import spring.objects.EmailModel;
import spring.objects.SearchCriteria;
import spring.services.CategoryServiceInterface;
import spring.services.ProducerServiceInterface;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eoller on 28-Aug-17.
 */


@Controller
public class ShopController {
    @Autowired
    private ShopServiceInterface shopServiceInterface;
    @Autowired
    private CategoryServiceInterface categoryServiceInterface;
    @Autowired
    private ProducerServiceInterface producerServiceInterface;

    /**
     *  redirect to main page with all products
     *
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(HttpSession session, ModelMap modelMap) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        return "redirect:/all";
    }

    /**
     *  Shows list of product by category
     *
     */
    @RequestMapping(value = "/getList/{id}/{name}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id,@PathVariable("name") String name, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("productList", shopServiceInterface.searchProductByCategory(new Category(id,name)));
        modelMap.addAttribute("active", name);
        return "list";
    }

    /**
     *  Search by search string
     *
     */
    @RequestMapping(value = "/searchString", method = RequestMethod.POST)
    public String searchByString(ModelMap modelMap, HttpServletRequest request){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        String search = request.getParameter("searchString");
        modelMap.addAttribute("productList", shopServiceInterface.searchProductBySearchString(search));
        return "list";
    }

    /**
     *  Shows list of all products
     *
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAll(ModelMap modelMap){
        List<Category> categories = categoryServiceInterface.getCategories();
        modelMap.addAttribute("categoryList", categories);
        modelMap.addAttribute("productList", shopServiceInterface.getAllProducts());
        modelMap.addAttribute("active","main");
        return "list";
    }

    @RequestMapping(value = "/email/send", method = RequestMethod.GET)
    public String showEmailForm(ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("emailModel",new EmailModel());
        modelMap.addAttribute("active","contact");
        return "emailForm";
    }

}
