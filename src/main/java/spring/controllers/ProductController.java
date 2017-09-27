package spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.entities.Category;
import spring.entities.Producer;
import spring.entities.Product;
import spring.services.CategoryServiceInterface;
import spring.services.ProducerServiceInterface;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by Eoller on 06-Sep-17.
 */
@Controller
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ShopServiceInterface shopServiceInterface;
    @Autowired
    private CategoryServiceInterface categoryServiceInterface;
    @Autowired
    private ProducerServiceInterface producerServiceInterface;


    @RequestMapping(value = "/create", params = "form", method = RequestMethod.GET)
    public String createProduct(ModelMap modelMap) {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("producerList", producerServiceInterface.getProducers());
        modelMap.addAttribute("product", new Product());
        return "admin/create";
    }

    @RequestMapping(value = "/create", params = "form", method = RequestMethod.POST)
    public String createProductPost(@Valid @ModelAttribute("product") Product product, Errors errors,@RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        if(errors.hasErrors()){
            modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
            modelMap.addAttribute("producerList", producerServiceInterface.getProducers());
            return "admin/create";
        }
        product.setPhoto(file.getBytes());
        shopServiceInterface.addProduct(new Product(product));
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Long id, ModelMap modelMap) {
        shopServiceInterface.removeProduct(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/showDetails/{id}", method = RequestMethod.GET)
    public String showProductDetails(@PathVariable("id") Long id, ModelMap modelMap, HttpSession httpSession) {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        Product shown = shopServiceInterface.getProductById(id);
        modelMap.addAttribute("product", shown);
        logger.info("Atribute in HttpSession in /showDetails is {}", httpSession.getAttribute("categoryList"));
        return "showDetails";
    }

    /**
     * edit data from page(admin mode)
     */
    @RequestMapping(value = "/showDetails/{id}", params = "form", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("producerList", producerServiceInterface.getProducers());
        modelMap.addAttribute("product", shopServiceInterface.getProductById(id));
        return "edit";
    }

    @RequestMapping(value = "/showDetails/{id}", params = "form", method = RequestMethod.POST)
    public String editFormPost(@Valid @ModelAttribute("product") Product product,Errors errors, @PathVariable("id") Long id, ModelMap modelMap,@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        if(errors.hasErrors()){
            modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
            modelMap.addAttribute("producerList", producerServiceInterface.getProducers());
            return "edit";
        }
        if(!file.isEmpty()){
            product.setPhoto(file.getBytes());
        }
        shopServiceInterface.updateProduct(product);
        return "redirect:/showDetails/" + id;
    }

}
