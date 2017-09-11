package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.dto.ProductDto;
import spring.entities.Product;
import spring.objects.SearchCriteria;
import spring.services.CategoryServiceInterface;
import spring.services.ProducerServiceInterface;
import spring.services.ShopServiceInterface;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Eoller on 06-Sep-17.
 */
@Controller
public class ProductController {
    @Autowired
    private ShopServiceInterface shopServiceInterface;
    @Autowired
    private CategoryServiceInterface categoryServiceInterface;
    @Autowired
    private ProducerServiceInterface producerServiceInterface;

    @ModelAttribute
    public SearchCriteria searchCriteria(){
        return new SearchCriteria();
    }

    @RequestMapping(value = "/create",params ="form",method = RequestMethod.GET)
    public String createProduct(@ModelAttribute SearchCriteria searchCriteria, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("producerList", producerServiceInterface.getProducers());
        modelMap.addAttribute("product", new ProductDto());
        return "admin/create";
    }

    @RequestMapping(value = "/create" ,params="form",method = RequestMethod.POST)
    public String createProductPost(@ModelAttribute SearchCriteria searchCriteria, @ModelAttribute("product") ProductDto productDto, @RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        productDto.setPhoto(file.getBytes());
        shopServiceInterface.addProduct(new Product(productDto));
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteProduct(@ModelAttribute SearchCriteria searchCriteria, @PathVariable("id") Long id, ModelMap modelMap){
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

    @RequestMapping(value = "/showDetails/{id}", params="form", method = RequestMethod.GET)
    public String editForm(@ModelAttribute SearchCriteria searchCriteria,@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        Product shown = shopServiceInterface.getProductById(id);
        modelMap.addAttribute("product", shown);
        return "edit";
    }

    @RequestMapping(value = "/showDetails/{id}", params="form", method = RequestMethod.POST)
    public String editFormPost(@ModelAttribute("product") Product product,@ModelAttribute SearchCriteria searchCriteria, @PathVariable("id") Long id, ModelMap modelMap, HttpServletRequest httpServletRequest){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        //shopServiceInterface.updateProduct(product);
        modelMap.addAttribute("product", product);
        shopServiceInterface.addProduct(product);

        return "showDetails";
    }

}
