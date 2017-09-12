package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.dto.ProductDto;
import spring.entities.Category;
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

    @RequestMapping(value = "/create",params ="form",method = RequestMethod.GET)
    public String createProduct(ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("producerList", producerServiceInterface.getProducers());
        modelMap.addAttribute("product", new ProductDto());
        return "admin/create";
    }

    @RequestMapping(value = "/create" ,params="form",method = RequestMethod.POST)
    public String createProductPost(@ModelAttribute("product") ProductDto productDto, @RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        productDto.setPhoto(file.getBytes());
        shopServiceInterface.addProduct(new Product(productDto));
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        shopServiceInterface.removeProduct(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/showDetails/{id}",method = RequestMethod.GET)
    public String showProductDetails(@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        Product shown = shopServiceInterface.getProductById(id);
        modelMap.addAttribute("product", shown);
        return "showDetails";
    }

    @RequestMapping(value = "/showDetails/{id}", params="form", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("product",shopServiceInterface.getProductById(id));
        return "edit";
    }

    @RequestMapping(value = "/showDetails/{id}", params="form", method = RequestMethod.POST)
    public String editFormPost(@ModelAttribute("product") Product product,@PathVariable("id") Long id, ModelMap modelMap, HttpServletRequest httpServletRequest){
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        //shopServiceInterface.updateProduct(product);
        Product shown = shopServiceInterface.getProductById(id);
        shown.setName(product.getName());
        shown.setPrice(product.getPrice());
        shown.setUniqueNumber(product.getUniqueNumber());
        shown.setDscr(product.getDscr());
        product.setCategoryId(new Category(1l));
        shown.setCategoryId(product.getCategoryId());
        shopServiceInterface.updateProduct(shown);
        return "redirect:/showDetails/" + id;
    }

}
