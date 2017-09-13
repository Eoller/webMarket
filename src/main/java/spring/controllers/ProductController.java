package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.dto.ProductDto;
import spring.entities.Category;
import spring.entities.Producer;
import spring.entities.Product;
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

    @RequestMapping(value = "/create", params = "form", method = RequestMethod.GET)
    public String createProduct(ModelMap modelMap) {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        modelMap.addAttribute("producerList", producerServiceInterface.getProducers());
        modelMap.addAttribute("product", new ProductDto());
        return "admin/create";
    }

    @RequestMapping(value = "/create", params = "form", method = RequestMethod.POST)
    public String createProductPost(@ModelAttribute("product") ProductDto productDto, @RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        productDto.setPhoto(file.getBytes());
        shopServiceInterface.addProduct(new Product(productDto));
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        shopServiceInterface.removeProduct(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/showDetails/{id}", method = RequestMethod.GET)
    public String showProductDetails(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        Product shown = shopServiceInterface.getProductById(id);
        modelMap.addAttribute("product", shown);
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
    public String editFormPost(@ModelAttribute("product") Product product, @PathVariable("id") Long id, ModelMap modelMap,@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        modelMap.addAttribute("categoryList", categoryServiceInterface.getCategories());
        Product changed = shopServiceInterface.getProductById(id);
        if (!httpServletRequest.getParameter("category").equals("0"))
            product.setCategoryId(new Category(Long.valueOf(httpServletRequest.getParameter("category")).longValue()));
        if (!httpServletRequest.getParameter("producer").equals("0"))
            product.setProducerId(new Producer(Long.valueOf(httpServletRequest.getParameter("producer")).longValue()));
        if(!file.isEmpty()){
            product.setPhoto(file.getBytes());
        }
        changed.changeVar(product);

        shopServiceInterface.updateProduct(changed);
        return "redirect:/showDetails/" + id;
    }

}
