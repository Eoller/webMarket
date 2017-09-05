package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import spring.dto.ProductDto;
import spring.entities.Category;
import spring.entities.Product;
import spring.objects.SearchCriteria;
import spring.services.CategoryServiceInterface;
import spring.services.ProducerServiceInterface;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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
     *
     * @param session
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(HttpSession session, ModelMap modelMap) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        return "redirect:/all";
    }

    @RequestMapping(value = "/getList/{id}/{name}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id,@PathVariable("name") String name, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("productList", shopServiceInterface.searchProductByCategory(new Category(id,name)));
        modelMap.addAttribute("active", name);
        return "list";
    }

    @ModelAttribute
    public SearchCriteria searchCriteria(){
        return new SearchCriteria();
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String showNews(ModelMap modelMap ){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("active", "news");
        return "news";
    }

    @RequestMapping(value = "/searchString", method = RequestMethod.POST)
    public String searchByString(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("productList", shopServiceInterface.searchProductBySearchString(searchCriteria.getSearchString()));
        return "list";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showAll(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        List<Category> categories = categoryServiceInterface.getCategories();
        modelMap.addAttribute("categoryList", categories);
        modelMap.addAttribute("productList", shopServiceInterface.getAllProducts());
        modelMap.addAttribute("active","main");
        return "list";
    }

    @RequestMapping(value = "/create",params ="form",method = RequestMethod.GET)
    public String createProduct(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("product", new ProductDto());
        modelMap.addAttribute("producersList", producerServiceInterface.getProducers());
        return "create";
    }

    @RequestMapping(value = "/create" ,params="form",method = RequestMethod.POST)
    public String createProductPost(@ModelAttribute SearchCriteria searchCriteria, @ModelAttribute("product") ProductDto productDto, @RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        productDto.setPhoto(file.getBytes());
        shopServiceInterface.addProduct(new Product(productDto));
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteProduct(@ModelAttribute SearchCriteria searchCriteria,@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        shopServiceInterface.removeProduct(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/showDetails/{id}",method = RequestMethod.GET)
    public String showProductDetails(@ModelAttribute SearchCriteria searchCriteria,@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        Product shown = shopServiceInterface.getProductById(id);
        modelMap.addAttribute("product", shown);
        return "showDetails";
    }
}
