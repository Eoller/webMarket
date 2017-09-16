package spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.entities.Category;
import spring.objects.EmailModel;
import spring.objects.SearchCriteria;
import spring.services.CategoryServiceInterface;
import spring.services.ProducerServiceInterface;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Created by Eoller on 28-Aug-17.
 */

@Controller
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

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
    public String main(HttpSession session,Locale locale, HttpSession httpSession) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        logger.info("Welcome admin! Your locale now is {}.", locale);
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
    public String searchByString(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap, HttpServletRequest request){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        String searchString = request.getParameter("searchString");
        modelMap.addAttribute("productList", shopServiceInterface.searchProductBySearchString(searchString));
        return "list";
    }

    /**
     *  Shows list of all products
     *
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAll(ModelMap modelMap, HttpSession httpSession){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("productList", shopServiceInterface.getAllProducts());
        modelMap.addAttribute("active","main");
        logger.info("/all was calling");
        logger.info("Atribute in HttpSession in /all is {}", httpSession.getAttribute("categoryList"));
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
